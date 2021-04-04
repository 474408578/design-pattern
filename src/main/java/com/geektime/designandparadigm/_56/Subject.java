package com.geektime.designandparadigm._56;

import com.geektime.designandparadigm._56.support.Message;


/**
 * 被观察者示例
 * @author xschen
 */

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}
