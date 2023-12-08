package subway.view.validation;

import static java.lang.Integer.parseInt;

import java.util.function.Supplier;
import subway.view.constants.ErrorMessage;

public class ViewValidation {
    public static <T> T enterString(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER.getMessage());
        }
    }
    public int isMenuNumber(String enterMenu) {
        return enterString(() -> {
            if(enterMenu.equals("Q")){
                return 0;
            }
            int menuNumber = parseInt(enterMenu);
            isEqualMenu(menuNumber);
            return parseInt(enterMenu);
        });
    }

    public int isFunctionNumber(String enterFunction) {
        return enterString(() -> {
            if(enterFunction.equals("B")){
                return 0;
            }
            int functionNumber = parseInt(enterFunction);
            isEqualFunction(functionNumber);
            return functionNumber;
        });
    }

    public void isStation(String enterStation) {
        String targetEnding = "역";
        if (!enterStation.endsWith(targetEnding)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_STATION_FORMAT.getMessage());
        }
    }

    private void isEqualMenu(int menuNumber) {
        if(menuNumber != 1){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_MENU_FORMAT.getMessage());
        }
    }

    private void isEqualFunction(int functionNumber) {
        if(functionNumber != 1 && functionNumber != 2){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_STANDARD_FORMAT.getMessage());
        }
    }
}
