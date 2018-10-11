package com.github.jengo.sbia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link SpringWiringWay1}
 *
 * https://www.jianshu.com/p/a953afa0165d
 *
 * 1.隐式的Bean发现机制和自动装配
 * 主要是通过两步来实现Bean的装配和使用:
 * (1)组建扫描(component scanning): Spring会自动发现应用上下文中所创建的bean。
 * (2)自动装配(autowiring): Spring自动将满足类型或名称的Bean注入到使用到的类。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig1.class})
public class SpringWiringWay1 {

    @Autowired(required = true)
    private My1 my1;

    @Before
    public void before() {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @After
    public void after() {
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    @Test
    public void testClient() {
        my1.shout();
    }
}


@Component("dog")
class Dog1 {
    public void call() {
        System.out.println("汪汪汪1...");
    }
}

@Component("my")
class My1 {
    @Autowired(required = true)
    private Dog1 dog1;

    public void shout() {
        dog1.call();
    }
}

@Configuration
//@ComponentScan(basePackages = "com.github.jengo.sbia")
//@ComponentScan(basePackages = {"com.package1","com.package2"})
@ComponentScan(basePackageClasses = {Dog1.class, My1.class})
class MyConfig1 {
}
