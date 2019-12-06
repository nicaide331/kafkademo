package com.zr.kafkademo.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zr.kafkademo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月06日 17:54:00
 */
@Component
@Slf4j
public class KafkaSender {

    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("zhisheng", gson.toJson(message));
    }
}