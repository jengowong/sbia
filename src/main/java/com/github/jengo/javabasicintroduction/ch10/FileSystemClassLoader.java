package com.github.jengo.javabasicintroduction.ch10;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * {@link FileSystemClassLoader}
 */
public class FileSystemClassLoader extends ClassLoader {

    private String classpath;

    public FileSystemClassLoader() {
    }

    public FileSystemClassLoader(String classpath) {
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] datas = getClassData(name);
            if (datas == null) {
                throw new ClassNotFoundException("类没有找到：" + name);
            }
            return this.defineClass(name, datas, 0, datas.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类找不到：" + name);
        }
    }

    private byte[] getClassData(String name) throws IOException {
        name = name.replace(".", "\\") + ".class";
        File classFile = new File(classpath, name);
        return FileUtils.readFileToByteArray(classFile);
    }

    public static void main(String[] args) throws Exception {
        ClassLoader loader = new FileSystemClassLoader("F:\\classpath");
        Class clazz = loader.loadClass("com.github.jengo.javabasicintroduction.ch10.CommonUtils");
        Method method = clazz.getMethod("md5", String.class);
        String result = (String) method.invoke(null, "qdmmy6");
        System.out.println(result);
    }

}
