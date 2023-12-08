package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.util.Parser;
import subway.view.constant.InputViewMessage;

public class InputView {
    public String chooseFeature() {
        System.out.println();
        InputViewMessage.CHOOSE_FEATURE.printLine();
        return Parser.parseInput(readLine());
    }

    public String readStation(String stationType) {
        System.out.println();
        InputViewMessage.SELECT_STATION.renderAndPrint(stationType);
        return Parser.parseInput(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}
