package com.geektime.oop._08.interfaceexample;

/**
 * 接口不能包含属性（也就是成员变量）。
 * 接口只能声明方法，方法不能包含代码实现。
 * 类实现接口的时候，必须实现接口中声明的所有方法。
 */
public interface Filter {
    void doFilter(RpcRequest req) throws RpcException;
}
