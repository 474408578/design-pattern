package com.mylearn.factory.methodfactory;

/**
 * @author xschen
 */


public class ClientTest {
    public static void main(String[] args) {
        VideoFactory pythonVideoFactory = new PythonVideoFactory();
        VideoFactory javaVideoFactory = new JavaVideoFactory();

        Video pythonVideo = pythonVideoFactory.getVideo();
        Video javaVideo = javaVideoFactory.getVideo();

        pythonVideo.produce();

        javaVideo.produce();
    }
}
