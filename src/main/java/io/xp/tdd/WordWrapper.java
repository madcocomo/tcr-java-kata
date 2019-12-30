package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";

    public String format(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        int index = text.indexOf(" ");
        if (index >= 0) {
            String remainder = text.substring(index+1);
            return text.substring(0, index) + LINEBREAK + remainder;
        }
        String remainder = text.substring(lineWidth);
        return  text.substring(0, lineWidth) + LINEBREAK + format(remainder, lineWidth);
    }
}
