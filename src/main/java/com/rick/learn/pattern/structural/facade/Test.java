package com.rick.learn.pattern.structural.facade;

/**
 * @author tianxiaobao@gegejia.com
 * @Description GiftSendService 单一流程，如果有多种流程，提取抽象外观接口
 * 门面模式/外观模式
 * @Date 2019-12-15
 */
public class Test {

    public static void main(String[] args) {
        GiftSendService sendService = new GiftSendService();
        sendService.doSend(new Gift("pmn",2));
    }
}
