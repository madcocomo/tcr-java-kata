package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        if (str.length() > 1) {
            if (str.substring(0, 1).equals(str.substring(1, 2))) {
                return str.substring(0, 1);
            }
        }
        return "";
    }
}
