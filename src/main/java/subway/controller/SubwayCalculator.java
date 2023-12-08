package subway.controller;

import static subway.constants.global.PREFIX;
import static subway.constants.global.SAME_START_END;

import subway.domain.InitLine;
import subway.domain.InitStation;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayCalculator {
    private static SubwayCalculator instance;
    private InputView inputView;
    private OutputView outputView;

    private SubwayCalculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        new InitStation().initStation();
        new InitLine().initLine();
    }

    public static SubwayCalculator getInstance(InputView inputView, OutputView outputView) {
        if (instance == null) {
            instance = new SubwayCalculator(inputView, outputView);
        }
        return instance;
    }

    public void run() {
        while (true) {
            try {
                if (inputView.choiceMenu() == 0) {
                    return;
                }
                switchController(inputView.choiceStandard());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void switchController(int standard) {
        if(standard == 0){
            return;
        }
        Station startStation = StationRepository.getStation(inputView.enterStartStation());
        Station endStation = StationRepository.getStation(inputView.enterEndStation());
        validateStation(startStation, endStation);
        if(standard == 1){
            minimumDistant(startStation, endStation);
        }
        if(standard == 2){
            minimumTime(startStation, endStation);
        }
    }

    private void validateStation(Station startStation, Station endStation) {
        if(startStation.equals(endStation)){
            throw new IllegalArgumentException(PREFIX + SAME_START_END);
        }
    }

    private void minimumDistant(Station startStation, Station endStation) {
        MinimumDistant minimumDistant = new MinimumDistant(outputView);
        minimumDistant.run(startStation, endStation);
    }

    private void minimumTime(Station startStation, Station endStation) {
        MinimumTime minimumTime = new MinimumTime(outputView);
        minimumTime.run(startStation, endStation);
    }
}
