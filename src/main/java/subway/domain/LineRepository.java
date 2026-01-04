package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static void init() {
        initLineTwo();
        initLineThree();
        initLineBundang();
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    private static void initLineTwo() {
        List<Station> section = new ArrayList<>();
        section.add(Station.from("교대역"));
        section.add(Station.from("강남역"));
        section.add(Station.from("역삼역"));

        List<TimeLine> timeLine = new ArrayList<>();
        timeLine.add(TimeLine.of(2, 3));
        timeLine.add(TimeLine.of(2, 3));

        lines.add(Line.of("2호선", section, timeLine));
    }

    private static void initLineThree() {
        List<Station> section = new ArrayList<>();
        section.add(Station.from("교대역"));
        section.add(Station.from("남부터미널역"));
        section.add(Station.from("양재역"));
        section.add(Station.from("매봉역"));

        List<TimeLine> timeLine = new ArrayList<>();
        timeLine.add(TimeLine.of(3, 2));
        timeLine.add(TimeLine.of(6, 5));
        timeLine.add(TimeLine.of(1, 1));

        lines.add(Line.of("3호선", section, timeLine));
    }

    private static void initLineBundang() {
        List<Station> section = new ArrayList<>();
        section.add(Station.from("강남역"));
        section.add(Station.from("양재역"));
        section.add(Station.from("양재시민의숲역"));

        List<TimeLine> timeLine = new ArrayList<>();
        timeLine.add(TimeLine.of(2, 8));
        timeLine.add(TimeLine.of(10, 3));

        lines.add(Line.of("신분당선", section, timeLine));
    }
}
