package subway.domain;

public class SubwayLine {
    private final Station nowStation;
    private final Station nextStation;
    private final int distant;
    private final int time;

    public SubwayLine(Station nowStation, Station nextStation, int distant, int time) {
        this.nowStation = nowStation;
        this.nextStation = nextStation;
        this.distant = distant;
        this.time = time;
    }

    public Station upStation() {
        return nowStation;
    }
    public Station downStation() {
        return nextStation;
    }
    public int getTime() {
        return time;
    }
    public int getDistant() {
        return distant;
    }
}
