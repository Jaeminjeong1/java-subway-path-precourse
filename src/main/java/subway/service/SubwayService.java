package subway.service;

import subway.domain.*;

import java.util.List;

import static subway.util.ErrorMessage.DUPLICATE_STATION_ERROR;
import static subway.util.ErrorMessage.NOT_CONTAINS_STATION_ERROR;

public class SubwayService {

    public void init() {
        StationRepository.init();
        LineRepository.init();
        JGraph.setDistanceGraph();
        JGraph.setTimeGraph();
    }

    public List<Station> showShortestDistance(String startStation, String endStation) {
        Station startStationObj = StationRepository.getStationByName(startStation);
        Station endStationObj = StationRepository.getStationByName(endStation);

        if (startStationObj == null || endStationObj == null) {
            throw new IllegalArgumentException(NOT_CONTAINS_STATION_ERROR.getMessage());
        }

        return JGraph.calculateShortestDistance(startStationObj, endStationObj);
    }

    public List<Station> showShortestTime(String startStation, String endStation) {
        Station startStationObj = StationRepository.getStationByName(startStation);
        Station endStationObj = StationRepository.getStationByName(endStation);

        if (startStationObj == null || endStationObj == null) {
            throw new IllegalArgumentException(NOT_CONTAINS_STATION_ERROR.getMessage());
        }

        return JGraph.calculateShortestTime(startStationObj, endStationObj);
    }

    public TimeLine calculateDistanceAndTime(List<Station> shortestDistances) {
        int totalDistance = 0;
        int totalTime = 0;

        for (int i = 0; i < shortestDistances.size() - 1; i++) {
            Station start = shortestDistances.get(i);
            Station next = shortestDistances.get(i + 1);

            TimeLine tl = calculateTimeLine(start, next);
            totalDistance += tl.getDistance();
            totalTime += tl.getTime();
        }

        return TimeLine.of(totalDistance, totalTime);
    }

    private TimeLine calculateTimeLine(Station start, Station next) {
        TimeLine resultTimeLine = TimeLine.of(0, 0);
        for (Line line : LineRepository.lines()) {
            List<Station> section = line.getSection();
            List<TimeLine> timeLines = line.getTimeLine();

            if (section.contains(start) && section.contains(next)) {
                int startIndex = section.indexOf(start);
                int nextIndex = section.indexOf(next);
                TimeLine tempTimeLine = timeLines.get(Math.min(startIndex, nextIndex));
                resultTimeLine.addTimeLine(tempTimeLine.getDistance(), tempTimeLine.getTime());
            }
        }

        return resultTimeLine;
    }

    public void validateContainsStation(String inputStationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(inputStationName)) {
                return;
            }
        }
        throw new IllegalArgumentException(NOT_CONTAINS_STATION_ERROR.getMessage());
    }

    public void validateDuplication(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(DUPLICATE_STATION_ERROR.getMessage());
        }
    }


}
