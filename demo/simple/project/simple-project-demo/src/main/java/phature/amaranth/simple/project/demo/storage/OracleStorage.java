package phature.amaranth.simple.project.demo.storage;

import phature.amaranth.simple.framework.database.Database;
import phature.amaranth.simple.framework.database.executor.ValueQueryExecutor;
import phature.amaranth.simple.project.demo.storage.result.DateResultBuilder;
import phature.amaranth.simple.project.demo.storage.statement.NowStatementBuilder;

import java.util.Date;

/**
 * 数据库存储类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class OracleStorage implements DatabaseStorage {
    @Override
    public Date now() {
        ValueQueryExecutor<Date> executor = new ValueQueryExecutor<>();
        executor.setStatementBuilder(new NowStatementBuilder());
        executor.setResultBuilder(new DateResultBuilder());
        Database database = new Database();
        database.execute(StorageConstant.DEFAULT_INSTANCE, executor);

        return executor.getResult();
    }
}
