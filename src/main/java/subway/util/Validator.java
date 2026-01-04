package subway.util;

import java.util.List;
import java.util.regex.Pattern;

import static subway.util.ErrorMessage.INPUT_ERROR;
import static subway.util.ErrorMessage.RANGE_ERROR;

public class Validator {

    private static final List<String> mainNumber = List.of("1", "Q");
    private static final List<String> routeNumber = List.of("1", "2", "B");
    private static final int MIN_NAME_LENGTH = 2;

    private Validator() {
    }

    // 빈값 검증
    public static void validateEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_ERROR.getMessage());
        }
    }

    // 값 범위 검증
    public static void validateLength(int value) {
        if (value < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(RANGE_ERROR.getMessage());
        }
    }

    public static void validateMainInput(String input) {
        if (!mainNumber.contains(input)) {
            throw new IllegalArgumentException(INPUT_ERROR.getMessage());
        }
    }

    public static void validateRouteInput(String input) {
        if (!routeNumber.contains(input)) {
            throw new IllegalArgumentException(INPUT_ERROR.getMessage());
        }
    }
}

