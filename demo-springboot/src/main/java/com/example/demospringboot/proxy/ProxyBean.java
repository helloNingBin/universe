package com.example.demospringboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements ProxyInterface{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProxyBean(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProxyBean{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        Object obj = Proxy.newProxyInstance(ProxyBean.class.getClassLoader(), ProxyBean.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

    }
}
