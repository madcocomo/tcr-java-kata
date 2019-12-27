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

    @Test
    void add_multiple_linebreak_right_after_words() {
        assertEquals("apple\ntrees\nyard", wrapper.wrap("apple trees yard", 5));
    }

    @Test
    void should_not_add_linebreak_at_end() {
        assertEquals("apple\ntrees", wrapper.wrap("apple trees", 5));
    }

    @Test
    void add_break_at_word_boundary_if_next_above_length() {
        assertEquals("apple\ntrees", wrapper.wrap("apple trees", 8));
    }

    @Test
    void add_break_at_word_boundary_multiple_words_in_a_line() {
        assertEquals("an apple\ntrees", wrapper.wrap("an apple trees", 10));
    }
}
