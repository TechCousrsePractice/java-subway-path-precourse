package subway.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static subway.view.constants.ViewConstants.CHOICE_FUNCTION;
import static subway.view.constants.ViewConstants.CHOICE_MENU;
import static subway.view.constants.ViewConstants.END_STATION;
import static subway.view.constants.ViewConstants.MAIN_MENU_INIT;
import static subway.view.constants.ViewConstants.MIN_DISTANT;
import static subway.view.constants.ViewConstants.MIN_TIME;
import static subway.view.constants.ViewConstants.QUIT;
import static subway.view.constants.ViewConstants.RETURN_MENU;
import static subway.view.constants.ViewConstants.ROUTE_CHECK;
import static subway.view.constants.ViewConstants.STANDARD;
import static subway.view.constants.ViewConstants.START_STATION;

import subway.view.validation.ViewValidation;

public class InputView {
    private final String MENU_FORMAT = "%s %s %s %s";
    private final String STANDARD_FORMAT = "%s %s %s %s %s";
    private ViewValidation validation;

    public InputView() {
        validation = new ViewValidation();
    }
    public int choiceMenu() {
        System.out.printf(MENU_FORMAT,
                MAIN_MENU_INIT, ROUTE_CHECK, QUIT, CHOICE_MENU);
        return validation.isMenuNumber(readLine());
    }

    public int choiceStandard() {
        System.out.printf(STANDARD_FORMAT,
                STANDARD, MIN_DISTANT, MIN_TIME, RETURN_MENU, CHOICE_FUNCTION);
        return validation.isFunctionNumber(readLine());
    }

    public String enterStartStation() {
        System.out.println(START_STATION);
        String station = readLine();
        validation.isStation(station);
        return station;
    }

    public String enterEndStation() {
        System.out.println(END_STATION);
        String station = readLine();
        validation.isStation(station);
        return station;
    }
}
