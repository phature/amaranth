package phature.amaranth.simple.framework.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.database.executor.Executor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库类
 *
 * @author phature@qq.com
 * @date 2020-12-21
 * @date 2020-12-24
 */
public class Database {
    private final static Logger logger = LoggerFactory.getLogger(Database.class);

    /**
     * 执行
     *
     * @param instance    实例
     * @param transaction 事务
     * @param executors   执行器集合
     * @return 结果
     */
    public int execute(String instance, int transaction, List<Executor> executors) {
        int result = 0;

        if (DatabaseVariate.getDataSources().containsKey(instance)) {
            DataSource dataSource = DatabaseVariate.getDataSources().get(instance);
            if (null != dataSource && null != executors && executors.size() > 0) {
                Connection connection = null;
                PreparedStatement preparedStatement;
                try {
                    try {
                        boolean done = false;
                        connection = dataSource.getConnection();
                        connection.setAutoCommit(false);
                        connection.setTransactionIsolation(transaction);
                        for (Executor executor : executors) {
                            if (null != executor) {
                                preparedStatement = executor.getStatementBuilder().build(connection);
                                done = executor.run(preparedStatement);
                                preparedStatement.close();
                                if (done) {
                                    result++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (done) {
                            connection.commit();
                        } else {
                            connection.rollback();
                        }
                    } catch (SQLException sqlException) {
                        if (null != connection) {
                            connection.rollback();
                        }
                        logger.error(sqlException.getMessage(), sqlException);
                    } finally {
                        if (null != connection) {
                            connection.close();
                        }
                    }
                } catch (SQLException exception) {
                    logger.error(exception.getMessage(), exception);
                }
            }
        }

        return result;
    }

    /**
     * 执行
     *
     * @param instance       实例
     * @param executors 执行器集合
     * @return 结果
     */
    public int execute(String instance, List<Executor> executors) {
        int result = 0;

        if (DatabaseVariate.getDataSources().containsKey(instance)) {
            DataSource dataSource = DatabaseVariate.getDataSources().get(instance);
            if (null != dataSource && null != executors && executors.size() > 0) {
                Connection connection = null;
                PreparedStatement preparedStatement;
                try {
                    try {
                        boolean done;
                        connection = dataSource.getConnection();
                        connection.setAutoCommit(false);
                        for (Executor executor : executors) {
                            if (null != executor) {
                                preparedStatement = executor.getStatementBuilder().build(connection);
                                done = executor.run(preparedStatement);
                                preparedStatement.close();
                                if (done) {
                                    result++;
                                }
                            }
                        }
                        connection.commit();
                    } catch (SQLException sqlException) {
                        logger.error(sqlException.getMessage(), sqlException);
                    } finally {
                        if (null != connection) {
                            connection.close();
                        }
                    }
                } catch (SQLException exception) {
                    logger.error(exception.getMessage(), exception);
                }
            }
        }

        return result;
    }

    /**
     * 执行
     *
     * @param instance         实例
     * @param transaction 事务
     * @param executor    执行器
     * @return 结果
     */
    public int execute(String instance, int transaction, Executor executor) {
        List<Executor> executors = new ArrayList<>();
        executors.add(executor);
        return execute(instance, transaction, executors);
    }

    /**
     * 执行
     *
     * @param instance      实例
     * @param executor 执行器
     * @return 结果
     */
    public int execute(String instance, Executor executor) {
        List<Executor> executors = new ArrayList<>();
        executors.add(executor);
        return execute(instance, executors);
    }
}
