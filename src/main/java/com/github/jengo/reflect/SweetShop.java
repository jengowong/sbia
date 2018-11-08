package com.github.jengo.reflect;

/**
 * test class loading
 *
 * https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw
 */
public class SweetShop {
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("com.github.jengo.reflect.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"com.github.jengo.reflect.Gum\")");
        new Cookie();
        //Cookie cookie;
        print("After creating Cookie");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}
