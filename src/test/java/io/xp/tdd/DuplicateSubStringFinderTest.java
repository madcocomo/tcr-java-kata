package io.xp.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateSubStringFinderTest {
    DuplicateSubStringFinder finder = new DuplicateSubStringFinder();
    @ParameterizedTest
    @MethodSource("stringAndExpect")
    void get_empty_from_empty(String str, String expect) {
        assertEquals(expect, finder.longest(str));
    }

    static Stream<Arguments> stringAndExpect() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of("a", "")
        );
    }
}
