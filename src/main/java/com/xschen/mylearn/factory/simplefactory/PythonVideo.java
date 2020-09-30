package com.xschen.mylearn.factory.simplefactory;

/**
 * @author xschen
 */


public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python视频");
    }
}
