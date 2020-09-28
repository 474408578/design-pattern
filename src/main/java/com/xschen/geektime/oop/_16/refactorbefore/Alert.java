package com.xschen.geektime.oop._16.refactorbefore;

public class Alert {
    // AlertRule 存储告警规则
    private AlertRule rule;
    // Notification 是告警通知类，支持邮件、短信、微信、手机等多种通知渠道
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount,
                      long errorCount, long durationOfSeconds, long timeoutCount) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notifyToUser(NotificationEmergencyLevel.URGENCY, "...");
        }

        if (errorCount > rule.getMatchedRule(api).getErrorCount()) {
            notification.notifyToUser(NotificationEmergencyLevel.SEVERE, "...");
        }

        // 新加功能
        long timeoutTps = timeoutCount / durationOfSeconds;
        if (timeoutTps > rule.getMatchedRule(api).getMaxTimeoutTps()) {
            notification.notifyToUser(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
