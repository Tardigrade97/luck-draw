package com.example.luckydomain.user;

import com.example.config.exception.ldException;
import lombok.Getter;

import java.util.Objects;

@Getter
public class UserName {
    private String username;

    public UserName(String username) {
        if (Objects.isNull(username)){
            throw new ldException("账户不能为空");
        }
        this.username = username;
    }
}
