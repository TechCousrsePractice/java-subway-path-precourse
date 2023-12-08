package subway;

import camp.nextstep.edu.missionutils.Console;
import subway.controller.RouteRegistrar;
import subway.controller.SubwayMap;

public class Application {
    public static void main(String[] args) {
        RouteRegistrar registrar = new RouteRegistrar();
        SubwayMap subwayMap = new SubwayMap();
        registrar.registerRoute();
        subwayMap.start();
        Console.close();
    }
}
