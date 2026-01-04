package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    //초기 저장
    public static void init() {
        stations.add(Station.from("교대역"));
        stations.add(Station.from("강남역"));
        stations.add(Station.from("역삼역"));
        stations.add(Station.from("남부터미널역"));
        stations.add(Station.from("양재역"));
        stations.add(Station.from("양재시민의숲역"));
        stations.add(Station.from("매봉역"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }


    public static boolean contains(String stationName) {

        if (stations.contains(getStationByName(stationName))) {
            return true;
        }
        return false;
    }

    public static Station getStationByName(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }
}
