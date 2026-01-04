package subway.view;

import subway.domain.Station;
import subway.domain.TimeLine;

import java.util.List;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";
    private static final String ROUTE_SCREEN = "\n## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String CHECK_RESULT = "\n## 조회 결과";
    private static final String DELIMITER = "---";
    private static final String TOTAL_DISTANCE = "총 거리: %dkm\n";
    private static final String TOTAL_TIME = "총 소요 시간: %d분\n";

    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
    }

    public static void printRouteScreen() {
        System.out.println(ROUTE_SCREEN);
    }

    public static void printShortestDistance(List<Station> shortestDistances, TimeLine timeLine) {
        System.out.println(CHECK_RESULT);
        System.out.println(INFO_PREFIX + DELIMITER);
        System.out.printf(INFO_PREFIX + TOTAL_DISTANCE, timeLine.getDistance());
        System.out.printf(INFO_PREFIX + TOTAL_TIME, timeLine.getTime());
        System.out.println(INFO_PREFIX + DELIMITER);
        for (Station station : shortestDistances) {
            System.out.println(INFO_PREFIX + station.getName());
        }
        System.out.println();
    }

    // 에러메세지 출력
    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
