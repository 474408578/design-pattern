package com.xschen.oop._16.refactorafter;

public class AlertRule {
    public Api getMatchedRule(String api) {
        Api apiInterface = new Api(api);
        return apiInterface;
    }
}
