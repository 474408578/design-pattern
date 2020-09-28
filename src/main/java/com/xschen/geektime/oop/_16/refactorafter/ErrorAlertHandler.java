package com.xschen.geektime.oop._16.refactorafter;

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getErrorCount()) {
            notification.notifyToUser(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
