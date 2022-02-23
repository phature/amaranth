package phature.amaranth.simple.project.demo.controller;

import phature.amaranth.simple.framework.ioc.Inject;
import phature.amaranth.simple.project.demo.storage.DatabaseStorage;

import java.util.Date;

/**
 * 数据库控制器类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class DatabaseController {
    /**
     * 当前时间
     *
     * @return 结果
     */
    public Date now() {
        DatabaseStorage databaseStorage = Inject.instance(DatabaseStorage.class);
        return databaseStorage.now();
    }
}
