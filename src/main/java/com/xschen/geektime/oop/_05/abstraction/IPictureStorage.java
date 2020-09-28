package com.xschen.geektime.oop._05.abstraction;

import java.awt.*;

/**
 * @author xschen
 * OOP：抽象
 */


public interface IPictureStorage {
    void savePicture(Picture picture);
    void deletePicture(String pictureId);
    Image modifyMetaIndo(String pictureId, PictureMetaInfo metaInfo);
    Image getPicture(String pictureId);
}
