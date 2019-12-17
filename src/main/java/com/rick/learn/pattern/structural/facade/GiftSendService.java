package com.rick.learn.pattern.structural.facade;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-15
 */
public class GiftSendService {

    //autowired
    CheckGiftService checkGiftService = new CheckGiftService();

    //autowired
    RiskControlService riskControlService = new RiskControlService();

    public void doSend(Gift gift){
        if (checkGiftService.doCheckout(gift) && riskControlService.doRiskControl(gift)){
            System.out.println("gift " + gift.getName() + " ready to send");
        }
    }

}
