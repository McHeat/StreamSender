package com.haiercash.stream.sender.controller;

import com.haiercash.stream.sender.stream.CustInfoConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjy
 * @date 2018/5/22
 */
@RestController
@RequestMapping(value = "/api/stream/sender")
public class CustInfoController {

    @Autowired
    private CustInfoConsumer custInfoConsumer;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startSend() {
        custInfoConsumer.onApplicationEvent();
        return "SUCCESS";
    }
}
