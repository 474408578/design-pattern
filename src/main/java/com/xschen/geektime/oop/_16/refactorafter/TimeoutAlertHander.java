package com.xschen.geektime.oop._16.refactorafter;

public class TimeoutAlertHander extends AlertHandler{
    public TimeoutAlertHander(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    public void check(ApiStatInfo apiStatInfo) {
        // 新加功能
        long timeoutTps = apiStatInfo.getTimeoutCount() / apiStatInfo.getDurationOfSeconds();
        if (timeoutTps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
            notification.notifyToUser(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
