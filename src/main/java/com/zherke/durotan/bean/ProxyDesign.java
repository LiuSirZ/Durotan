package com.zherke.durotan.bean;

import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理模式
 * JDK动态代理基于接口实现
 */
public class ProxyDesign {
    public static void main(String[] args) {
        Person customer = new Customer();
        Person student = new Student();
        //获取代理类
        Person person = (Person) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Person.class},
                new ProxyHandler<Person>(student));
        //执行
        person.tell();
    }
}

/**
 * JDK动态代理接口
 */
interface Person{
    void tell();
}

/**
 * 需要代理的实现类
 */
class Customer implements  Person{
    @Override
    public void tell() {
        System.out.println("tell....");
    }
}

/**
 * 需要代理的实现类
 */
class Student implements  Person{
    @Override
    public void tell() {
        System.out.println("tell....");
    }
}

/**
 * 创建代理执行类
 */
class ProxyHandler<T> implements InvocationHandler {

    private T t;

    public ProxyHandler(T t){
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start....");
        method.invoke(t,args);
        System.out.println("end....");
        return null;
    }
}