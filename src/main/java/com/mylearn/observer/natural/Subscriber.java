package com.mylearn.observer.natural;

/**
 * @author xschen
 *
 * 观察者接口
 */


public interface Subscriber {
    int receive(String publisher, String articleName);
}
