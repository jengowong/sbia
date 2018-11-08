package com.github.jengo.reflect;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Field;

/**
 * test class loading
 *
 * https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw
 */
public class ReflectField {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.github.jengo.reflect.Student");

        Field field = clazz.getField("age");
        System.out.println("field: " + field);

        Field fields[] = clazz.getFields();
        for (Field f : fields) {
            System.out.println("f: " + f.getDeclaringClass());
        }

        System.out.println("================getDeclaredFields====================");

        Field fields2[] = clazz.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println("f2: " + f.getDeclaringClass());
        }

        System.out.println("====================================");

        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("field2: " + field2);

        Student st = (Student) clazz.newInstance();
        Field ageField = clazz.getField("age");
        ageField.set(st, 18);
        Field nameField = clazz.getField("name");
        nameField.set(st, "Lily");
        Field descField = clazz.getDeclaredField("desc");
        descField.set(st, "I am student");
        Field scoreField = clazz.getDeclaredField("score");
        scoreField.setAccessible(true);
        scoreField.set(st, 88);
        System.out.println(st.toString());
        System.out.println(scoreField.get(st));
    }
}

class Person {
    public int age;
    public String name;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

class Student extends Person {
    public String desc;
    private int score;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
