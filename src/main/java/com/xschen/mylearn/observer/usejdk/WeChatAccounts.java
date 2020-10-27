package com.xschen.mylearn.observer.usejdk;


import java.util.Observable;

/**
 * @author xschen
 */


public class WeChatAccounts extends Observable {
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    public void publishArticle(String articleName, String content) {
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ",
                this.name,
                articleName,
                content));

        setChanged();
        // notifyObservers会调用observer的update方法
        notifyObservers(new WeChatNotice(this.name, articleName));
    }
}
