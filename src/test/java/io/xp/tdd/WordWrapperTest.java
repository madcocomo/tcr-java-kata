package io.xp.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapperTest {
    @Test
    void keep_same_when_shorter_than_line_width() {
        WordWrapper wrapper = new WordWrapper();
        assertEquals("apple", wrapper.wrap("apple", 10));

    }
}
