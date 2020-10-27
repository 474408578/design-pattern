package com.xschen.mylearn.observer.natural;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 *
 * Observable功能，实现订阅，取消订阅，通知等
 */


public class Publisher {
    // 订阅者列表
    private List<Subscriber> subscribers;

    private boolean pubStatus = false;

    public Publisher() {
        subscribers = new ArrayList<>();
    }

    protected void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    protected void unSubscribe(Subscriber subscriber) {
        if (this.subscribers.contains(subscriber)) {
            this.subscribers.remove(subscriber);
        }
    }

    // 会迭代调用subscribe的receive方法
    protected void notifySubscribers(String publisher, String articleName) {
        if (pubStatus == false) {
            return;
        }

        for (Subscriber subscriber : subscribers) {
            subscriber.receive(publisher, articleName);
        }

        this.clearPubStatus();
    }

    protected void setPubStatus() {
        this.pubStatus = true;
    }

    protected void clearPubStatus() {
        this.pubStatus = false;
    }
}
