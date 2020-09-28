package com.xschen.geektime.oop._09.refactor;

import java.awt.*;

/**
 * @author xschen
 * 私有云图片存储代码:
 *  上传下载逻辑流程改变，私有云不需要支持AccessToken
 */


public class PrivateImageStore implements ImageStore{
    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        //...上传图片到私有云...
        // ...返回图片的url...
        return "privateyunUrl";
    }

    @Override
    public Image download(String url) {
        //...从私有云下载图片...
        return null;
    }

    public void createBucketIfNotExisting(String bucketName) {
        // ...创建bucket代码逻辑...
        // ...失败会抛出异常..
    }


}
