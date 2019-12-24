package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        if (str.length() > 1) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = i+1; j+2 <= str.length(); j++) {
                    if (subString(i, i+2).equals(subString(j, j+2))) {
                        return subString(i, i+2);
                    }
                }
                for (int j = i+1; j < str.length(); j++) {
                    if (subString(i, i+1).equals(subString(j, j+1))) {
                        return subString(i, i+1);
                    }
                }
            }
        }
        return "";
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
