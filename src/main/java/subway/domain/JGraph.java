package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class JGraph {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void setDistanceGraph() {

        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station.getName());
        }

        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<Station> section = line.getSection();
            List<TimeLine> timeLines = line.getTimeLine();
            for (int i = 0; i < section.size() - 1; i++) {
                distanceGraph.setEdgeWeight(distanceGraph.addEdge(section.get(i).getName(), section.get(i + 1).getName()), timeLines.get(i).getDistance());
            }
        }
    }

    public static void setTimeGraph() {
        for (Station station : StationRepository.stations()) {
            timeGraph.addVertex(station.getName());
        }

        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<Station> section = line.getSection();
            List<TimeLine> timeLines = line.getTimeLine();
            for (int i = 0; i < section.size() - 1; i++) {
                timeGraph.setEdgeWeight(timeGraph.addEdge(section.get(i).getName(), section.get(i + 1).getName()), timeLines.get(i).getTime());
            }
        }
    }

    public static List<Station> calculateShortestDistance(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();

        List<Station> shortestPathStation = new ArrayList<>();
        for (String s : shortestPath) {
            shortestPathStation.add(StationRepository.getStationByName(s));
        }
        return shortestPathStation;
    }

    public static List<Station> calculateShortestTime(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();

        List<Station> shortestPathStation = new ArrayList<>();
        for (String s : shortestPath) {
            shortestPathStation.add(StationRepository.getStationByName(s));
        }
        return shortestPathStation;
    }
}
