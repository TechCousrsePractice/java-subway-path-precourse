package subway.util;

import static subway.util.Constant.BACK_TO_MAIN_DISPLAY;
import static subway.util.Constant.DISTANCE_SEARCH;
import static subway.util.Constant.QUIT_PROGRAM;
import static subway.util.Constant.SEARCH_PATH;
import static subway.util.Constant.TIME_SEARCH;

import java.util.Arrays;
import java.util.List;
import subway.domain.PreRegistrationStation;

public class Validator {
    public static boolean isQuit(String flag) {
        return flag.equals(QUIT_PROGRAM);
    }

    public static boolean isBackToMain(String flag) {
        return flag.equals(BACK_TO_MAIN_DISPLAY);
    }

    public static boolean isDistance(String flag) {
        return flag.equals(DISTANCE_SEARCH);
    }

    public static boolean isTime(String flag) {
        return flag.equals(TIME_SEARCH);
    }

    public static String validateMainFlag(String flag) {
        if (flag.equals(SEARCH_PATH) || flag.equals(QUIT_PROGRAM)) {
            return flag;
        }
        throw new IllegalArgumentException();
    }

    public static String validateFindFlag(String flag) {
        if (flag.equals(DISTANCE_SEARCH) || flag.equals(TIME_SEARCH) || flag.equals(BACK_TO_MAIN_DISPLAY)) {
            return flag;
        }
        throw new IllegalArgumentException();
    }

    public static String validateStationName(String name) {
        List<String> stations = Arrays.stream(PreRegistrationStation.values())
                .map(PreRegistrationStation::getName)
                .toList();
        if (stations.contains(name)) {
            return name;
        }
        throw new IllegalArgumentException();
    }
}
