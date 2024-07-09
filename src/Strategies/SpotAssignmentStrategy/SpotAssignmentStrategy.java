package Strategies.SpotAssignmentStrategy;

import Models.Gate;
import Models.ParkingSpot;
import Models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot getSpot(Gate gate, VehicleType vehicleType);


}
