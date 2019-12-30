package io.xp.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapperTest {
    @Test
    void should_keep_same_if_shorter_than_line_width() {
        WordWrapper wrapper = new WordWrapper();
        assertEquals("apple", wrapper.format("apple", 10));
    }

    @Test
    void should_add_break_at_line_width() {
        WordWrapper wrapper = new WordWrapper();
        assertEquals("apple\ntree", wrapper.format("appletree", 5));
    }
}
