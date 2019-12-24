package io.xp.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateSubStringFinderTest {
    DuplicateSubStringFinder finder = new DuplicateSubStringFinder();
    @Test
    void get_empty_from_empty() {
        assertEquals("", finder.longest(""));
    }

    @Test
    void get_empty_from_single_character() {
        assertEquals("", finder.longest("a"));
    }
}
