package com.xschen.oop._08.interfaceexample;

/**
 * @author xschen
 */


public class AuthencationFilter implements Filter {
    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        // 鉴权逻辑
    }
}
