package phature.amaranth.simple.framework.database.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 语句构造器接口
 *
 * @author phature@qq.com
 * @date 2020-12-23
 * @date 2020-12-24
 */
public interface StatementBuilder {
    /**
     * 构建
     *
     * @param connection 连接
     * @return 结果
     * @throws SQLException SQL异常
     */
    PreparedStatement build(Connection connection) throws SQLException;
}
