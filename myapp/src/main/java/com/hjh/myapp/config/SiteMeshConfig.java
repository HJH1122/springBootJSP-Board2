package com.hjh.myapp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

@Configuration
public class SiteMeshConfig {

    @Bean
    public FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter() {
        FilterRegistrationBean<ConfigurableSiteMeshFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new ConfigurableSiteMeshFilter()); // 기본 XML 읽도록
        registration.addUrlPatterns("/*"); // 전체 요청 필터링
        registration.setName("sitemeshFilter");
        registration.setOrder(1);
        return registration;
    }
}
