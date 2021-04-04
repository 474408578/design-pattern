package com.mylearn.factory.simplefactory;

/**
 * @author xschen
 */


public class ClientTest {
    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("python");
        if (video == null) {
            return;
        }
        video.produce();

        Video video2 = videoFactory.getVideo(JavaVideo.class);
        if (video2 == null) {
            return;
        }
        video2.produce();
    }
}
