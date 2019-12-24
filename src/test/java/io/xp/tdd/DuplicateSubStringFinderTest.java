package io.xp.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateSubStringFinderTest {
    @Test
    void get_empty_from_empty() {
        DuplicateSubStringFinder finder = new DuplicateSubStringFinder();
        assertEquals("", finder.longest(""));
    }

    @Test
    void get_empty_from_single_character() {
        DuplicateSubStringFinder finder = new DuplicateSubStringFinder();
        assertEquals("", finder.longest("a"));
    }
}
