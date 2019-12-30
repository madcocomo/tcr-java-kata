Your job is to write a function that takes a string and a maximum number of characters per line and then inserts line breaks as necessary so that no line in the resulting string is longer than the specified limit.

You try to break lines at word boundaries.

Like a word processor, break the line by replacing the last space in a line with a newline.

If possible, line breaks should not split words. However, if a single word is longer than the limit, it obviously has to be split.
Really long words may need to be split multiple times.

Some examples. the `--` represents line break.
1. ("test", 7) -> "test"
1. ("hello world", 7) -> "hello--world"
1. ("a lot of words for a single line", 10) -> "a lot of--words for--a single--line"
1. ("this is a test", 4) -> "this--is a--test"
1. ("a longword", 6) -> "a long--word"
1. ("areallylongword", 6) -> "areall--ylongw--ord"
