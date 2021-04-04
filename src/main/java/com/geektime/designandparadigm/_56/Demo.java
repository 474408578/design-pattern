package com.geektime.designandparadigm._56;

import com.geektime.designandparadigm._56.support.Message;

/**
 * @author xschen
 */
public class Demo {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message("hello"));
    }
}
