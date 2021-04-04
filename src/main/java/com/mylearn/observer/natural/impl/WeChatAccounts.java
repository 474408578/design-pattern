package com.mylearn.observer.natural.impl;

import com.mylearn.observer.natural.Publisher;

/**
 * @author xschen
 *
 * 公众号，发布，通知
 */


public class WeChatAccounts extends Publisher {
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    public void publishArticle(String articleName, String content) {
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ",
                this.name,
                articleName, content));
        setPubStatus();
        notifySubscribers(name, articleName);
    }
}
