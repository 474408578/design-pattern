package com.mylearn.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * @author xschen
 * todo: 回调过滤器，在CGLIB回调时可以设置对不同方法执行不同的回调逻辑。
 */


public class UserDaoFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0; // Callback列表的第1个拦截器
        }
        return 1; // Callback 列表第2个拦截器
    }
}
