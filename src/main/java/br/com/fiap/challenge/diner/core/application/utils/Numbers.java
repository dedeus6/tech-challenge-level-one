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

    public static double parseDoubleDec(Object value, int decimals) {
        String text = value.toString();
        if (decimals > 0)
            text = text.substring(0, text.length() - decimals) + "." + text.substring(text.length() - decimals);
        return Double.parseDouble(text);
    }

    public static Double parseDouble(Object value, Double def) {
        try {
            String text = value != null ? value.toString() : null;
            return Strings.isEmpty(text) ? def : Double.parseDouble(text.replace(',', '.'));
        } catch (Exception e) {
            return def;
        }
    }
}
