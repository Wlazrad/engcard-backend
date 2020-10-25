package com.wlazrad.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

    public static String getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                userName = springSecurityUser.getUsername().toLowerCase();
            } else if (authentication.getPrincipal() instanceof String) {
                userName = ((String) authentication.getPrincipal()).toLowerCase();
            } else if (authentication.getDetails() != null && authentication.getDetails() instanceof UserDetails) {
                return ((User) authentication.getDetails()).getUsername().toLowerCase();
            }
        }
        return userName != null ? userName.toLowerCase() : null;
    }
}
