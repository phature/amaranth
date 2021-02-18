package phature.amaranth.simple.framework.database.executor;

import phature.amaranth.simple.framework.database.result.ResultBuilder;

/**
 * 查询执行器抽象类
 *
 * @param <Entity> 实体类
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public abstract class AbstractQueryExecutor<Entity> extends AbstractExecutor {
    private ResultBuilder<Entity> resultBuilder;

    /**
     * 获取结果构造器
     *
     * @return 结果构造器
     */
    public ResultBuilder<Entity> getResultBuilder() {
        return resultBuilder;
    }

    /**
     * 设置结果构造器
     *
     * @param resultBuilder 结果构造器
     */
    public void setResultBuilder(ResultBuilder<Entity> resultBuilder) {
        this.resultBuilder = resultBuilder;
    }
}
