package com.geektime.designandparadigm._56;

import com.geektime.designandparadigm._56.support.Message;

/**
 * @author xschen
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        // todo 执行自己的逻辑 ...
        System.out.println("ConcreteObserverOne is notified");
    }
}
