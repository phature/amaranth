package phature.amaranth.simple.framework.database.executor;

import phature.amaranth.simple.framework.utility.StringHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * 映射查询执行器类
 *
 * @param <Entity> 实体类
 * @author phature@qq.com
 * @date 2020-12-23
 * @date 2020-12-24
 */
public class MapQueryExecutor<Entity> extends AbstractQueryExecutor<Entity> {
    private Map<String, Entity> resultValue;

    /**
     * 获取结果
     *
     * @return 结果
     */
    public Map<String, Entity> getResult() {
        return resultValue;
    }

    @Override
    public boolean run(PreparedStatement preparedStatement) throws SQLException {
        boolean result = false;

        ResultSet resultSet = preparedStatement.executeQuery();

        if (null != resultSet) {
            resultValue = getResultBuilder().getMap(resultSet.getRow());
            String key;
            Entity value;
            while (resultSet.next()) {
                value = getResultBuilder().build(resultSet);
                if (null != value) {
                    key = getResultBuilder().getUnique(value);
                    if (!StringHandler.empty(key)) {
                        resultValue.put(key, value);
                    }
                }
            }

            result = true;
        }

        return result;
    }
}
