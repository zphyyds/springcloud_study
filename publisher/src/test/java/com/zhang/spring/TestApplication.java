package com.zhang.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zph
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send(){
        String exchange = "itcast.exchange";
        String msg = "Hello every one";
        rabbitTemplate.convertAndSend(exchange,"",msg);
    }


    @Test
    public void send1(){
        String exchange = "itcast.direct";
        String msg = "Hello red";
        rabbitTemplate.convertAndSend(exchange,"red",msg);
    }

    @Test
    public void send2(){
        String exchange = "itcast.topic";
        String msg = "今天的天气不错，我心情很好";
        rabbitTemplate.convertAndSend(exchange,"china.weather",msg);
    }

    @Test
    public void send3(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",13);
        rabbitTemplate.convertAndSend("object.queue",map);
    }
}
