package org.example.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class UserController {

    // dubbo 提供了 @Reference 注解，可替换 @Autowired 注解，用于引入远程服务
    // 如果注册服务时设置了版本及分组信息，调用远程服务时也要设置对应的版本及分组信息
    @Reference(timeout = 5000, version = "1.0", group = "user-provider", parameters = {"unicast", "false"})
    private UserService userService;

    @GetMapping("/{id}")
    public User selectUserById(@PathVariable("id") Integer id) {
        return userService.selectUserById(id);
    }

}
