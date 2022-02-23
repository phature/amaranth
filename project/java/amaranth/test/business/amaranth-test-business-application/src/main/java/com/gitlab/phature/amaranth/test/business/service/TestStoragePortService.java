package com.gitlab.phature.amaranth.test.business.service;

import com.gitlab.phature.amaranth.library.configuration.model.Constant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试存储端口服务类
 *
 * @author phature@qq.com
 */
@Service
@FeignClient(Constant.Microservice.TEST_STORAGE)
@RequestMapping(Constant.Path.TEST_STORAGE)
public interface TestStoragePortService {
    /**
     * 获取值
     *
     * @return 值
     */
    @RequestMapping("/port/get")
    String getValue();
}
