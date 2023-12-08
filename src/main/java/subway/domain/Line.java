package subway.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final String name;
    private final List<SubwayLine> stations;

    public Line(String name, List<SubwayLine> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<SubwayLine> stations() {
        return Collections.unmodifiableList(stations);
    }
}
