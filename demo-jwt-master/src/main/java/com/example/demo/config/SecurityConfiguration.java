package com.example.demo.config;

import com.example.demo.filter.JwtAuthenticationFilter;
import com.example.demo.filter.JwtLoginFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/11/16
 * Time: 10:38
 * Email: hyf_spring@163.com
 *
 * @author huyunfan
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//    	    .antMatchers("/login", "/user/login","/css/**", "/images/*").permitAll()
//    	    .antMatchers("/user/login").hasRole("API")
//    	    .antMatchers("/login", "/oauth/authorize").hasRole("USER").anyRequest().authenticated();
//		.antMatchers("/login", "/oauth/authorize").hasRole("USER")
    	
    	
//    	http.authorizeRequests()
//		.antMatchers("/login", "/css/**", "/images/*").permitAll()
//		.antMatchers("/user/login").hasRole("API")
//		.antMatchers("/login", "/oauth/authorize").hasRole("USER")
//		.anyRequest().authenticated();
        
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/employee/login","/oauth/authorize").permitAll()
                .anyRequest().authenticated()
                .and()
                .requestMatchers().antMatchers("/employee/login","/oauth/authorize")
                .and()
                .addFilter(new JwtLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
        
       
    }

}
