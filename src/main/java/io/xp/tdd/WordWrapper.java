package io.xp.tdd;

public class WordWrapper {
    public String format(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        LineAndRemainder lineAndRemainder = new LineAndRemainder(text, lineWidth);
        lineAndRemainder.extractOneLine();
        while (!lineAndRemainder.remainder.isEmpty()) {
            return lineAndRemainder.getLine() + format(lineAndRemainder.getRemainder(), lineWidth);
        }
        return  lineAndRemainder.getLine() + format(lineAndRemainder.getRemainder(), lineWidth);
    }

    private class LineAndRemainder {
        public static final String LINEBREAK = "\n";
        public static final String SPACE = " ";
        private String text;
        private int lineWidth;
        private String remainder;
        private String line;

        public LineAndRemainder(String text, int lineWidth) {
            this.text = text;
            this.lineWidth = lineWidth;
        }

        public String getRemainder() {
            return remainder;
        }

        public String getLine() {
            return line;
        }

        public void extractOneLine() {
            if (text.length() <= lineWidth) {
                line = text;
                remainder = "";
                return;
            }
            extractAtExistingBreak();
            if (isExtracted()) {
                return;
            }
            extractAtSpace();
            if (isExtracted()) {
                return;
            }
            extractAtLineWidth();
        }

        public void extractAtLineWidth() {
            line = text.substring(0, lineWidth)+LINEBREAK;
            remainder = text.substring(lineWidth);
        }

        private void extractAtSpace() {
            int index = text.lastIndexOf(SPACE, lineWidth);
            if (index >= 0) {
                line = text.substring(0, index)+LINEBREAK;
                remainder = text.substring(index+1);
            }
        }

        private void extractAtExistingBreak() {
            int breakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
            if (breakIndex >= 0) {
                line = text.substring(0, breakIndex+1);
                remainder = text.substring(breakIndex+1);
            }
        }

        private boolean isExtracted() {
            return line != null;
        }
    }
}
