package com.github.jengo.sbia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link SpringWiringWay3}
 *
 * https://www.jianshu.com/p/a953afa0165d
 * 3. 在XML中进行显示装配
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-spring-wiring-way3.xml")
public class SpringWiringWay3 {
    @Autowired(required = true)
    private My3 my3;

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
        my3.shout();
    }
}


class Dog3 {
    public void call() {
        System.out.println("汪汪汪3...");
    }
}

class My3 {
    private Dog3 dog3;
    private String name;

    public My3(Dog3 dog3, String name) {
        this.dog3 = dog3;
        this.name = name;
    }

    public void shout() {
        dog3.call();
        System.out.println("My3 name=" + this.name);
    }
}
