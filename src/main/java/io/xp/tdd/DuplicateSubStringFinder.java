package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        if (str.length() > 1) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = i+1; j < str.length(); j++) {
                    if (subString(i, i+1).equals(subString(j, j+1))) {
                        return subString(i, i+1);
                    }
                }
            }
            for (int j = 1; j < str.length(); j++) {
                if (subString(1, 2).equals(subString(j, j+1))) {
                    return subString(1, 2);
                }
            }
        }
        return "";
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
