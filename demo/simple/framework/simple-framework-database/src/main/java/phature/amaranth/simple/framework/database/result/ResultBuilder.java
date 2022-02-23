package phature.amaranth.simple.framework.database.result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * 结果构造器抽象类
 *
 * @param <Entity> 实体类
 * @author phature@qq.com
 * @date 2020-12-23
 * @date 2020-12-24
 */
public interface ResultBuilder<Entity> {
    /**
     * 获取唯一值
     *
     * @param entity 值
     * @return 唯一值
     */
    String getUnique(Entity entity);

    /**
     * 获取映射
     *
     * @param capacity 容量
     * @return 映射
     */
    Map<String, Entity> getMap(int capacity);

    /**
     * 构建
     *
     * @param resultSet 结果集合
     * @return 结果
     * @throws SQLException SQL异常
     */
    Entity build(ResultSet resultSet) throws SQLException;
}
