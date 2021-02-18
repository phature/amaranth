package phature.amaranth.simple.framework.database.executor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 值查询执行器类
 *
 * @param <Entity> 实体类
 * @author phature@qq.com
 * @date 2020-12-23
 * @date 2020-12-24
 */
public class ValueQueryExecutor<Entity> extends AbstractQueryExecutor<Entity> {
    private Entity resultValue;

    /**
     * 获取结果
     *
     * @return 结果
     */
    public Entity getResult() {
        return resultValue;
    }

    @Override
    public boolean run(PreparedStatement preparedStatement) throws SQLException {
        boolean result = false;

        ResultSet resultSet = preparedStatement.executeQuery();

        if (null != resultSet) {
            while (resultSet.next()) {
                resultValue = getResultBuilder().build(resultSet);
                if (null != resultValue) {
                    break;
                }
            }

            result = true;
        }

        return result;
    }
}
