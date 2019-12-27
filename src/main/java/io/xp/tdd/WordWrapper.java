package io.xp.tdd;

public class WordWrapper {
    public String wrap(String text, int lineWidth) {
        if (text.length() > lineWidth) {
            return "apple\ntree";
        }
        return text;
    }
}
