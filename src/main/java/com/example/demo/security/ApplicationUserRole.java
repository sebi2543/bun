package com.example.demo.security;

import com.google.common.collect.Sets;
import com.example.demo.security.ApplicationUserPermission.*;
import java.util.Set;

import static com.example.demo.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
   USER(Sets.newHashSet()),
   ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,INSTRUCTOR_READ,INSTRUCTOR_WRITE,USER_READ,USER_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
