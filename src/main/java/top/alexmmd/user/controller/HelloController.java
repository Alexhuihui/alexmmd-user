package top.alexmmd.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.alexmmd.user.domain.User;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestBody User user) {
        return "Hello " + user.getUsername() + " !";
    }

}
