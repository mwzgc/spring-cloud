package com.mwz.v1.controller;


import com.alibaba.fastjson.JSON;
import com.mwz.v1.entity.Greeting;
import com.mwz.v1.entity.HelloMessage;
import com.mwz.v1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mwz
 * @since 2020-02-24
 */
@Slf4j
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/ws")
    public String ws() {
        return "ws";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        log.info("WsController.greeting : {}", JSON.toJSONString(message));

        Greeting greeting = new Greeting();
        greeting.setContent("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        return greeting;
    }


    @GetMapping("/ws/send")
    @ResponseBody
    public void send(String topic) {
        if (StringUtils.isBlank(topic)) {
            topic = "greetings";
        }

        Greeting greeting = new Greeting();
        greeting.setContent("Hello, " + HtmlUtils.htmlEscape("Hello") + "!");
        messagingTemplate.convertAndSend("/topic/" + topic, JSON.toJSONString(greeting));
    }

}
