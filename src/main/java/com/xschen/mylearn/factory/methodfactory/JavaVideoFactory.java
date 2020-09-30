package com.xschen.mylearn.factory.methodfactory;

/**
 * @author xschen
 */


public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
