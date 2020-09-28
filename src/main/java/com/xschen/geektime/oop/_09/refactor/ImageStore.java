package com.xschen.geektime.oop._09.refactor;

import java.awt.*;

/**
 * @author xschen
 */


public interface ImageStore {
    String upload(Image image, String bucketName);
    Image download(String url);
}
