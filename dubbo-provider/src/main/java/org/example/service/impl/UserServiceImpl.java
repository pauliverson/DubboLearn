package org.example.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.example.pojo.User;
import org.example.service.UserService;

/**
 * 用户管理服务
 * 		timeout 调用该服务的超时时间
 * 		version 为版本号
 * 		group 为分组
 * 	    interface、group、version 三者可确定一个服务
 * 	    parameters = {"unicast", "false"}
 * 	        建议服务提供者和服务消费者在不同机器上运行，
 * 	        如果在同一机器上，需设置 unicast = false 禁用单播订阅，只有 multicast 注册中心有此问题。
 * @author 4paradigm
 */
@Service(timeout = 5000, version = "1.0", group = "user-provider", parameters = {"unicast", "false"})
public class UserServiceImpl implements UserService {
    @Override
    public User selectUserById(Integer userId) {
        System.out.println("用户管理服务接收到客户端请求，请求参数 userId = " + userId);
        return new User(userId, "张三");
    }
}
