package subway.view.constants;

import static subway.constants.global.PREFIX;

import org.mockito.internal.matchers.GreaterThan;

public enum ErrorMessage {
    IS_NOT_FORMAT("메뉴에 맞게 입력해주세요");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + this.message;
    }
}
