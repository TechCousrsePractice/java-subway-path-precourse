package subway.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    public int calculateTime(List<String> shortestPath) {
        return IntStream.range(0, shortestPath.size() - 1)
                .map(index -> {
                    String currentStation = shortestPath.get(index);
                    String nextStation = shortestPath.get(index + 1);

                    return LineRepository.lines().stream()
                            .flatMap(line -> line.stations().stream())
                            .filter(station ->
                                    station.upStation().getName().equals(currentStation) &&
                                            station.downStation().getName().equals(nextStation))
                            .mapToInt(SubwayLine::getTime)
                            .findFirst()
                            .orElse(0);
                })
                .sum();
    }

    public int calculateDistant(List<String> shortestPath) {
        return IntStream.range(0, shortestPath.size() - 1)
                .map(index -> {
                    String currentStation = shortestPath.get(index);
                    String nextStation = shortestPath.get(index + 1);

                    return LineRepository.lines().stream()
                            .flatMap(line -> line.stations().stream())
                            .filter(station ->
                                    station.upStation().getName().equals(currentStation) &&
                                            station.downStation().getName().equals(nextStation))
                            .mapToInt(SubwayLine::getDistant)
                            .findFirst()
                            .orElse(0);
                })
                .sum();
    }
}
