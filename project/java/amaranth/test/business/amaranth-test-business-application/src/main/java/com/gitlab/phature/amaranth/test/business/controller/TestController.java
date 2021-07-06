package com.gitlab.phature.amaranth.test.business.controller;

import com.gitlab.phature.amaranth.library.configuration.model.Constant;
import com.gitlab.phature.amaranth.test.business.service.TestStoragePortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器类
 *
 * @author phature@qq.com
 */
@RestController
@RequestMapping(Constant.Path.TEST_BUSINESS)
public class TestController {
    private String message;
    private TestStoragePortService testStoragePortService;

    /**
     * 获取消息
     *
     * @return 消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置消息
     *
     * @param message 消息
     */
    @Value("${test.message}")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取测试存储端口服务
     *
     * @return 测试存储端口服务
     */
    public TestStoragePortService getTestStoragePortService() {
        return testStoragePortService;
    }

    /**
     * 设置测试存储端口服务
     *
     * @param testStoragePortService 测试存储端口服务
     */
    @Autowired
    public void setTestStoragePortService(TestStoragePortService testStoragePortService) {
        this.testStoragePortService = testStoragePortService;
    }

    /**
     * 消息
     *
     * @return 结果
     */
    @RequestMapping(value = "/test/message", method = RequestMethod.GET)
    public String message() {
        return getMessage();
    }

    /**
     * 端口
     *
     * @return 结果
     */
    @RequestMapping(value = "/test/port", method = RequestMethod.GET)
    public String port() {
        return getTestStoragePortService().getValue();
    }
}
