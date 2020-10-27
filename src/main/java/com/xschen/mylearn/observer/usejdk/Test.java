package com.xschen.mylearn.observer.usejdk;

/**
 * @author xschen
 */


public class Test {
    public static void main(String[] args) {
        WeChatAccounts accounts = new WeChatAccounts("Li li");

        WeChatClient mary = new WeChatClient("Mary");
        WeChatClient tom = new WeChatClient("Tom");
        WeChatClient james = new WeChatClient("James");

        accounts.addObserver(mary);
        accounts.addObserver(tom);
        accounts.addObserver(james);

        accounts.publishArticle("设计模式", "观察者模式");

        accounts.deleteObserver(mary);
        accounts.publishArticle("Java多线程", "synchronized");
    }
}
