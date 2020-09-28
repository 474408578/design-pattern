package com.xschen.geektime.designandparadigm._48;

import com.xschen.geektime.designandparadigm._48.util.MetricsCollector;
import com.xschen.geektime.designandparadigm._48.util.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，不事先为每个原始类编写代理类，而是在运行的时候，动态地创建原始类对应的代理类，
 * 然后在系统中用代理类替换掉原始类。
 *
 * java.lang.reflect.Proxy: Java动态代理机制的主类，提供了一组动态方法来为一组接口动态地生成代理类及其对象。
 * 其中最重要的一个静态方法如下，该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例：
 *      newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)
 *
 *
 *
 */
public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        // 被代理类的所有接口信息，便于具有代理类接口的所有方法
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        // 调用处理器
        DynamicProxyHander hander = new DynamicProxyHander(proxiedObject);
        // 创建动态代理类实例
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, hander);
    }


    private class DynamicProxyHander implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHander(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimeStamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimeStamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimeStamp);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }

    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
    }
    
}
