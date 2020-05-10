package com.mwz.v1.kafka;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {

    private Long id;    //id

    private String msg; //消息

    private LocalDateTime sendTime;  //时间戳

}
