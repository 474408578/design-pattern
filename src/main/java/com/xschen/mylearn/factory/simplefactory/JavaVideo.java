package com.xschen.mylearn.factory.simplefactory;

/**
 * @author xschen
 */


public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制java视频");
    }
}
