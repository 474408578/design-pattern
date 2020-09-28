package com.xschen.geektime.oop._16.refactorbefore;

public class Api {
    private String api;
    private long tps;
    private long errorCount;
    private long timeoutTps;
    public long getMaxTps() {
        return tps;
    }

    public Api(String api) {
        this.api = api;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public long getMaxTimeoutTps() {
        return timeoutTps;
    }
}
