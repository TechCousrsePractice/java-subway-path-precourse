package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class InitLine {
    public void initLine() {
        LineRepository.addLine(new Line("2호선", initTwoLine()));
        LineRepository.addLine(new Line("3호선", initThreeLine()));
        LineRepository.addLine(new Line("신분당선", initShinbundangLine()));
    }

    private List<SubwayLine> initTwoLine() {
        List<SubwayLine> stations = new ArrayList<>();
        stations.add(new SubwayLine(StationRepository.getStation("교대역"),
                StationRepository.getStation("강남역"), 2, 3));
        stations.add(new SubwayLine(StationRepository.getStation("강남역"),
                StationRepository.getStation("역삼역"), 2, 3));
        return stations;
    }

    private List<SubwayLine> initThreeLine() {
        List<SubwayLine> stations = new ArrayList<>();
        stations.add(new SubwayLine(StationRepository.getStation("교대역"),
                StationRepository.getStation("남부터미널역"), 3, 2));
        stations.add(new SubwayLine(StationRepository.getStation("남부터미널역"),
                StationRepository.getStation("양재역"), 6, 5));
        stations.add(new SubwayLine(StationRepository.getStation("양재역"),
                StationRepository.getStation("매봉역"), 1, 1));
        return stations;
    }

    private List<SubwayLine> initShinbundangLine() {
        List<SubwayLine> stations = new ArrayList<>();
        stations.add(new SubwayLine(StationRepository.getStation("강남역"),
                StationRepository.getStation("양재역"), 2, 8));
        stations.add(new SubwayLine(StationRepository.getStation("양재역"),
                StationRepository.getStation("양재시민의숲역"), 10, 3));
        return stations;
    }
}
