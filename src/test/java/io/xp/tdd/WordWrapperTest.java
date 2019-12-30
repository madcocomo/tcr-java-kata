package io.xp.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapperTest {
    WordWrapper wrapper = new WordWrapper();
    @Test
    void should_keep_same_if_shorter_than_line_width() {
        assertEquals("apple", wrapper.format("apple", 10));
    }

    @Test
    void should_add_break_at_line_width() {
        assertEquals("apple\ntree", wrapper.format("appletree", 5));
    }
}
