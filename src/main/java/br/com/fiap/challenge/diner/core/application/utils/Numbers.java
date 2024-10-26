package br.com.fiap.challenge.diner.core.application.utils;

import java.math.BigDecimal;

public class Numbers {

    public static boolean isEmpty(Integer item) {
        return item == null || item <= 0;
    }

    public static boolean isNonEmpty(Integer item) {
        return item != null && item > 0;
    }

    public static boolean isEmpty(Long item) {
        return item == null || item <= 0L;
    }

    public static boolean isNonEmpty(Long item) {
        return item != null && item > 0L;
    }

    public static boolean isEmpty(Double item) {
        return item == null || item <= 0.0;
    }

    public static boolean isNonEmpty(Double item) {
        return item != null && item > 0.0;
    }

    public static boolean isEmpty(BigDecimal item) {
        return item == null || item.compareTo(BigDecimal.ZERO) <= 0;
    }
}
