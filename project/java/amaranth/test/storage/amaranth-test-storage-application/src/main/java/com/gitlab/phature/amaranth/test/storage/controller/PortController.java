package com.gitlab.phature.amaranth.test.storage.controller;

import com.gitlab.phature.amaranth.library.configuration.model.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 端口控制器类
 *
 * @author phature@qq.com
 */
@RestController
@RequestMapping(Constant.Path.TEST_STORAGE)
public class PortController {
    private int value;

    /**
     * 获取值
     *
     * @return 值
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    @Value("${server.port}")
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 端口
     *
     * @return 结果
     */
    @RequestMapping(value = "/port/get", method = RequestMethod.GET)
    public String get() {
        return Integer.toString(getValue());
    }
}
