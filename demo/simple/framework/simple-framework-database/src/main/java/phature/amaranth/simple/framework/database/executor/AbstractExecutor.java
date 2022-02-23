package phature.amaranth.simple.framework.database.executor;

import phature.amaranth.simple.framework.database.statement.StatementBuilder;

/**
 * 执行器抽象类
 *
 * @author phature@qq.com
 * @date 2020-12-22
 * @date 2020-12-23
 */
public abstract class AbstractExecutor implements Executor {
    private StatementBuilder statementBuilder;

    @Override
    public StatementBuilder getStatementBuilder() {
        return statementBuilder;
    }

    @Override
    public void setStatementBuilder(StatementBuilder statementBuilder) {
        this.statementBuilder = statementBuilder;
    }
}
