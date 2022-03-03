package com.jojoldu.book_real.springboot.config.auth;

import com.jojoldu.book_real.springboot.config.auth.CustomOAuth2UserService;
import com.jojoldu.book_real.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // Spring Security 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()   //h2-console 화면을 사용하기 위해 해당 옵션들을 disable함.
                .and()
                .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점, 이게 선언돼야 antMatchers옵션 사용가능
                .antMatchers("/", "/css/**", "/images/**",
                        "/js/**", "h2-console/**").permitAll()
                .antMatchers("/api/v1").hasRole(Role.USER.name()) // 권한 관리대상을 지정하는 옵션
                .anyRequest().authenticated()  //설정값 이외에 나머지 URL들을 나타냄.
                .and()
                .logout()
                .logoutSuccessUrl("/")  //로그아웃기능 설정의 시작점, 로그아웃 성공시 /주소로 이동
                .and()
                .oauth2Login() //OAuth2 로그인 기능에 대한 시작점
                .userInfoEndpoint()//OAuth2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당.
                .userService(customOAuth2UserService); // 소셜 로그인 성공시 후속조치를 진행할 UserService 인터페이스의 구현체를 등록
                                                       // + 리소스 서버(소셜서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할수 있음
    }

}