package com.rick.learn.javaSE;

import java.math.BigDecimal;

/**
 * @author tianxiaobao@gegejia.com
 * @Description
 * @Date 2020-03-02
 */
public class BigDecimalClazz {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        double figure = 1.223;
        System.out.println(figure);
        BigDecimal fd = BigDecimal.valueOf(figure);
        System.out.println(fd);
        double convertFigure = figure - 1;
        System.out.println(convertFigure);
        BigDecimal f = BigDecimal.valueOf(convertFigure);
        System.out.println(f);
        double ff = 1.2222222222222222222222222;
        System.out.println(ff);
        BigDecimal ffd = BigDecimal.valueOf(ff);
        System.out.println(ffd);
        double fff = 1.2222225;
        System.out.println(fff);
        BigDecimal fffd = BigDecimal.valueOf(fff);
        System.out.println(fffd);
        double fffr = fff - 1;
        System.out.println(fffr);
        BigDecimal fffrd = BigDecimal.valueOf(fffr);
        System.out.println(fffrd);
    }
}
