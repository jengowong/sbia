package com.github.jengo.sbia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link SpringWiringWay4}
 *
 * https://www.jianshu.com/p/a953afa0165d
 * 4. 混合配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig5.class)
public class SpringWiringWay4 {
    @Autowired(required = true)
    private My4 my4;

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
        my4.shout();
    }
}


class Dog4 {
    public void call() {
        System.out.println("汪汪汪4...");
    }
}

class My4 {
    private Dog4 dog4;

    public My4(Dog4 dog4) {
        this.dog4 = dog4;
    }

    public void shout() {
        dog4.call();
    }
}

@Configuration
class MyConfig4 {
    @Bean(name = "dog4")
    public Dog4 dog4() {
        return new Dog4();
    }
}

@Configuration
@Import(MyConfig4.class) //引用其他JavaConfig中的Bean
@ImportResource("classpath:test-spring-wiring-way3.xml")
        //引用XML中配置的Bean
class MyConfig5 {
    @Bean(name = "my4")
    public My4 my4(Dog4 dog4) {
        return new My4(dog4);
    }
}


