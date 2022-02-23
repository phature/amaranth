package phature.amaranth.simple.framework.database.configuration;

/**
 * Hikari实例类
 *
 * @author phature@qq.com
 * @date 2020-12-22
 * @date 2020-12-25
 */
public class HikariInstance {
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;

    /**
     * 获取URL
     *
     * @return URL
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * 设置URL
     *
     * @param jdbcUrl URL
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * 获取用户
     *
     * @return 用户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户
     *
     * @param username 用户
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取驱动类名
     *
     * @return 驱动类名
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * 设置驱动类名
     *
     * @param driverClassName 驱动类名
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
