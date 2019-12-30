package io.xp.tdd;

public class WordWrapper {

    public static final String LINEBREAK = "\n";
    public static final String SPACE = " ";

    public String format(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        LineAndRemainder lineAndRemainder = new LineAndRemainder(text, lineWidth);
        return  lineAndRemainder.getLine() + format(lineAndRemainder.getRemainder(), lineWidth);
    }

    private class LineAndRemainder {
        private String text;
        private int lineWidth;
        private String remainder;
        private String line;

        public LineAndRemainder(String text, int lineWidth) {
            this.text = text;
            this.lineWidth = lineWidth;
            extractOneLine();
        }

        public String getRemainder() {
            return remainder;
        }

        public String getLine() {
            return line;
        }

        public void extractOneLine() {
            extractAtExistingBreak();
            if (line != null) {
                return;
            }
            int index = text.lastIndexOf(SPACE, lineWidth);
            if (index >= 0) {
                line = text.substring(0, index)+LINEBREAK;
                remainder = text.substring(index+1);
            } else {
                line = text.substring(0, lineWidth)+LINEBREAK;
                remainder = text.substring(lineWidth);
            }
        }

        private boolean extractAtExistingBreak() {
            int breakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
            if (breakIndex >= 0) {
                line = text.substring(0, breakIndex+1);
                remainder = text.substring(breakIndex+1);
                return true;
            }
            return false;
        }
    }
}
