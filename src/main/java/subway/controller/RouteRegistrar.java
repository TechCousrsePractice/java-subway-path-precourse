package subway.controller;

import java.util.Arrays;
import subway.domain.PreRegistrationStation;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayRouteByDistance;
import subway.domain.SubwayRouteByTime;

public class RouteRegistrar {
    private SubwayRouteByDistance srbd;
    private SubwayRouteByTime srbt;

    public void registerRoute() {
        initialize();
    }

    private void initialize() {
        initializeStation();
        srbd = new SubwayRouteByDistance(StationRepository.stations());
        srbt = new SubwayRouteByTime(StationRepository.stations());
        initializeLineTwo();
        initializeLineThree();
        initializeShinBunDang();
    }

    private void initializeStation() {
        Arrays.stream(PreRegistrationStation.values())
                .map(i -> new Station(i.getName()))
                .forEach(StationRepository::addStation);
    }

    private void initializeLineTwo() {
        srbd.add(PreRegistrationStation.GYODAE.getName(), PreRegistrationStation.GANGNAM.getName(), 2);
        srbd.add(PreRegistrationStation.GANGNAM.getName(), PreRegistrationStation.YEOKSAM.getName(), 2);

        srbt.add(PreRegistrationStation.GYODAE.getName(), PreRegistrationStation.GANGNAM.getName(), 3);
        srbt.add(PreRegistrationStation.GANGNAM.getName(), PreRegistrationStation.YEOKSAM.getName(), 3);
    }

    private void initializeLineThree() {
        srbd.add(PreRegistrationStation.GYODAE.getName(), PreRegistrationStation.NAMBU_BUS_TERMINAL.getName(), 3);
        srbd.add(PreRegistrationStation.NAMBU_BUS_TERMINAL.getName(), PreRegistrationStation.YANGJAE.getName(), 6);
        srbd.add(PreRegistrationStation.YANGJAE.getName(), PreRegistrationStation.MAEBONG.getName(), 1);

        srbt.add(PreRegistrationStation.GYODAE.getName(), PreRegistrationStation.NAMBU_BUS_TERMINAL.getName(), 2);
        srbt.add(PreRegistrationStation.NAMBU_BUS_TERMINAL.getName(), PreRegistrationStation.YANGJAE.getName(), 5);
        srbt.add(PreRegistrationStation.YANGJAE.getName(), PreRegistrationStation.MAEBONG.getName(), 1);
    }

    private void initializeShinBunDang() {
        srbd.add(PreRegistrationStation.GANGNAM.getName(), PreRegistrationStation.YANGJAE.getName(), 2);
        srbd.add(PreRegistrationStation.YANGJAE.getName(), PreRegistrationStation.YANGJAE_CITIZEN_FOREST.getName(), 10);

        srbt.add(PreRegistrationStation.GANGNAM.getName(), PreRegistrationStation.YANGJAE.getName(), 8);
        srbt.add(PreRegistrationStation.YANGJAE.getName(), PreRegistrationStation.YANGJAE_CITIZEN_FOREST.getName(), 3);
    }
}
