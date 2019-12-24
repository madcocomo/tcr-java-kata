package io.xp.tdd;

public class DuplicateSubStringFinder {
    public String longest(String str) {
        if (str.length() > 1) {
            return str.substring(0, 1);
        }
        return "";
    }
}
