package phature.amaranth.simple.application.embed;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.utility.StringHandler;

import java.io.File;

/**
 * 应用类
 *
 * @author phature@qq.com
 * @date 2020-12-02
 * @date 2020-12-08
 */
public class Application {
    /**
     * 主函数
     *
     * @param arguments 参数
     */
    public static void main(String[] arguments) {
        File applicationFile = new File(Application.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        File rootDirectory = new File(
                StringHandler.connect(
                        ConfigurationConstant.Io.FILE_SEPARATOR,
                        applicationFile.getPath(),
                        ConfigurationConstant.Io.CLASSES_DIRECTORY
                )
        );
        ConfigurationVariate.setRootDirectory(rootDirectory);
        phature.amaranth.simple.framework.web.Application.start();
    }
}
