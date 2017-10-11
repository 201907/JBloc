package com.shenyang;

import com.shenyang.Interceptor.AutoLoginInterceptor;
import com.shenyang.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
//@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    AutoLoginInterceptor autoLoginInterceptor(){
        return new AutoLoginInterceptor();
    }
    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(autoLoginInterceptor()).addPathPatterns("/");
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/home");
        super.addInterceptors(registry);
    }
}
