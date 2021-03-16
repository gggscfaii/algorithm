package com.wsd.algorithm.basic;

import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * BigDecimalTest
 *
 * @author wangshudong
 * @date 2021/1/30
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1.3);
        BigDecimal b = new BigDecimal(3.4);

        System.out.println(a.multiply(b));
        System.out.println(a.multiply(b).longValue());

        Mono.never().subscribe(System.out::println);

        System.out.println(1^2);
    }
}
