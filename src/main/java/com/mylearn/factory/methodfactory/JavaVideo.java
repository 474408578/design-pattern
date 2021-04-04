package com.mylearn.factory.methodfactory;

/**
 * @author xschen
 */


public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java视频");
    }
}
