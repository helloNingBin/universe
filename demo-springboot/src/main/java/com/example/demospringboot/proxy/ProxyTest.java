package com.example.demospringboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static ThreadLocal<ProxyInterface> threadLocal = new ThreadLocal<>();
    public static ProxyInterface bean = createProxyBean();

    private static ProxyInterface createProxyBean() {
        return (ProxyInterface) Proxy.newProxyInstance(ProxyBean.class.getClassLoader(), ProxyBean.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(threadLocal.get(), args);
            }
        });
    }

    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            new Thread(()->{
                String name = Thread.currentThread().getName();
                ProxyBean p = new ProxyBean(name);
                threadLocal.set(p);
                System.out.println(name + "==>" + bean.getId());
            }).start();
        }
    }
}
