package subway.controller;

import static subway.util.Constant.END;
import static subway.util.Constant.START;

import java.util.List;
import java.util.function.Supplier;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.SubwayRouteByDistance;
import subway.domain.SubwayRouteByTime;
import subway.util.Validator;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constant.ErrorMessage;

public class SubwayMap {
    private final SubwayRouteByDistance srbd = new SubwayRouteByDistance();
    private final SubwayRouteByTime srbt = new SubwayRouteByTime();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        // if user input "Q", program exit.
        while (!Validator.isQuit(showMainDisplay())) {
            // if user input "B", return main display.
            String flag = showSearchPathDisplay();
            if (Validator.isBackToMain(flag)) {
                continue;
            }
            showResult(flag);
        }
    }

    private String showMainDisplay() {
        outputView.showMain();
        return readUserInput(() ->
                Validator.validateMainFlag(inputView.chooseFeature())
        );
    }

    private String showSearchPathDisplay() {
        outputView.chooseBase();
        return readUserInput(() ->
                Validator.validateFindFlag(inputView.chooseFeature()));
    }

    private void showResult(String flag) {
        List<String> shortestPath = calculatePath(flag);
        int totalDistance = getTotalDistance(shortestPath);
        int totalTime = getTotalTime(shortestPath);
        outputView.printTotal(totalDistance, totalTime);
        outputView.printResult(shortestPath);
    }

    private List<String> calculatePath(String flag) {
        DijkstraShortestPath shortestPathByDistance = new DijkstraShortestPath<>(srbd.getGraph());
        DijkstraShortestPath shortestPathByTime = new DijkstraShortestPath<>(srbt.getGraph());
        String startStation = readStartStation();
        String endStation = readEndStation();

        if (Validator.isDistance(flag)) {
            return shortestPathByDistance.getPath(startStation, endStation).getVertexList();
        }
        if (Validator.isTime(flag)) {
            return shortestPathByTime.getPath(startStation, endStation).getVertexList();
        }
        throw new IllegalArgumentException();
    }

    private int getTotalDistance(List<String> shrotestPath) {
        return 1;
    }

    private int getTotalTime(List<String> shrotestPath) {
        return 1;
    }

    private String readStartStation() {
        return readUserInput(() ->
                Validator.validateStationName(inputView.readStation(START)));
    }

    private String readEndStation() {
        return readUserInput(() ->
                Validator.validateStationName(inputView.readStation(END)));
    }

    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ErrorMessage.INVALID_INPUT.print();
            }
        }
    }
}