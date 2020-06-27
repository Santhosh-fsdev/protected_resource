package com.santhosh.protected_resource.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableWebSecurity
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/listall").access("#oauth2.hasScope('READ')")

                .and()
                .authorizeRequests().antMatchers("/insert").access("#oauth2.hasScope('WRITE') and hasAuthority('AUTHORITY_VENDOR')")
                .and()
                .authorizeRequests().antMatchers("/check").access("#oauth2.hasScope('WRITE') and hasAuthority('AUTHORITY_VENDOR')");
    }
}
