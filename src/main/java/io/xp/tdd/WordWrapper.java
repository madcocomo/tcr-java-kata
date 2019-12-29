package io.xp.tdd;

public class WordWrapper {

    public static final char LINEBREAK = '\n';

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String line = getLine(text, lineWidth);
        String remainder = text.substring(line.length());
        if (!line.endsWith(String.valueOf(LINEBREAK))) {
            line += LINEBREAK;
        }
        return line + wrap(remainder, lineWidth);
    }

    private String getLine(String text, int lineWidth) {
        String existBreakIndex1 = getLineAtBreak(text, lineWidth);
        if (existBreakIndex1 != null) return existBreakIndex1;
        {
            int boundary = text.lastIndexOf(' ', lineWidth);
            if (boundary > 0) {
                return text.substring(0, boundary) + LINEBREAK;
            }
        }
        {
            int boundary = text.lastIndexOf('-', lineWidth-1);
            if (boundary > 0) {
                return text.substring(0, boundary+1);
            }
        }
        return text.substring(0, lineWidth);
    }

    private String getLineAtBreak(String text, int lineWidth) {
        int existBreakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (existBreakIndex > 0) {
            return text.substring(0, existBreakIndex + 1);
        }
        return null;
    }

}
