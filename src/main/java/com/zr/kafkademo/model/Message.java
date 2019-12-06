package com.zr.kafkademo.model;

import lombok.Data;

import java.util.Date;

/**
 * 描述
 *
 * @author nicaide
 * @date 2019年12月06日 17:51:00
 */
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

}