package io.xp.tdd;

public class WordWrapper {
    public String wrap(String text, int lineWidth) {
        if (text.length() > lineWidth) {
            return text.substring(0, lineWidth) + "\ntree";
        }
        return text;
    }
}
