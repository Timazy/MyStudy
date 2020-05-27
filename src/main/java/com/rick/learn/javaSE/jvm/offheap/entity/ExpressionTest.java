package com.rick.learn.javaSE.jvm.offheap.entity;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-04-30
 */
public class ExpressionTest {

    public static class Test {
        private long value;

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }
    }

    public Long getDefault(Test test, Long defaultValue) {
        return test == null ? defaultValue : test.getValue();
    }

    public static void main(String[] args) {
        new ExpressionTest().getDefault(null, null);
    }
}