package com.xschen.geektime.oop._16.refactorafter;

public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ……省略设置apiStatInfo数据值的代码
        apiStatInfo.setTimeoutCount(239);
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }

}
