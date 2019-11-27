package com.onebooming.boecloudservice.utils;

import com.onebooming.boecloudservice.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Onebooming
 * @apiNote 获取当前登录用户
 */
public class Util {
    public static User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
