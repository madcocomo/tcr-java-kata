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

    private boolean isDuplicatedAfter(int index, String candidate) {
        int length = candidate.length();
        for (int i = index+1; i+length <= str.length(); i++) {
            if (candidate.equals(subString(i, i+length))) {
                return true;
            }
        }
        return false;
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
