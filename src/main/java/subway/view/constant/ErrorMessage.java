package subway.view.constant;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    SUFFIX(" 다시 입력해 주세요."),
    INVALID_INPUT("잘못된 입력입니다."),
    ;


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void print() {
        System.out.println();
        System.out.println(PREFIX.getErrorMessage() + errorMessage + SUFFIX.getErrorMessage());
    }
}
