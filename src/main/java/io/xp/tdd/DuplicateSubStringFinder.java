package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int subLength = findDuplicateAt(i);
            if (subLength > result.length()) {
                result = subString(i, i+subLength);
            }
        }
        return result;
    }

    private int findDuplicateAt(int index) {
        for (int length = str.length() - index-1; length > 0; length--) {
            String candidate = subString(index, index + length);
            if (isDuplicatedAfter(index, candidate)) return candidate.length();
        }
        return "".length();
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
