package com.apress.spring.config;

import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by HeroDishonest on 30.04.2017.
 */
@Configuration
@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate){
        RowMapper<User> userRowMapper = (resultSet, i) -> new User(resultSet.getString("ACCOUNT_NAME"),resultSet.getString("PASSWORD"),
                resultSet.getBoolean("ENABLED"),
                resultSet.getBoolean("ENABLED"),
                resultSet.getBoolean("ENABLED"),
                resultSet.getBoolean("ENABLED"),
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
        return username -> jdbcTemplate.queryForObject("SELECT * from ACCOUNT where ACCOUNT_NAME = ?",
                userRowMapper, username);
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }
}
