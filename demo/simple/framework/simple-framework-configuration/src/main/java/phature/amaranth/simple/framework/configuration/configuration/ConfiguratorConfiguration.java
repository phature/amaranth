package phature.amaranth.simple.framework.configuration.configuration;

import java.util.List;

/**
 * 配置器配置类
 *
 * @author phature@qq.com
 * @date 2020-12-16
 * @date 2020-12-16
 */
public class ConfiguratorConfiguration {
    private List<String> classNames;

    /**
     * 获取类名集合
     *
     * @return 类名集合
     */
    public List<String> getClassNames() {
        return classNames;
    }

    /**
     * 设置类名集合
     *
     * @param classNames 类名集合
     */
    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }
}
