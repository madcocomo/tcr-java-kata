package io.xp.tdd;

public class WordWrapper {
    public String wrap(String text, int lineWidth) {
        if (text.length() > lineWidth) {
            String remained = text.substring(lineWidth + 1);
            if (remained.length() > lineWidth) {
                remained = remained.substring(0, lineWidth) + "\n" + remained.substring(lineWidth+1);
            }
            return text.substring(0, lineWidth) + "\n" + remained;
        }
        return text;
    }
}
