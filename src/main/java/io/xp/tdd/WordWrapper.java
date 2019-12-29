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
        int existBreakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (existBreakIndex > 0) {
            return text.substring(0, existBreakIndex + 1);
        }
        if (text.charAt(lineWidth) == '-') {
            return text.substring(0, lineWidth);
        } else if (text.charAt(lineWidth) == ' ') {
            return text.substring(0, lineWidth) + LINEBREAK;
        } else {
            for (int i = lineWidth - 1; i >= 0; i--) {
                if (text.charAt(i) == ' ') {
                    return text.substring(0, i) + LINEBREAK;
                }
                if (text.charAt(i) == '-') {
                    return text.substring(0, i + 1);
                }
            }
        }
        return text.substring(0, lineWidth);
    }

}
