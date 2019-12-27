package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String line;
        int existBreakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (existBreakIndex > 0) {
            line = text.substring(0, existBreakIndex + 1);
            return line + wrap(text.substring(existBreakIndex+1), lineWidth);
        }
        int boundary = text.lastIndexOf(' ', lineWidth);
        int breakIndex;
        if (boundary > 0) {
            breakIndex = boundary;
        } else {
            breakIndex = lineWidth;
        }
        line = text.substring(0, breakIndex);
        String remained = text.substring(breakIndex + 1);
        return line + LINEBREAK + wrap(remained, breakIndex);
    }
}
