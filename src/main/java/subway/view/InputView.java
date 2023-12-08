package subway.view;

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

import java.util.Scanner;
import subway.view.validation.ViewValidation;

public class InputView {
    private final String MENU_FORMAT = "%s%s%s%s";
    private final String STANDARD_FORMAT = "%s%s%s%s%s";
    private final Scanner scanner;
    private final ViewValidation validation;

    public InputView(Scanner scanner) {
        validation = new ViewValidation();
        this.scanner = scanner;
    }
    public int choiceMenu() {
        System.out.printf(MENU_FORMAT,
                MAIN_MENU_INIT, ROUTE_CHECK, QUIT, CHOICE_MENU);
        return validation.isMenuNumber(scanner.nextLine());
    }

    public int choiceStandard() {
        System.out.printf(STANDARD_FORMAT,
                STANDARD, MIN_DISTANT, MIN_TIME, RETURN_MENU, CHOICE_FUNCTION);
        return validation.isFunctionNumber(scanner.nextLine());
    }

    public String enterStartStation() {
        System.out.println(START_STATION);
        String station = scanner.nextLine();
        validation.isStation(station);
        return station;
    }

    public String enterEndStation() {
        System.out.println(END_STATION);
        String station = scanner.nextLine();
        validation.isStation(station);
        return station;
    }
}
