package com.doofy.bean;

import lombok.Data;

import java.util.Date;

@Data
public class KafkaMessage<T> {
    private Long id;    //id
    private T msg; //消息
    private Date sendTime;  //时间戳
}