package com.example.web.Config;

import com.example.web.Interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Objects;
import java.util.Stack;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/20 19:37
 * @Decription:
 */

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
       registration.addPathPatterns("/**");
        registration.excludePathPatterns(    //添加不拦截路径
                "/login",
                "/msg", //登录路径
                "/**/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
                "/**/*.css",                  //css静态资源
                "/**/*.jpg",
                "/user/login",
                "/register",
                "/registerForm"
        );

    }
    
}
