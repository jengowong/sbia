package com.github.jengo.reflect;

import java.lang.reflect.Method;

/**
 * test class loading
 *
 * https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw
 */
public class ReflectMethod {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.github.jengo.reflect.Circle");

        Method method = clazz.getMethod("draw", int.class, String.class);
        System.out.println("method:" + method);

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("m::" + m);
        }

        System.out.println("=========================================");

        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1::" + method1);

        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println("m1::" + m);
        }

        System.out.println("=========================================");

        Circle circle = (Circle) clazz.newInstance();
        method.invoke(circle, 15, "圈圈");

        method1.setAccessible(true);
        method1.invoke(circle);

        Method method2 = clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method2.invoke(circle);
        System.out.println("count:" + count);
    }
}

class Shape {
    public void draw() {
        System.out.println("draw");
    }

    public void draw(int count, String name) {
        System.out.println("draw " + name + ",count=" + count);
    }

}

class Circle extends Shape {
    private void drawCircle() {
        System.out.println("drawCircle");
    }

    public int getAllCount() {
        return 100;
    }
}
