package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String remained = text.substring(lineWidth + 1);
        return text.substring(0, lineWidth) + LINEBREAK + wrap(remained, lineWidth);
    }
}
