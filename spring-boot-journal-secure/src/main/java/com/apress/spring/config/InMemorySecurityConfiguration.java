package com.apress.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.Authentication;

/**
 * Created by HeroDishonest on 30.04.2017.
 */
//@Configuration
//@EnableGlobalAuthentication
//public class InMemorySecurityConfiguration {
//
//    @Autowired
//    public void configureGlo(AuthenticationManagerBuilder builder) throws Exception{
//         builder.inMemoryAuthentication().withUser("user")
//                 .password("password")
//                 .roles("USER")
//                 .and()
//                 .withUser("admin")
//                 .password("password")
//                 .roles("USER","ADMIN");
//    }
//}
