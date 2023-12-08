package subway.view.constant;

public enum OutputViewMessage implements ViewMessage {
    PREFIX("[INFO] "),
    MAIN_DISPLAY("## 메인 화면"),
    SEARCH_PATH("1. 경로 조회"),
    QUIT("Q. 종료"),
    PATH_BASED("## 경로 기준"),
    SHORTEST_DISTANCE("1. 최단 거리"),
    SHORTEST_TIME("2. 최소 시간"),
    BACK_TO_MAIN("B. 돌아가기"),
    SEARCH_RESULT("## 조회 결과"),
    RESULT_DELIMITER(PREFIX.message + "---"),
    RESULT_DISTANCE(PREFIX.message + "총 거리: %dkm"),
    RESULT_TIME(PREFIX.message + "총 소요 시간: %d분"),
    RESULT_STATION(PREFIX.message + "%s"),
    ;

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public void renderAndPrint(int d) {
        System.out.printf(message + System.lineSeparator(), d);
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
