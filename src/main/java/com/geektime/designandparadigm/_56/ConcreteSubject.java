package com.geektime.designandparadigm._56;

import com.geektime.designandparadigm._56.support.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
