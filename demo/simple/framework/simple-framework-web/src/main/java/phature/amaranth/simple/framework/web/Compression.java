package phature.amaranth.simple.framework.web;

/**
 * 压缩枚举
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-07
 */
public enum Compression {
    /**
     * 启动
     */
    ON("on"),
    /**
     * 强制
     */
    FORCE("force"),
    /**
     * 禁用
     */
    OFF("off");

    private final String value;

    /**
     * 获取值
     *
     * @return 值
     */
    public String getValue() {
        return value;
    }

    Compression(String value) {
        this.value = value;
    }
}