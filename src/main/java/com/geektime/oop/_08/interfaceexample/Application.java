package com.geektime.oop._08.interfaceexample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 *
 * 过滤器使用demo
 * 分别实现对RPC请求鉴权和限流的过滤功能
 */


public class Application {
    private List<Filter> filters;

    public Application(List<Filter> filters) {
        this.filters = filters;
    }

    public static void main(String[] args) {
        List<Filter> filters = new ArrayList<>();
        filters.add(new AuthencationFilter());
        filters.add(new RateLimitFilter());
        Application application = new Application(filters);
        RpcRequest req = new RpcRequest();
        application.handleRpcRequest(req);
    }


    public void handleRpcRequest(RpcRequest req) {
        try {
            for (Filter filter : filters) {
                filter.doFilter(req);
            }
        } catch (RpcException e) {
            // 处理过滤结果
        }
        // 省略其他逻辑
    }
}


class RpcException extends Exception {

}

class RpcRequest {

}
