package subway.domain;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwayRouteByDistance {
    private final static WeightedMultigraph<String, DefaultWeightedEdge> route
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public SubwayRouteByDistance() {
    }

    public SubwayRouteByDistance(List<Station> stations) {
        stations.forEach(i -> route.addVertex(i.getName()));
    }

    public void add(String station1, String station2, int kilometer) {
        route.setEdgeWeight(route.addEdge(station1, station2), kilometer);
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getGraph() {
        return route;
    }
}
