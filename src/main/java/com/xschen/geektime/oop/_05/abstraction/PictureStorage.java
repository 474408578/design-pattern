package com.xschen.geektime.oop._05.abstraction;

import java.awt.*;

/**
 * @author xschen
 */


public class PictureStorage implements IPictureStorage {
    @Override
    public void savePicture(Picture picture) {

    }

    @Override
    public void deletePicture(String pictureId) {

    }

    @Override
    public Image modifyMetaIndo(String pictureId, PictureMetaInfo metaInfo) {
        return null;
    }

    @Override
    public Image getPicture(String pictureId) {
        return null;
    }
}
