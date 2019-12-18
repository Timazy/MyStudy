package com.rick.learn.pattern.behavioral.chainOfResponsibility;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2019-12-18
 */
public class NameProver extends AbstractApprover{
    @Override
    public void approve(Course course) {
        if (course.getName() != null){
            System.out.println("name approve");
            if (nextChain != null){
                nextChain.approve(course);
            }
        }else {
            System.out.println("name forbidden, approve over");
        }
    }
}
