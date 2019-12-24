package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;

    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int subLength = longestDuplicateAt(i);
            if (subLength > result.length()) {
                result = subString(i, i+subLength);
            }
        }
        return result;
    }

    private int longestDuplicateAt(int index) {
        int longestAtIndex = 0;
        for (int i = index+1; i < str.length(); i++) {
            longestAtIndex = Math.max(longestAtIndex, duplicateLength(index, i));
        }
        return longestAtIndex;
    }

    private int duplicateLength(int index, int i) {
        int length = 0;
        for (; length < str.length() - i; length++) {
            if (str.charAt(index+length) != str.charAt(i+length)) {
                break;
            }
        }
        return length;
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
