package subway.view;

import subway.util.Validator;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String WANTED_FUNCTION = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION = "## 출발역을 입력하세요.";
    private static final String END_STATION = "## 도착역을 입력하세요.";

    private InputView() {
    }

    public static String inputFunction() {
        System.out.println(WANTED_FUNCTION);
        String userInput = scanner.nextLine();

        Validator.validateEmptyInput(userInput);
        return userInput;
    }

    public static String inputStartStation() {
        System.out.println("\n" + START_STATION);
        String input = scanner.nextLine();

        Validator.validateEmptyInput(input);
        Validator.validateLength(input.length());
        return input;
    }

    public static String inputEndStation() {
        System.out.println("\n" + END_STATION);
        String input = scanner.nextLine();

        Validator.validateEmptyInput(input);
        Validator.validateLength(input.length());
        return input;
    }
}
