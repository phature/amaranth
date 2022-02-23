package phature.amaranth.simple.project.demo.storage.result;

import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.database.result.ResultBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期结果构造器类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class DateResultBuilder implements ResultBuilder<Date> {
    private final static int VALUE = 1;

    @Override
    public String getUnique(Date date) {
        return ConfigurationVariate.getDateFormat().format(date);
    }

    @Override
    public Map<String, Date> getMap(int capacity) {
        return new HashMap<>(capacity);
    }

    @Override
    public Date build(ResultSet resultSet) throws SQLException {
        return resultSet.getTimestamp(VALUE);
    }
}
