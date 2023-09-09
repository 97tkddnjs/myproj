package com.dboard.myproj.config;

import com.dboard.myproj.config.interceptor.AdminCheckInterceptor;
import com.dboard.myproj.config.interceptor.AuthCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    // 인터셉트를 통한 로그인 관리!
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthCheckInterceptor())
                .order(1)
                .addPathPatterns("/mysite/user/**")
                .excludePathPatterns("/","/login","/logout","/signup", "/css/**", "/*.ico", "/error");



        registry.addInterceptor(new AdminCheckInterceptor())
                .order(2)
                .addPathPatterns("/mysite/admin/**")
                .excludePathPatterns("/","/login","/logout","/signup", "/css/**", "/*.ico", "/error");
    }

}
