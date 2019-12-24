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
        for (int i = index+1; i < str.length(); i++) {
            int lengthAtI = 0;
            for (int length = 0; length < str.length() - i; length++) {
                if (str.charAt(index + length) != str.charAt(i+length)) {
                    break;
                }
                lengthAtI = length+1;
           }
        }
        for (int length = 1; index + length <= str.length(); length++) {
            String candidate = subString(index, index + length);
            boolean result = false;
            for (int i = index +1; i+ length <= str.length(); i++) {
                if (candidate.equals(subString(i, i+ length))) {
                    result = true;
                    break;
                }
            }
            if (!result) return length-1;
        }
        return 0;
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
