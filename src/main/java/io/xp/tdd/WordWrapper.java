package io.xp.tdd;

public class WordWrapper {
    public String format(String text, int lineWidth) {
        LineAndRemainder lineAndRemainder = new LineAndRemainder(text, lineWidth);
        lineAndRemainder.extractOneLine();
        String result = lineAndRemainder.getLine();
        while (!lineAndRemainder.remainder.isEmpty()) {
            return result + format(lineAndRemainder.getRemainder(), lineWidth);
        }
        return result;
    }

    private class LineAndRemainder {
        public static final String LINEBREAK = "\n";
        public static final String SPACE = " ";
        private int lineWidth;
        private String remainder;
        private String line;

        public LineAndRemainder(String text, int lineWidth) {
            this.remainder = text;
            this.lineWidth = lineWidth;
        }

        public String getRemainder() {
            return remainder;
        }

        public String getLine() {
            return line;
        }

        public void extractOneLine() {
            line = null;
            if (remainder.length() <= lineWidth) {
                line = remainder;
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
            line = remainder.substring(0, lineWidth)+LINEBREAK;
            remainder = remainder.substring(lineWidth);
        }

        private void extractAtSpace() {
            int index = remainder.lastIndexOf(SPACE, lineWidth);
            if (index >= 0) {
                line = remainder.substring(0, index)+LINEBREAK;
                remainder = remainder.substring(index+1);
            }
        }

        private void extractAtExistingBreak() {
            int breakIndex = remainder.lastIndexOf(LINEBREAK, lineWidth);
            if (breakIndex >= 0) {
                line = remainder.substring(0, breakIndex+1);
                remainder = remainder.substring(breakIndex+1);
            }
        }

        private boolean isExtracted() {
            return line != null;
        }
    }
}
