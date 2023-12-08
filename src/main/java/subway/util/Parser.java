package subway.util;

import static subway.util.Constant.BLANK;
import static subway.util.Constant.EMPTY;

public class Parser {
    public static String parseInput(String input) {
        try {
            return input.trim().replaceAll(BLANK, EMPTY);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
