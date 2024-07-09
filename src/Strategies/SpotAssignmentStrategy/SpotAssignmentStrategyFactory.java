package Strategies.SpotAssignmentStrategy;

import Models.SpotAssignmentStrategyType;
import Repositories.ParkingLotRepository;

public class SpotAssignmentStrategyFactory {

    private static ParkingLotRepository parkingLotRepository;
    public static SpotAssignmentStrategy getSpotForType(SpotAssignmentStrategyType type){
        return new RandomSpotAssignmentStrategy(parkingLotRepository);
    }
}
