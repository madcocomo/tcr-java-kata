package io.xp.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateSubStringFinderTest {
    @ParameterizedTest
    @MethodSource("inputAndExpect")
    void get_empty_from_empty(String input, String expect) {
        DuplicateSubStringFinder finder = new DuplicateSubStringFinder(input);
        assertEquals(expect, finder.longest());
    }

    static Stream<Arguments> inputAndExpect() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("a", ""),
                Arguments.of("aa", "a"),
                Arguments.of("aba", "a")
        );
    }
}
