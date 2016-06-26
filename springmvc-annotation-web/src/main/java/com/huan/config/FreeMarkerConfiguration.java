package com.huan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

/**
 * Created by ptmind on 2016/6/26.
 */
@Configuration
public class FreeMarkerConfiguration {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/templates/");
        configurer.setDefaultEncoding("UTF-8");

        Properties settings = new Properties();
        settings.setProperty("template_update_delay", "5");
        settings.setProperty("default_encoding", "UTF-8");
        settings.setProperty("locale", "UTF-8");
        settings.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        settings.setProperty("time_format", "HH:mm:ss");
        settings.setProperty("number_format", "0.####");
        settings.setProperty("boolean_format", "true,false");
        settings.setProperty("whitespace_stripping", "true");
        settings.setProperty("tag_syntax", "auto_detect");
        settings.setProperty("url_escaping_charset", "UTF-8");
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }

    @Bean
    public ViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".html");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setExposeRequestAttributes(false);
        viewResolver.setExposeSessionAttributes(false);
        return viewResolver;
    }
}
