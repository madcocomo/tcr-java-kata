package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        int boundary = text.lastIndexOf(" ", lineWidth);
        int breakIndex = 0;
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
