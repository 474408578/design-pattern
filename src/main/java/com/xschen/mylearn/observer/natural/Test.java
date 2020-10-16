package com.xschen.mylearn.observer.natural;

import com.xschen.mylearn.observer.natural.impl.WeChatAccounts;
import com.xschen.mylearn.observer.natural.impl.WeChatClient;

/**
 * @author xschen
 */


public class Test {
    public static void main(String[] args) {
        WeChatAccounts accounts = new WeChatAccounts("Lili");

        WeChatClient mary = new WeChatClient("Mary");
        WeChatClient tom = new WeChatClient("Tom");
        WeChatClient james = new WeChatClient("James");

        accounts.subscribe(mary);
        accounts.subscribe(tom);
        accounts.subscribe(james);

        accounts.publishArticle("设计模式", "观察者模式");

        accounts.unSubscribe(mary);
        accounts.publishArticle("Java多线程", "synchronized");

    }
}
