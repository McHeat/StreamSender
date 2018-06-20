package com.haiercash.stream.sender.stream;

import com.haiercash.stream.sender.config.StreamConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjy
 * @date 2018/5/19
 */
@Service
public class CustInfoConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CustInfoConsumer.class);

    @Value("${file.name}")
    private String filePath;

    @Autowired
    private StreamConfig streamConfig;

    @Scheduled(cron = "0 15 17 * * *")
    public void onApplicationEvent() {
        logger.info("文件路径：{}", filePath);
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");

                Map<String, String> map = new HashMap<>();
                map.put("CustNo", info[0]);
                map.put("CustName", info[1]);
                map.put("IdNo", info[2]);
                logger.info("消息内容：{}", map);
                MessageBuilder<Map> msg = MessageBuilder.withPayload(map);
                streamConfig.outCustInfo().send(msg.build());
            }
        } catch (Exception e) {
            logger.error("抛出异常", e);
        }
    }
}
