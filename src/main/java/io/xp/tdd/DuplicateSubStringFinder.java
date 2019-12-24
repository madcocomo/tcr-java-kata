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
                    if (isDuplicatedAfter(i, candidate)) return candidate;
                }
            }
        }
        return "";
    }

    private boolean isDuplicatedAfter(int i, String candidate) {
        for (int j = i+1; j+candidate.length() <= str.length(); j++) {
            if (candidate.equals(subString(j, j+candidate.length()))) {
                return true;
            }
        }
        return false;
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
