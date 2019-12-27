package io.xp.tdd;

public class WordWrapper {
    public String wrap(String text, int lineWidth) {
        if (text.length() > lineWidth) {
            String remained = text.substring(lineWidth + 1);
            return text.substring(0, lineWidth) + "\n" + wrap(remained, lineWidth);
        }
        return text;
    }
}
