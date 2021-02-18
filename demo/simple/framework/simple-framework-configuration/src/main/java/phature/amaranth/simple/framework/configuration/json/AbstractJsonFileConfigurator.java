package phature.amaranth.simple.framework.configuration.json;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.utility.StringHandler;
import phature.amaranth.simple.framework.utility.io.FileHandler;
import phature.amaranth.simple.framework.utility.io.ResourceHandler;

import java.io.File;

/**
 * JSON文件配置器抽象类
 *
 * @param <ConfigurationClass> 配置类
 * @author phature@qq.com
 * @date 2020-12-04
 * @date 2020-12-08
 */
public abstract class AbstractJsonFileConfigurator<ConfigurationClass> extends AbstractJsonConfigurator<ConfigurationClass> {
    /**
     * 获取名称
     *
     * @return 名称
     */
    protected String getName() {
        return StringHandler.connect(
                ConfigurationConstant.Io.EMPTY_SEPARATOR,
                getConfigurationClass().getName(),
                ConfigurationConstant.Io.JSON_POSTFIX
        );
    }

    /**
     * 获取文件
     *
     * @return 文件
     */
    protected File getFile() {
        return new File(
                StringHandler.connect(
                        ConfigurationConstant.Io.FILE_SEPARATOR,
                        ConfigurationVariate.getRootDirectory().getPath(),
                        ConfigurationConstant.Io.CONFIGURATION_DIRECTORY,
                        getName()
                )
        );
    }

    /**
     * 获取资源
     *
     * @return 资源
     */
    protected String getResource() {
        return StringHandler.connect(
                ConfigurationConstant.Io.RESOURCE_SEPARATOR,
                ConfigurationVariate.getRootResource(),
                ConfigurationConstant.Io.CONFIGURATION_DIRECTORY,
                getName()
        );
    }

    @Override
    protected String in() {
        String result;

        if (getFile().exists()) {
            result = FileHandler.read(getFile());
        } else {
            result = ResourceHandler.read(getResource());
        }

        return result;
    }

    @Override
    protected void out(String json) {
        FileHandler.write(getFile(), json);
    }
}
