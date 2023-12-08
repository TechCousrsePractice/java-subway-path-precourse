package subway.view;

import java.util.List;
import subway.view.constant.OutputViewMessage;

public class OutputView {
    public void showMain() {
        System.out.println();
        OutputViewMessage.MAIN_DISPLAY.printLine();
        OutputViewMessage.SEARCH_PATH.printLine();
        OutputViewMessage.QUIT.printLine();
    }

    public void chooseBase() {
        System.out.println();
        OutputViewMessage.PATH_BASED.printLine();
        OutputViewMessage.SHORTEST_DISTANCE.printLine();
        OutputViewMessage.SHORTEST_TIME.printLine();
        OutputViewMessage.BACK_TO_MAIN.printLine();
    }

    public void printResult(List<String> shortestPath) {
        OutputViewMessage.RESULT_DELIMITER.printLine();
        shortestPath.forEach(OutputViewMessage.RESULT_STATION::renderAndPrint);
    }

    public void printTotal(int totalDistance, int totalTime) {
        System.out.println();
        OutputViewMessage.SEARCH_RESULT.printLine();
        OutputViewMessage.RESULT_DELIMITER.printLine();
        OutputViewMessage.RESULT_DISTANCE.renderAndPrint(totalDistance);
        OutputViewMessage.RESULT_TIME.renderAndPrint(totalTime);
    }
}
