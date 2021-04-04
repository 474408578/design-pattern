package com.mylearn.factory.methodfactory;

/**
 * @author xschen
 */


public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
