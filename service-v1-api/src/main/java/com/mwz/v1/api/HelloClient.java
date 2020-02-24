package com.mwz.v1.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-v1")
public interface HelloClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello();

}