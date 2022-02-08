package com.rachein.demo.config;

import com.rachein.demo.annotaion.resolve.CurrentUserAnnotationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Description 注解解析器配置
 * @author 计算机系 ITAEM 吴远健
 * @date 2022/2/8 10:58
 */
public class ResolveArgumentConfig implements WebMvcConfigurer {

    @Autowired
    CurrentUserAnnotationResolver currentUser;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUser);
    }
}
