package Strategies.SpotAssignmentStrategy;

import Models.*;
import Repositories.ParkingLotRepository;


public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository=parkingLotRepository;
    }


    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType){
        ParkingLot parkingLot=parkingLotRepository.getParkingLotForGate(gate);
        for (ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            for (ParkingSpot parkingSpot:parkingFloor.getParkingSpots()){
                if(parkingSpot.getSupportedVehicleType().contains(vehicleType)&&
                        parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)){
                    return parkingSpot;
                }

            }


        }
        return null;
    }

}
