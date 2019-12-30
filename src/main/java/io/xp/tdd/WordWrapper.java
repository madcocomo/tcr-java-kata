package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";
    public static final String SPACE = " ";

    public String format(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String remainder;
        String line;
        int breakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (breakIndex >= 0) {
            line = text.substring(0, breakIndex+1);
            remainder = text.substring(breakIndex+1);
            return line + format(remainder, lineWidth);
        }
        int index = text.lastIndexOf(SPACE, lineWidth);
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
