package phature.amaranth.simple.framework.web.configuration;

import java.util.List;

/**
 * HTTP服务配置类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-08
 */
public class HttpServletConfiguration {
    private String name;
    private List<String> patterns;

    /**
     * 获取名称
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
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
}
