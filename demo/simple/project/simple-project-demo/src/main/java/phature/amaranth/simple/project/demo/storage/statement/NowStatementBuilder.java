package phature.amaranth.simple.project.demo.storage.statement;

import phature.amaranth.simple.framework.database.statement.StatementBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 当前时间语句构造器类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class NowStatementBuilder implements StatementBuilder {
    @Override
    public PreparedStatement build(Connection connection) throws SQLException {
        return connection.prepareStatement("SELECT SYSTIMESTAMP FROM DUAL");
    }
}
