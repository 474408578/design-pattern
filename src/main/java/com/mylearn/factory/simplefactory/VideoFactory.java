package com.mylearn.factory.simplefactory;

/**
 * @author xschen
 *
 * http://laijianfeng.org/2018/09/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F-%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%E5%8F%8A%E5%85%B8%E5%9E%8B%E5%BA%94%E7%94%A8/
 */


public class VideoFactory {

    /**
     * 根据传入参数进行判断
     * @param type
     * @return
     */
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;
    }


    /**
     * 根据反射来创建对象
     * @param c
     * @return
     */
    public Video getVideo(Class c) {
        Video video = null;
        try {
            video = (Video) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
