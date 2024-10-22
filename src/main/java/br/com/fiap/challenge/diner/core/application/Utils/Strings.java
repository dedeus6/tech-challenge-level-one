package br.com.fiap.challenge.diner.core.application.Utils;

public class Strings {

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNonEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    public static boolean equals(String a, String b) {
        if (a != null && b != null) {
            return a.equalsIgnoreCase(b);
        } else {
            return a == b;
        }
    }

    public static boolean diff(String a, String b) {
        if (a != null && b != null) {
            return !a.equalsIgnoreCase(b);
        } else {
            return a != b;
        }
    }
}
