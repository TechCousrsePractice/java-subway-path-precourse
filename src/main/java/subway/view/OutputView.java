package subway.view;

import static subway.view.constants.ViewConstants.INQUIRY_RESULT;
import static subway.view.constants.ViewConstants.RESULT_DISTANT;
import static subway.view.constants.ViewConstants.RESULT_STATION;
import static subway.view.constants.ViewConstants.RESULT_TIME;
import static subway.view.constants.ViewConstants.SEPARATOR;

import java.util.List;

public class OutputView {
    public void initInquiry() {
        System.out.println(INQUIRY_RESULT);
        System.out.println(SEPARATOR);
    }
    public void showTimeAndDistant(int time, int distant) {
        System.out.printf(RESULT_DISTANT, distant);
        System.out.printf(RESULT_TIME, time);
        System.out.println(SEPARATOR);
    }

    public void showStations(List<String> stations) {
        stations.forEach(station -> System.out.printf(RESULT_STATION, station));
    }
}
