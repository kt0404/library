package com.cbox.library.domain.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override 
    public void configure(WebSecurity web) {
        web.ignoring()
            .antMatchers("/css/**")
            .antMatchers("/images/**")
            .antMatchers("/js/**");
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers(
		        "/",
		        "/show",
		        "/register",
		        "/comment",
		        "/detail/**",
		        "/delete/**",
		        "/update/**",
		        "/request/list"
		        ).permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login").permitAll();
		http.logout().logoutSuccessUrl("/").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
