package subway;

import java.util.Scanner;
import subway.controller.SubwayCalculator;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayCalculator subwayCalculator = SubwayCalculator.getInstance(new InputView(scanner), new OutputView());
        subwayCalculator.run();
    }
}
