package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        if (str.length() > 1) {
            if (subString(0, 1).equals(subString(1, 2))) {
                return subString(0, 1);
            }
        }
        return "";
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
