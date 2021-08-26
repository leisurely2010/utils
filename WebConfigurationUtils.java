package com.cqxxty.security.admin.utils;

import com.cqxxty.security.admin.entity.User;
import com.cqxxty.security.auth.client.interceptor.ServiceAuthRestInterceptor;
import com.cqxxty.security.auth.client.interceptor.UserAuthRestInterceptor;
import com.cqxxty.security.common.handler.GlobalExceptionHandler;
import com.cqxxty.security.common.util.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 修改springboot默认的springmvc配置
 * @author ace
 * @date 2017/9/8
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfigurationUtils implements WebMvcConfigurer {
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public Snowflake snowflake() {
        return Snowflake.getInstance(1, 1);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getServiceAuthRestInterceptor()).addPathPatterns(getIncludePathPatterns()).addPathPatterns("");
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns(getIncludePathPatterns());
    }

    @Bean
    public ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthRestInterceptor();
    }

    @Bean
    public UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     *
     * @return 路径表
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/element/**",
                "/gateLog/**",
                "/group/**",
                "/groupType/**",
                "/menu/**",
                "/user/**",
                "/api/permissions",
                "/api/user/un/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

    /**
     *  开启矩阵参数
     * @param
     * @param configurer
     * @return void
     * @author lei
     * @date 2021/8/26 17:21
     * @version v1.0
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper=new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    /**
     *  自定义参数解析器
     * @param
     * @param registry
     * @return void
     * @author lei
     * @date 2021/8/26 17:21
     * @version v1.0
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, User>() {
            @Override
            public User convert(String username) {
                String []u=username.split(",");
                User user=new User();
                user.setName(u[0]);
                user.setPassword(u[1]);
                return user;
            }
        })  ;
    }
}
