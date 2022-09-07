package com.example.springboot2.security;

import com.example.springboot2.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // sử dụng đúng authenticate của spring
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // validate username and password
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // default mọi thứ phải đi qua login
        // below cho phép các path k cần login
        // permitAll - cho đi qua k làm gì hết
        http.authorizeRequests().antMatchers("/api/*").permitAll();
        http.authorizeRequests().antMatchers("/css/*").permitAll();
        http.authorizeRequests().antMatchers("/js/*").permitAll();
        http.authorizeRequests().antMatchers("/fonts/*").permitAll();
        http.authorizeRequests()
                .antMatchers("/", "/login", "/logout", "/register", "/process_register")
                .permitAll();

        // khi user có role x
        // mà want vào page dành cho role y
        // exception AccessDenied sẽ đc ném ra
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().antMatchers("/content").access("hasRole('ROLE_USER')");

        http.authorizeRequests().antMatchers("/student/index").access("hasRole('ROLE_ADMIN')");

        // còn lại là phải authenticated
//        http.authorizeRequests().anyRequest().authenticated();

        // Cấu hình cho Login Form.
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")
                .defaultSuccessUrl("/layout")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }
}
