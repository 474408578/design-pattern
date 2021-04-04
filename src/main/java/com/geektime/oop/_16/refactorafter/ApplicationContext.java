package com.geektime.oop._16.refactorafter;

/**
 * ApplicationContext是一个单例类，负责Alert的创建、组装（alertRule和notification的依赖注入）、
 * 初始化（添加handlers）工作
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        alertRule = new AlertRule(/*.省略参数.*/); //省略一些初始化代码

        notification = new Notification(/*.省略参数.*/); //省略一些初始化代码

        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        // 注册handler
        alert.addAlertHandler(new TimeoutAlertHander(alertRule, notification));
    }


    public Alert getAlert() {
        return alert;
    }

    // 饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();
    private ApplicationContext() {
        instance.initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }
}
