package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> section;
    private List<TimeLine> timeLine;

    private Line(String name, List<Station> section, List<TimeLine> timeLine) {
        this.name = name;
        this.section = section;
        this.timeLine = timeLine;
    }

    public static Line of (String name, List<Station> section, List<TimeLine> timeLine) {
        return new Line(name, section, timeLine);
    }

    public String getName() {
        return name;
    }

    public List<Station> getSection() {
        return List.copyOf(section);
    }
    // 추가 기능 구현
}
