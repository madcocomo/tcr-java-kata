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

    @Test
    void multiple_words_in_a_line_edge_case() {
        assertEquals("an apple\ntrees", wrapper.wrap("an apple trees", 8));
    }

    @Test
    void should_not_add_linebreak_if_already_break() {
        assertEquals("an\napple\ntree", wrapper.wrap("an\napple tree", 8));
        assertEquals("an apple\ntree", wrapper.wrap("an apple\ntree", 8));
        assertEquals("an\napple tree", wrapper.wrap("an\napple tree", 10));
    }

    @Test
    void should_break_word_if_longer_than_line_width() {
        assertEquals("congratu\nlations", wrapper.wrap("congratulations", 8));
    }

    @Test
    void should_break_word_if_longer_than_multiple_lines() {
        assertEquals("congr\natula\ntions", wrapper.wrap("congratulations", 5));
    }

    @Test
    void lots_words_in_a_line() {
        assertEquals("a bb ccc\ndddddddd\nd eee ff\ng", wrapper.wrap("a bb ccc ddddddddd eee ff g", 8));
    }

    @Test
    void should_break_at_boundary_other_than_space() {
        assertEquals("apple\n-tree", wrapper.wrap("apple-tree", 5));
        assertEquals("apple-\ntree", wrapper.wrap("apple-tree", 6));
        assertEquals("apple-\ntree", wrapper.wrap("apple-tree", 7));
        assertEquals("an apple\n-tree", wrapper.wrap("an apple-tree", 8));
        assertEquals("an apple-\ntree", wrapper.wrap("an apple-tree", 9));
    }
}
