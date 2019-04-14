package com.romanstetsiuk.spring_tdd.security;

import com.romanstetsiuk.spring_tdd.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder bcrypt() {
        return new BCryptPasswordEncoder();
    }

    String encodedpassword = new BCryptPasswordEncoder()
            .encode("myPassword");

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("Rambo")
//                .password(encodedpassword)
//                .roles("ADMIN")
//                .and()
//                .passwordEncoder(bcrypt());

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bcrypt());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/prywatna").authenticated()
                .antMatchers("/sciezka").hasAuthority("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin();
    }
}
