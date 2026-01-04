package subway.controller;

import subway.domain.Station;
import subway.domain.TimeLine;
import subway.service.SubwayService;
import subway.util.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SubwayController {

    private final SubwayService subwayService;

    public SubwayController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    public void start() {
        // 초기 설정
        init();
        play();
    }

    private void play() {
        while (true) {
            String mainInput = inputMainFunctionAndValidate();

            if (mainInput.equals("1")) {
                String routeInput = inputRouteFunctionAndValidate();
                playRouteFunction(routeInput);
                continue;
            }
            if (mainInput.equals("Q")) break;
        }
    }

    private void init() {
        subwayService.init();
    }

    //Main
    private String inputMainFunctionAndValidate() {
        while (true) {
            try {
                OutputView.printMainScreen();
                String input = InputView.inputFunction();
                Validator.validateMainInput(input);

                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    //Route
    private String inputRouteFunctionAndValidate() {
        while (true) {
            try {
                OutputView.printRouteScreen();
                String input = InputView.inputFunction();
                Validator.validateRouteInput(input);

                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    //Route
    private void playRouteFunction(String input) {
        if (input.equals("1")) {
            String startStation = inputStartStationAndValidateStation();
            String endStation = inputEndStationAndValidateStation(startStation);
            List<Station> shortestDistance =subwayService.showShortestDistance(startStation, endStation);
            TimeLine resultTimeLine = subwayService.calculateDistanceAndTime(shortestDistance);
            OutputView.printShortestDistance(shortestDistance, resultTimeLine);
            return;
        }
        if (input.equals("2")) {
            String startStation = inputStartStationAndValidateStation();
            String endStation = inputEndStationAndValidateStation(startStation);
            List<Station> shortestDistance =subwayService.showShortestTime(startStation, endStation);
            TimeLine resultTimeLine = subwayService.calculateDistanceAndTime(shortestDistance);
            OutputView.printShortestDistance(shortestDistance, resultTimeLine);
        }
    }

    private String inputStartStationAndValidateStation() {
        while (true) {
            try {
                String input = InputView.inputStartStation();
                subwayService.validateContainsStation(input);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private String inputEndStationAndValidateStation(String startStationInput) {
        while (true) {
            try {
                String endStationInput = InputView.inputEndStation();
                subwayService.validateContainsStation(endStationInput);
                subwayService.validateDuplication(startStationInput, endStationInput);
                return endStationInput;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    // 반환 타입 정하기
    // 메서드명 input~ 으로 짓기
//    private 반환타입 메서드명() {
//        while (true) {
//            try {
//                // 서비스 메서드 호출
//
//                return *;
//
//            } catch (IllegalArgumentException e) {
//                OutputView.printErrorMessage(e);
//            }
//        }
//    }
}
