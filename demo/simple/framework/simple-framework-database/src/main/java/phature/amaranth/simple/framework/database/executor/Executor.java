package phature.amaranth.simple.framework.database.executor;

import phature.amaranth.simple.framework.database.statement.StatementBuilder;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 执行器接口
 *
 * @author phature@qq.com
 * @date 2020-12-22
 * @date 2020-12-23
 */
public interface Executor {
    /**
     * 获取语句构造器
     *
     * @return 语句构造器
     */
    StatementBuilder getStatementBuilder();

    /**
     * 设置
     *
     * @param statementBuilder
     */
    void setStatementBuilder(StatementBuilder statementBuilder);

    /**
     * 运行
     *
     * @param preparedStatement 预处理语句
     * @return 结果
     * @throws SQLException SQL异常
     */
    boolean run(PreparedStatement preparedStatement) throws SQLException;
}
