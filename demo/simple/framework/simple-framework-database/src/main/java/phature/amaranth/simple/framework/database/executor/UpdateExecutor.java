package phature.amaranth.simple.framework.database.executor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 更新执行器类
 *
 * @author phature@qq.com
 * @date 2020-12-23
 * @date 2020-12-23
 */
public class UpdateExecutor extends AbstractExecutor {
    private int resultValue;

    /**
     * 获取结果
     *
     * @return 结果
     */
    public int getResult() {
        return resultValue;
    }

    @Override
    public boolean run(PreparedStatement preparedStatement) throws SQLException {
        boolean result = false;

        resultValue = preparedStatement.executeUpdate();
        if (resultValue >= 0) {
            result = true;
        }

        return result;
    }
}
