package com.github.jengo.sbia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * {@link ReadingListApplication} 应用程序的启动引导类，也是主要的Spring配置类。
 */
@SpringBootApplication //开启组件扫描和自动配置
public class ReadingListApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ReadingListApplication.class, args); //负责启动引导应用程序
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/readingList");
    }

}
