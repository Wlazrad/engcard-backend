package com.wlazrad.config.database;

import com.wlazrad.models.User;
import com.wlazrad.repository.UserRepository;
import com.wlazrad.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
//@RequiredArgsConstructor
//public class SpringSecurityAuditorAware implements AuditorAware<User> {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public Optional<User> getCurrentAuditor() {
//        String userLogin = SecurityUtils.getCurrentUserLogin();
//        if (userLogin == null) {
//            return Optional.empty();
//        }
//        return userRepository.findByUsername(SecurityUtils.getCurrentUserLogin());
//    }
//}
