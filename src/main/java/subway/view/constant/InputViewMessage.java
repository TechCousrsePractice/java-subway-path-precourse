package subway.view.constant;

public enum InputViewMessage implements ViewMessage {
    CHOOSE_FEATURE("## 원하는 기능을 선택하세요."),
    SELECT_STATION("## %s역을 입력하세요.");

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public void renderAndPrint(String s) {
        System.out.printf(message + System.lineSeparator(), s);
    }

    @Override
    public void print() {
        System.out.print(message);
    }

    @Override
    public void printLine() {
        System.out.println(message);
    }
}
