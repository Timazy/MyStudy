package com.rick.learn.pattern.structural.facade;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class RiskControlService {

    public boolean doRiskControl(Gift gift){
        System.out.println("git " + gift.getName() + " control accessed");
        return true;
    }

}
