package subway.view.constants;

import static subway.constants.global.PREFIX;

public enum ErrorMessage {
    IS_NOT_INTEGER("숫자가 아닙니다."),
    IS_NOT_MENU_FORMAT("1 혹은 Q만 입력하실 수 있습니다."),
    IS_NOT_STANDARD_FORMAT("1,2 그리고 B만 입력하실 수 있습니다."),
    IS_NOT_STATION_FORMAT("##역 형태로만 입력하실 수 있습니다.");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + this.message;
    }
}
