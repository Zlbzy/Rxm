package com.eddy.rxm.common.util;

import com.eddy.rxm.admin.service.MyInterface;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicClassLoader extends URLClassLoader{

    private URL[] urls;

    public DynamicClassLoader(URL[] urls, ClassLoader parent){
//        this.getParent()(urls, parent);
        super(urls, parent);
        this.urls = urls;
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException{

        if(this.urls != null && this.urls.length > 0){
            Class c = null;
            try{
                // 现在自身和第三方库中找
                c = findClass(name);
            }catch(ClassNotFoundException e){
                c = this.getParent().loadClass(name);
            }
            return c;
        }
        return super.loadClass(name);

    }



    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader.getClass());

        ClassLoader loader1 = DynamicClassLoader.class.getClassLoader();
        System.out.println(loader1.getParent().getClass());

        try {
            URL url = new File("/Users/Eddy/IdeaProjects/rxm/RxManager/src/main/resources/jarFile/parseXml.jar").toURI().toURL();
            URL url2 = new File("/Users/Eddy/IdeaProjects/rxm/RxManager/src/main/resources/jarFile/myInterface.jar").toURI().toURL();
            URLClassLoader classLoader = new DynamicClassLoader(new URL[]{url}, DynamicClassLoader.classLoader);
            Class<?> clazz = classLoader.loadClass("com.rx.demo.ParseXml");


            if(!MyInterface.class.isAssignableFrom(clazz)){
                System.out.println("该类没有实现MyInterface接口。不运行...");
                return;
            }
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("parse");
            method.invoke(obj, null);


        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private static final ClassLoader classLoader;
    private static final Map<String, URLClassLoader> CLASS_LOADER_MAP = new ConcurrentHashMap<>();


    static {
        ClassLoader thisClassLoader = DynamicClassLoader.class.getClassLoader();
        classLoader = thisClassLoader != null ? thisClassLoader : URLClassLoader.getSystemClassLoader();
    }


    public boolean loadJar(String jarPath){
        try {
            URL url = new File(jarPath).toURI().toURL();
            URLClassLoader classLoader = CLASS_LOADER_MAP.remove(url.toString());
            if(classLoader != null){
                classLoader.close();
            }
            URLClassLoader classLoader1 = new URLClassLoader(new URL[]{url}, DynamicClassLoader.classLoader);
            CLASS_LOADER_MAP.put(url.toString(), classLoader);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Class<?> getClass(String jarPath, String classPath){
        try {
            URL url = new File(jarPath).toURI().toURL();
            URLClassLoader classLoader = CLASS_LOADER_MAP.get(url.toString());
            Class clazz = classLoader.loadClass(classPath);
            return clazz;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }

    public static boolean unloadJar(String jarPath){
        try {
            URL url = new File(jarPath).toURI().toURL();
            URLClassLoader classLoader = CLASS_LOADER_MAP.remove(url.toString());
            if(classLoader != null){
                classLoader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
