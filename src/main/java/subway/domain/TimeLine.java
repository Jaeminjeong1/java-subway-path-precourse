package subway.domain;

public class TimeLine {

    private int distance;
    private int time;

    private TimeLine(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public static TimeLine of(int distance, int time) {
        return new TimeLine(distance, time);
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
