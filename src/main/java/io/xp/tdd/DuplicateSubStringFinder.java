package io.xp.tdd;

public class DuplicateSubStringFinder {
    private String str;
    int longest = 0;
    int index = 0;
    
    public DuplicateSubStringFinder(String str) {
        this.str = str;
    }

    public String longest() {
        for (int i = 0; i < str.length(); i++) {
            int subLength = longestDuplicateAt(i);
            if (subLength > longest) {
                longest = subLength;
                index = i;
            }
        }
        return subString(index, index+longest);
    }

    private int longestDuplicateAt(int index) {
        int longestAtIndex = 0;
        for (int i = index+1; i < str.length(); i++) {
            longestAtIndex = Math.max(longestAtIndex, duplicateLength(index, i));
        }
        return longestAtIndex;
    }

    private int duplicateLength(int index, int anotherIndex) {
        for (int length = 0; length < str.length() - anotherIndex; length++) {
            if (str.charAt(index+length) != str.charAt(anotherIndex+length)) {
                return length;
            }
        }
        return str.length() - anotherIndex;
    }

    private String subString(int start, int end) {
        return str.substring(start, end);
    }
}
