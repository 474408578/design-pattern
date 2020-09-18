package com.xschen.oop._16.refactorbefore;

public class AlertRule {
    public Api getMatchedRule(String api) {
        Api apiInterface = new Api(api);
        return apiInterface;
    }
}
