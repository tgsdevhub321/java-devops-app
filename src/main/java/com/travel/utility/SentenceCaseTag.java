package com.travel.utility;

public class SentenceCaseTag{

    public static String SentenceCase(String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }

        String trimmed = value.trim();
        String result =
                trimmed.substring(0, 1).toUpperCase() +
                trimmed.substring(1).toLowerCase();
        return result;
    }
}
