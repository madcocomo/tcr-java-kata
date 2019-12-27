package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        int boundary = text.indexOf(" ");
        String substring;
        int breakIndex = 0;
        if (boundary < lineWidth) {
            breakIndex = boundary;
        } else {
            breakIndex = lineWidth;
        }
        substring = text.substring(0, breakIndex);
        String remained = text.substring(breakIndex + 1);
        return substring + LINEBREAK + wrap(remained, breakIndex);
    }
}
