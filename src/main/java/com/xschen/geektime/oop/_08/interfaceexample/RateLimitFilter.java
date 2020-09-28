package com.xschen.geektime.oop._08.interfaceexample;

/**
 * @author xschen
 */


public class RateLimitFilter implements Filter {
    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        // 限流逻辑
    }
}
