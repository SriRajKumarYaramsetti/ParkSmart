package Repositories;

import Models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {

    private Map<Long,Vehicle> vehicles=new TreeMap<>();
    private int previousId=0;
    public Optional<Vehicle> getVehicleByNumber(String number){
        for(Vehicle vehicle:vehicles.values()){
            if (vehicle.getNumber()==number){
                return Optional.of(vehicle);
            }

        }

        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){

        previousId+=1;

        vehicles.put((long)previousId,vehicle);

        return vehicle;

    }
}
