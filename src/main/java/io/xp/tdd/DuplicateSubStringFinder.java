package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        for (int i = 0; i < str.length(); i++) {
            String candidate = findDuplicateAt(i);
            if (candidate != null) return candidate;
        }
        return "";
    }

    private String findDuplicateAt(int index) {
        for (int k = str.length() - index-1; k > 0; k--) {
            String candidate = subString(index, index + k);
            if (isDuplicatedAfter(index, candidate)) return candidate;
        }
        return null;
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
