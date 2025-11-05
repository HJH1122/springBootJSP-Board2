package com.hjh.myapp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.opensymphony.module.sitemesh.filter.PageFilter;

@Configuration
public class SiteMeshConfig {

    @Bean
    public FilterRegistrationBean<PageFilter> siteMeshFilter() {
        FilterRegistrationBean<PageFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new PageFilter());
        registration.addUrlPatterns("/*"); // 전체 요청 필터링
        registration.setName("sitemeshFilter");
        registration.setOrder(1);
        return registration;
    }
}
