package io.xp.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapperTest {
    WordWrapper wrapper = new WordWrapper();
    @Test
    void keep_same_when_shorter_than_line_width() {
        assertEquals("apple", wrapper.wrap("apple", 10));
    }

    @Test
    void add_linebreak_right_after_word() {
        assertEquals("apple\ntree", wrapper.wrap("apple tree", 5));
    }
}
