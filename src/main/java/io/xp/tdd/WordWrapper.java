package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        int existBreakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (existBreakIndex > 0) {
            return text.substring(0, existBreakIndex+1) + wrap(text.substring(existBreakIndex+1), lineWidth);
        }
        int boundary = text.lastIndexOf(' ', lineWidth);
        int breakIndex;
        if (boundary > 0) {
            breakIndex = boundary;
        } else {
            breakIndex = lineWidth;
        }
        String substring = text.substring(0, breakIndex);
        String remained = text.substring(breakIndex + 1);
        return substring + LINEBREAK + wrap(remained, breakIndex);
    }
}
