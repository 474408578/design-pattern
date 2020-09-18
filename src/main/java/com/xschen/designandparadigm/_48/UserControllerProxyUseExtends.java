package com.xschen.designandparadigm._48;

import com.xschen.designandparadigm._48.util.MetricsCollector;
import com.xschen.designandparadigm._48.util.RequestInfo;
import com.xschen.designandparadigm._48.util.UserVo;

public class UserControllerProxyUseExtends extends UserController {
    private MetricsCollector metricsCollector;

    public  UserControllerProxyUseExtends() {
        this.metricsCollector = new MetricsCollector();
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        // 委托
        UserVo userVo = super.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);
        return userVo;
    }

    public static void main(String[] args) {
        // UserControllerProxy
        UserController userController = new UserControllerProxyUseExtends();
    }
}
