package com.onebooming.boecloudservice.common;

import com.onebooming.boecloudservice.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Onebooming
 */
public class UserUtils {
    public static User getCurrentHr() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
