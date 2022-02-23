package com.jojoldu.book_real.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final CustomOAuth2UserService customOAuth2UserService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//    }

}
