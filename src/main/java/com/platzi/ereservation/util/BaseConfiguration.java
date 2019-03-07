/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Carl
 */
@Configuration
@EnableWebSecurity
public class BaseConfiguration extends WebSecurityConfigurerAdapter{
    //Configuracion para Swagger
/*
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
     */
    //Confugiracion para html
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/app/login").permitAll()
                .failureUrl("/app/login?error=true")
                .defaultSuccessUrl("/app/home");
    }

    //Autentificacion
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("develop").password(encoder.encode("develop")).roles("USER");
    }

    //Autentificacion
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resoruces/**", "/static/**", "/css/**", "/js/**", "images/**");
    }

}
