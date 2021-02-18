package phature.amaranth.simple.framework.web.configuration;

import java.util.List;

/**
 * 过滤器配置类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-07
 */
public class FilterConfiguration {
    private String name;
    private List<String> patterns;
    private String dispatcher;

    /**
     * 获取名字
     *
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取模式集合
     *
     * @return 模式集合
     */
    public List<String> getPatterns() {
        return patterns;
    }

    /**
     * 设置模式集合
     *
     * @param patterns 模式集合
     */
    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    /**
     * 获取调度器
     *
     * @return 调度器
     */
    public String getDispatcher() {
        return dispatcher;
    }

    /**
     * 设置调度器
     *
     * @param dispatcher 调度器
     */
    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }
}