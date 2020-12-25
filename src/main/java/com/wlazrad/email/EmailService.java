package com.wlazrad.email;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService (@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }



}
