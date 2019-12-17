package com.rick.learn.pattern.creational.simplefactory;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-08
 */
public class Test {

    /**
     * @see java.util.ArrayList itr
     * @param args
     */
    public static void main(String[] args) {
        VideoFactory factory = new VideoFactory();
        try {
            AbstractVideo video = factory.buildVideo(JavaVideo.class);
            video.produce();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
