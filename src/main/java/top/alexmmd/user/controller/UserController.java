package top.alexmmd.user.controller;


import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.alexmmd.user.domain.User;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/currentUser")
    public User currentUser(HttpServletRequest request) {
        // 从Header中获取用户信息
        String userStr = request.getHeader("user");
        JSONObject userJsonObject = new JSONObject(userStr);
        return User.builder()
                .username(userJsonObject.getStr("user_name"))
                .id(Convert.toLong(userJsonObject.get("id")))
                .roles(Convert.toList(String.class, userJsonObject.get("authorities"))).build();
    }

}
