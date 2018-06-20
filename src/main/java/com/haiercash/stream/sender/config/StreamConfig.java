package com.haiercash.stream.sender.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

/**
 * @author wangjy
 * @date 2018/5/19
 */

public interface StreamConfig {

    String OUT_CUST_INFO = "outCustInfo";

    String INPUT_CUST_INFO_LAUCH = "inputCustInfoLauch";

    @Output(OUT_CUST_INFO)
    MessageChannel outCustInfo();
/*

    @Input(INPUT_CUST_INFO_LAUCH)
    SubscribableChannel inCustInfo();*/
}
