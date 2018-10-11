package com.github.jengo.sbia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link SpringWiringWay2}
 *
 * https://www.jianshu.com/p/a953afa0165d
 * 2.在Java代码中进行显式装配
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig2.class})
public class SpringWiringWay2 {
    @Autowired(required = true)
    private My2 my2;

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
        my2.shout();
    }
}


class Dog2 {
    public void call() {
        System.out.println("汪汪汪2...");
    }
}

class My2 {
    private Dog2 dog2;

    public My2(Dog2 dog2) {
        this.dog2 = dog2;
    }

    public void shout() {
        dog2.call();
    }
}

@Configuration
//@ComponentScan(basePackages = "com.github.jengo.sbia")
//@ComponentScan(basePackages = {"com.package1","com.package2"})
//@ComponentScan(basePackageClasses = {Dog2.class, My2.class})
class MyConfig2 {
    @Bean(name = "dog2")
    public Dog2 dog2() {
        return new Dog2();
    }

    @Bean(name = "my2")
    public My2 my2() {
        return new My2(dog2());
    }
}

