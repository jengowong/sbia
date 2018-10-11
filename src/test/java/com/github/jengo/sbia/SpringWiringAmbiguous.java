package com.github.jengo.sbia;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link SpringWiringAmbiguous} Spring高级装配之处理自动装配的歧义性
 *
 * https://www.jianshu.com/p/f2a92091f4ae
 *
 * 所有使用了@Component注解声明的的类都会创建为bean，并且bean的ID默认为类名首字母小写。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig6.class)
public class SpringWiringAmbiguous {

    @Autowired
    @Qualifier("iceCream")
    private Dessert dessert;

    @Before
    public void before() {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @After
    public void after() {
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    @Test
    public void sayHello() {
        System.out.println(dessert.sayHello());
    }
}


interface Dessert {
    String sayHello();
}

@Service
@Primary
class Cake implements Dessert {
    @Override
    public String sayHello() {
        return "Hello Cake!";
    }
}

@Service
class IceCream implements Dessert {
    @Override
    public String sayHello() {
        return "Hello IceCream!";
    }
}

@Service
class Cookies implements Dessert {
    @Override
    public String sayHello() {
        return "Hello Cookies!";
    }
}

@Configuration
@ComponentScan(basePackageClasses = {Cake.class, IceCream.class, Cookies.class})
class MyConfig6 {
}

