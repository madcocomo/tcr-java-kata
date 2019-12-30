package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String format(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String remainder = text.substring(lineWidth);
        return  text.substring(0, lineWidth) + LINEBREAK + format(remainder, lineWidth);
    }
}
