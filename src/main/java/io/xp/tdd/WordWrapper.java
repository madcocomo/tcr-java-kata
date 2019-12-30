package io.xp.tdd;

public class WordWrapper {
    public String format(String text, int lineWidth) {
        LineAndRemainder lineAndRemainder = new LineAndRemainder(text, lineWidth);
        StringBuilder result = new StringBuilder();
        while (lineAndRemainder.hasNextLine()) {
            result.append(lineAndRemainder.nextLine());
        }
        return result.toString();
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

        public String nextLine() {
            boolean extracted = extractLineShorterThanWidth() || extractAtExistingBreak()
                    || extractAtSpace() || extractAtLineWidth();
            return line;
        }

        private boolean extractLineShorterThanWidth() {
            if (remainder.length() <= lineWidth) {
                line = remainder;
                remainder = "";
                return true;
            }
            return false;
        }

        private boolean extractAtLineWidth() {
            line = remainder.substring(0, lineWidth)+LINEBREAK;
            remainder = remainder.substring(lineWidth);
            return true;
        }

        private boolean extractAtSpace() {
            int index = remainder.lastIndexOf(SPACE, lineWidth);
            if (index >= 0) {
                line = remainder.substring(0, index)+LINEBREAK;
                remainder = remainder.substring(index+1);
                return true;
            }
            return false;
        }

        private boolean extractAtExistingBreak() {
            int breakIndex = remainder.lastIndexOf(LINEBREAK, lineWidth);
            if (breakIndex >= 0) {
                line = remainder.substring(0, breakIndex+1);
                remainder = remainder.substring(breakIndex+1);
                return true;
            }
            return false;
        }

        private boolean hasNextLine() {
            return !remainder.isEmpty();
        }
    }
}
