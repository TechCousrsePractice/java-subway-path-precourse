package subway.domain;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class Calculator {
    public int calculateTime(List<String> shortestPath) {
        return calculate(shortestPath, SubwayLine::getTime);
    }

    public int calculateDistant(List<String> shortestPath) {
        return calculate(shortestPath, SubwayLine::getDistant);
    }

    private int calculate(List<String> shortestPath, ToIntFunction<SubwayLine> function) {
        return IntStream.range(0, shortestPath.size() - 1)
                .map(index -> {
                    String currentStation = shortestPath.get(index);
                    String nextStation = shortestPath.get(index + 1);

                    return LineRepository.lines().stream()
                            .flatMap(line -> line.stations().stream())
                            .filter(station ->
                                    station.upStation().getName().equals(currentStation) &&
                                            station.downStation().getName().equals(nextStation))
                            .mapToInt(function)
                            .findFirst()
                            .orElse(0);
                })
                .sum();
    }
}
