package com.pc.config;

import com.pc.serviceImpl.MyPasswordEncoderImpl;
import com.pc.serviceImpl.MyUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author foreverqisui
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserServiceImpl myUserService;

    /**
     * 指定可以登录的用户
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //指定用哪个service进行管理
//        auth.userDetailsService(myUserService).passwordEncoder(new MyPasswordEncoderImpl());

        //管理者
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
        //用户
        auth.inMemoryAuthentication().withUser("pc").password("{noop}123456").roles("USER");
    }

    /**
     * 配置安全过滤策略
     * /路径可以访问
     * 其他的要进行验证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin();
        http.csrf().disable();
    }
}
