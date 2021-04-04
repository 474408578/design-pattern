package com.geektime.oop._09;

import java.awt.*;

/**
 * @author xschen
 *
 * 上传图片到阿里云
 */


public class AliyunImageStore {
    //...省略属性、构造函数等...

    /**
     * @param bucketName: 存储图片的地方
     */
    public void createBucketIfNotExisting(String bucketName) {
        // ...创建bucket代码逻辑...
        // ...失败会抛出异常..
    }

    /**
     * 生成访问凭证
     * @return
     */
    public String generateAccessToken() {
        // ...根据accesskey/secrectkey等生成access token
        return "accessToken";
    }

    /**
     * 携带access token上传图片到指定的bucket中
     * @param image
     * @param bucketName
     * @param accessToken
     * @return
     */
    public String uploadToAliyun(Image image,
                                 String bucketName,
                                 String accessToken) {
        //...上传图片到阿里云...
        // ...返回图片存储在阿里云上的地址(url）...
        return "aliyunUrl";
    }

    public Image downloadFromAliyun(String url, String accessToken) {
        // 从aliyun下载图片
        return null;
    }
}
