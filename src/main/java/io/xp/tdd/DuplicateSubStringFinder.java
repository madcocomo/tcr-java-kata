package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        if (str.length() > 1) {
            for (int i = 0; i < str.length(); i++) {
                for (int k = str.length() - i; k > 0; k--) {
                    String candidate = subString(i, i + k);
                    for (int j = i+1; j+k <= str.length(); j++) {
                        if (candidate.equals(subString(j, j+k))) {
                            return candidate;
                        }
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
