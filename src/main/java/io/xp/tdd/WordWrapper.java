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
        String line;
        String result1 = null;
        if (text.charAt(lineWidth) == '-') {
            result1 = text.substring(0, lineWidth);
        } else if (text.charAt(lineWidth) == ' ') {
            result1 = text.substring(0, lineWidth) + LINEBREAK;
        } else {
            for (int i = lineWidth - 1; i >= 0; i--) {
                if (text.charAt(i) == ' ') {
                    result1 = text.substring(0, i) + LINEBREAK;
                    break;
                }
                if (text.charAt(i) == '-') {
                    result1 = text.substring(0, i + 1);
                    break;
                }
            }
        }
        line = result1;
        if (line != null) return line;
        return text.substring(0, lineWidth);
    }

}
