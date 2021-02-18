package phature.amaranth.simple.framework.database.executor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 列表查询执行器类
 *
 * @param <Entity> 实体类
 * @author phature@qq.com
 * @date 2020-12-22
 * @date 2020-12-24
 */
public class ListQueryExecutor<Entity> extends AbstractQueryExecutor<Entity> {
    private List<Entity> resultValue;

    /**
     * 获取结果
     *
     * @return 结果
     */
    public List<Entity> getResult() {
        return resultValue;
    }

    @Override
    public boolean run(PreparedStatement preparedStatement) throws SQLException {
        boolean result = false;

        ResultSet resultSet = preparedStatement.executeQuery();

        if (null != resultSet) {
            resultValue = new ArrayList<>();
            Entity entity;
            while (resultSet.next()) {
                entity = getResultBuilder().build(resultSet);
                if (null != entity) {
                    resultValue.add(entity);
                }
            }

            result = true;
        }

        return result;
    }
}
