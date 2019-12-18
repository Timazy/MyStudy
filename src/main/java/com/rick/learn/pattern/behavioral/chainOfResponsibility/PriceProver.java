package com.rick.learn.pattern.behavioral.chainOfResponsibility;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-18
 */
public class PriceProver extends AbstractApprover{
    @Override
    public void approve(Course course) {
        if (course.getPrice() != null){
            System.out.println("price approved");
            if (nextChain != null){
                nextChain.approve(course);
            }
        }
    }
}
