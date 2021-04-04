package com.geektime.oop._09.refactor;

import java.awt.*;

/**
 * @author xschen
 * 重构后的阿里云图片存储代码
 */

public class AliyunImageStore implements ImageStore {
    //...省略属性、构造函数等...

    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        String accessToken = generateAccessToken();
        //...上传图片到阿里云...
        // ...返回图片存储在阿里云上的地址(url）...
        return "aliyunUrl";
    }

    @Override
    public Image download(String url) {
        String accessToken = generateAccessToken();
        // ...从aliyun下载图片...
        return null;
    }

    public void createBucketIfNotExisting(String bucketName) {
        // ...创建bucket代码逻辑...
        // ...失败会抛出异常..
    }

    public String generateAccessToken() {
        // ...根据accesskey/secrectkey等生成access token
        return "accessToken";
    }
}
