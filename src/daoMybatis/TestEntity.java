package daoMybatis;

import lombok.Getter;
import lombok.Setter;

/**
 * Testエンティティクラス
 *
 * @author jumborin
 */
public class TestEntity {
    /** ID */
    @Getter
    @Setter
    private String id = "";
    @Getter
    @Setter
    /** 名前 */
    private String name = "";
}
