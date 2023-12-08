package subway.controller;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Calculator;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;

public class MinimumTime {
    private final OutputView outputView;
    private final WeightedMultigraph<String, DefaultWeightedEdge> graph;
    public MinimumTime(OutputView outputView) {
        this.outputView = outputView;
        graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }
    public void run(Station startStation, Station endStation) {
        convertGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        GraphPath<String, DefaultWeightedEdge> shortestPath = dijkstraShortestPath.getPath(startStation.getName(),
                endStation.getName());

        outputView.initInquiry();
        outputView.showTimeAndDistant(calculateTime(shortestPath), calculateDistant(shortestPath.getVertexList()));
        outputView.showStations(shortestPath.getVertexList());
    }
    private void convertGraph() {
        addNode();
        addEdge();
    }

    private void addNode() {
        StationRepository.stations().stream()
                .map(Station::getName)
                .forEach(graph::addVertex);
    }

    private void addEdge() {
        LineRepository.lines().forEach(line ->
                line.stations().forEach(station -> {
                    String upStationName = station.upStation().getName();
                    String downStationName = station.downStation().getName();
                    graph.setEdgeWeight(
                            graph.addEdge(upStationName, downStationName),
                            station.getTime()
                    );
                })
        );
    }

    private int calculateDistant(List<String> shortestPath) {
        Calculator calculator = new Calculator();
        return calculator.calculateDistant(shortestPath);
    }
    private int calculateTime(GraphPath<String, DefaultWeightedEdge> shortestPath) {
        return shortestPath.getEdgeList().stream()
                .mapToInt(edge -> (int) shortestPath.getGraph().getEdgeWeight(edge))
                .sum();
    }
}
