package com.santhosh.protected_resource.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@EnableWebSecurity
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/listall").access("#oauth2.hasScope('READ')")

                .and()
                .authorizeRequests().antMatchers("/insert").access("#oauth2.hasScope('WRITE') and hasAuthority('VENDOR')")
                .and()
                .authorizeRequests().antMatchers("/check").access("#oauth2.hasScope('WRITE') and hasAuthority('VENDOR')");
    }

//    @Primary
//    @Bean
//    public RemoteTokenServices tokenService() {
//        RemoteTokenServices tokenService = new RemoteTokenServices();
//        tokenService.setCheckTokenEndpointUrl(
//                "http://localhost:8080/oauth/check_token");
//        tokenService.setClientId("bala");
//        tokenService.setClientSecret("bala");
//        return tokenService;
//    }
}
