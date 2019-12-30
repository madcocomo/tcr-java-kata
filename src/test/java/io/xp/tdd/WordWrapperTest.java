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

    @Test
    void should_not_add_break_at_end() {
        assertEquals("apple", wrapper.format("apple", 5));
    }

    @Test
    void should_add_multiple_breaks() {
        assertEquals("anap\nplet\nree", wrapper.format("anappletree", 4));
    }

    @Test
    void should_add_break_at_space_before_line_width() {
        assertEquals("an\napple", wrapper.format("an apple", 5));
    }

    @Test
    void should_add_break_at_last_space() {
        assertEquals("an apple\ntree", wrapper.format("an apple tree", 10));
    }

    @Test
    void should_add_multiple_breaks_at_space() {
        assertEquals("an\napple\ntree", wrapper.format("an apple tree", 5));
    }

    @Test
    void should_not_leave_space_at_line_beginning() {
        assertEquals("apple\ntree", wrapper.format("apple tree", 5));
    }

    @Test
    void should_not_add_empty_line_at_end() {
        assertEquals("apple\n", wrapper.format("apple ", 5));
    }
}
