package com.huan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/6/23 - 11:39
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.huan")
public class MvcConfiguration {
}
