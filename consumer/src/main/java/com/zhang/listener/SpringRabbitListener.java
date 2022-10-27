package com.zhang.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zph
 * @version 1.0
 */
@Component
public class SpringRabbitListener {

//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue(String msg){
//        System.out.println("在simple.queue中接收到的消息为:"+msg);
//    }


    @RabbitListener(queues = "itcast.queue1")
    public void ListenSimpleQueue1(String msg) {
        System.out.println("itcast.queue1中接收到的消息为:" + msg);
    }

    @RabbitListener(queues = "itcast.queue2")
    public void ListenSimpleQueue2(String msg) {
        System.out.println("itcast.queue2中接收到的消息为:" + msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    )
    )
    public void listenerDirectQueue1(String msg) {
        System.out.println("在direct.queue1中接收到的消息为:" + msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    )
    )
    public void listenerDirectQueue2(String msg) {
        System.out.println("在direct.queue2中接收到的消息为:" + msg);
    }



    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "itcast.topic", type = ExchangeTypes.TOPIC),
            key = {"china.#"}
    )
    )
    public void listenerTopicQueue1(String msg) {
        System.out.println("在topic.queue1中接收到的消息为:" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "itcast.topic", type = ExchangeTypes.TOPIC),
            key = {"#.news"}
    )
    )
    public void listenerTopicQueue2(String msg) {
        System.out.println("在topic.queue2中接收到的消息为:" + msg);
    }

    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String,Object> map){
        System.out.println("从Object.queue接收到的消息是:"+map);
    }
}
