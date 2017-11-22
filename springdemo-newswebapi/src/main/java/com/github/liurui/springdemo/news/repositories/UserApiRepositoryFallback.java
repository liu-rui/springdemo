package com.github.liurui.springdemo.news.repositories;

import com.github.liurui.springdemo.user.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("userfallback")
public class UserApiRepositoryFallback implements UserApiRepository {
    @Override
    public User info(long id) {
        return new User(-1, "error");
    }

    @Override
    public String login(String name, String password) {
        return String.format("error %s %s", name, password);
    }
}
