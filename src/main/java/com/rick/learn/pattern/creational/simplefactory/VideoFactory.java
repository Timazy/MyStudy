package com.rick.learn.pattern.creational.simplefactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-08
 */
public class VideoFactory {

    public AbstractVideo buildVideo(Class clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        AbstractVideo abstractVideo = null;
        if (AbstractVideo.class.isAssignableFrom(clazz)){
            abstractVideo = (AbstractVideo) (Class.forName(clazz.getName()).newInstance());
        }
        return abstractVideo;
    }

}
