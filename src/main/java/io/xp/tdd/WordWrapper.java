package io.xp.tdd;

public class WordWrapper {
    public String format(String text, int lineWidth) {
        if (text.length() < lineWidth) {
            return text;
        }
        return text.substring(0, lineWidth) + "\n" + text.substring(lineWidth);
    }
}
