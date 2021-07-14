package com.hx.hystrix.service;

import com.hx.hystrix.factory.ProviderClientFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//添加一个后备工厂，在失败时使用
@FeignClient(value = "TEST-HYSTRIX-PROVIDER", fallbackFactory = ProviderClientFactory.class)
@RequestMapping("/provider")
public interface ProviderClient {

    @GetMapping("get/{num}")
    String get(@PathVariable("num") String num);
}