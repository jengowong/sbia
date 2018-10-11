package com.github.jengo.sbia.tdd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * {@link MockistStyleTest}
 *
 * https://site.mockito.org/
 * https://github.com/mockito/mockito
 * https://code.google.com/archive/p/mockito/
 *
 * http://liuzhijun.iteye.com/blog/1512780
 * https://martinfowler.com/articles/mocksArentStubs.html
 *
 * https://juejin.im/entry/578f11aec4c971005e0caf82
 */
public class MockistStyleTest {

    @Before
    public void before() {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @After
    public void after() {
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    @Test
    public void simpleTest() {
        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = Mockito.mock(List.class);

        //设置方法的预期返回值
        Mockito.when(list.get(0)).thenReturn("HelloWorld");
        String result = list.get(0);

        //验证方法调用(是否调用了get(0))
        Mockito.verify(list).get(0);

        //junit测试
        Assert.assertEquals("HelloWorld", result);

        //可对方法设定返回异常
        Mockito.when(list.get(1)).thenThrow(new RuntimeException("test exception"));
        //list.get(1);

        //stubbing另一种语法(设置预期值的方法)，可读性不如前者
        Mockito.doReturn("secondhello").when(list).get(1);
        Assert.assertEquals("HelloWorld", list.get(1));
    }

}
