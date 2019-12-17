package com.rick.learn.pattern.structural.facade;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class CheckGiftService {

    public boolean doCheckout(Gift gift){
        if (gift.getSku() > 0){
            System.out.println("gift " + gift.getName() + " available");
            return true;
        }
        return false;
    }

}
