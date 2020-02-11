package dbunitUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

/**
 * DBUnitを利用する際のユーティリティクラス。利用条件：H2DBとDBUnitが必要。
 *
 * @author jumborin
 */
public class DbUnitUtil {

    /** データベーステスター */
    private static IDatabaseTester databaseTester;

    /** DatabaseのJDBCドライバークラス */
    private static final String DRIVER_CLASS = "org.h2.Driver";

    /** DatabaseのDB接続URL */
    private static final String CONNECTION_URL = "jdbc:h2:~/test";

    /** Databaseのユーザ */
    private static final String USER_NAME = "sa";

    /** Databaseのパスワード */
    private static final String PASSWORD = "";

    /** Databaseのスキーマ */
    private static final String SCHEMA = "";

    /**
     * DB初期化処理(スキーマなし)
     *
     * @param initDbXmlFileName
     * @throws MalformedURLException
     * @throws DataSetException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static void setUpNonExistSchema(final String initDbXmlFileName)
	    throws MalformedURLException, DataSetException, ClassNotFoundException, Exception {
	databaseTester = new JdbcDatabaseTester(DRIVER_CLASS, CONNECTION_URL, USER_NAME, PASSWORD);
	setUpCommon(initDbXmlFileName);
    }

    /**
     * DB初期化処理(スキーマあり)
     *
     * @param initDbXmlFileName 初期化用XMLファイル名
     * @throws MalformedURLException
     * @throws DataSetException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static void setUpExistSchema(final String initDbXmlFileName)
	    throws MalformedURLException, DataSetException, ClassNotFoundException, Exception {
	databaseTester = new JdbcDatabaseTester(DRIVER_CLASS, CONNECTION_URL, USER_NAME, PASSWORD, SCHEMA);
	setUpCommon(initDbXmlFileName);
    }

    /**
     * DB初期化処理(共通)
     *
     * @param initDbXmlFileName 初期化用XMLファイル名
     * @throws MalformedURLException
     * @throws DataSetException
     * @throws Exception
     */
    private static void setUpCommon(final String initDbXmlFileName)
	    throws MalformedURLException, DataSetException, Exception {
	IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File(initDbXmlFileName));
	databaseTester.setDataSet(dataSet);
	databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
	databaseTester.onSetup();
    }

    /**
     * DB終了処理
     *
     * @throws Exception
     */
    public static void tearDown() throws Exception {
	databaseTester.setTearDownOperation(DatabaseOperation.NONE);
	databaseTester.onTearDown();
    }

    /**
     * 想定する結果と実際のテーブルの値をチェックする
     *
     * @param expectedXmlFile 想定する結果を記載したXMLファイル名
     * @param tableName       チェック対象のテーブル
     * @param dateColumnArray 除外する列名の配列
     * @throws SQLException
     * @throws MalformedURLException
     * @throws DatabaseUnitException
     * @throws Exception
     */
    public static void check(final String expectedDbXmlFile, final String tableName, final String[] dateColumnArray)
	    throws SQLException, MalformedURLException, DatabaseUnitException, Exception {

	// 想定するテーブル値
	IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File(expectedDbXmlFile));
	ITable expectedTable = expectedDataSet.getTable(tableName);

	// 実際のテーブル値
	IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
	ITable actualTable = databaseDataSet.getTable(tableName);

	// 時間に対するAssertionはほぼ確実に失敗するので検証対象から除外する
	ITable filteredExpectedTable = DefaultColumnFilter.excludedColumnsTable(expectedTable, dateColumnArray);
	ITable filteredActualTable = DefaultColumnFilter.excludedColumnsTable(actualTable, dateColumnArray);

	// チェック処理
	Assertion.assertEquals(filteredExpectedTable, filteredActualTable);
    }
}
