package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.得到userService的访问路径,直接调用服务名称
        String url = "http://user-service/user/" + order.getUserId();
        //向UserService发送Http请求得到User数据，传入User的class对象将UserJson数据反序列化成User对象
        User user = restTemplate.getForObject(url, User.class);
        //封装查询到的user对象
        order.setUser(user);
        // 4.返回
        return order;
    }
}
