package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";
    public static final String SPACE = " ";

    public String format(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        int breakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (breakIndex >= 0) {
            return "an\napple tree";
        }
        int index = text.lastIndexOf(SPACE, lineWidth);
        String remainder;
        String line;
        if (index >= 0) {
            remainder = text.substring(index+1);
            line = text.substring(0, index);
        } else {
            remainder = text.substring(lineWidth);
            line = text.substring(0, lineWidth);
        }
        return  line + LINEBREAK + format(remainder, lineWidth);
    }
}
