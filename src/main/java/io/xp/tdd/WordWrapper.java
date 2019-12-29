package io.xp.tdd;

public class WordWrapper {

    public static final char LINEBREAK = '\n';

    public String wrap(String text, int lineWidth) {
        if (text.length() <= lineWidth) {
            return text;
        }
        String line = getLine(text, lineWidth);
        String remainder = text.substring(line.length());
        if (!line.endsWith(String.valueOf(LINEBREAK))) {
            line += LINEBREAK;
        }
        return line + wrap(remainder, lineWidth);
    }

    private String getLine(String text, int lineWidth) {
        String line;
        line = getLineAtBreak(text, lineWidth);
        if (line != null) return line;
        line = getLineAtSpace(text, lineWidth);
        if (line != null) return line;
        line = getLineAtNoWords(text, lineWidth);
        if (line != null) return line;
        return text.substring(0, lineWidth);
    }

    private String getLineAtNoWords(String text, int lineWidth) {
        int boundary = text.lastIndexOf('-', lineWidth-1);
        if (boundary > 0) {
            return text.substring(0, boundary+1);
        }
        return null;
    }

    private String getLineAtSpace(String text, int lineWidth) {
        if (text.charAt(lineWidth) == '-') {
            return text.substring(0, lineWidth);
        }
        if (text.charAt(lineWidth) == ' ') {
            return text.substring(0, lineWidth) + LINEBREAK;
        }
        for (int i = lineWidth-1; i >= 0; i--) {
           if (text.charAt(i) == ' ') {
               return text.substring(0, i) + LINEBREAK;
           }
            if (text.charAt(i) == '-') {
                return text.substring(0, i+1);
            }
        }
        return null;
    }

    private String getLineAtBreak(String text, int lineWidth) {
        int existBreakIndex = text.lastIndexOf(LINEBREAK, lineWidth);
        if (existBreakIndex > 0) {
            return text.substring(0, existBreakIndex + 1);
        }
        return null;
    }

}
