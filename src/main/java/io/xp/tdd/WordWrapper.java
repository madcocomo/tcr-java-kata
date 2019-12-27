package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String line;
        line = getLine(text, lineWidth);
        return line + wrap(text.substring(line.length()), lineWidth);
    }

    private String getLine(String text, int lineWidth) {
        String line;
        int existBreakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (existBreakIndex > 0) {
            return text.substring(0, existBreakIndex + 1);
        } else {
            int boundary = text.lastIndexOf(' ', lineWidth);
            int breakIndex;
            if (boundary > 0) {
                breakIndex = boundary;
            } else {
                breakIndex = lineWidth;
            }
            line = text.substring(0, breakIndex) + LINEBREAK;
        }
        return line;
    }
}
