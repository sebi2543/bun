package com.example.demo.security;

import org.springframework.security.core.userdetails.User;

public enum  ApplicationUserPermission {
     INSTRUCTOR_READ("instructor:read"),
     INSTRUCTOR_WRITE("instructor:write"),
     COURSE_READ("course:read"),
     COURSE_WRITE("course:write"),
     USER_READ("user:read"),
     USER_WRITE("user:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
}
