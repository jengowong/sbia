package com.github.jengo.reflect;

/**
 * test class loading
 *
 * https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw
 */
public class ClassCast {
    public void cast() {
        Animal animal = new Dog();
        Dog dog = (Dog) animal;

        Class<Dog> dogType = Dog.class;
        Dog dog2 = dogType.cast(animal);
    }

    public void cast2(Object obj) {
        if (obj instanceof Animal) {
            Animal animal = (Animal) obj;
        }

        if (Animal.class.isInstance(obj)) {
            Animal animal = (Animal) obj;
        }
    }
}

interface Animal {
}

class Dog implements Animal {
}
