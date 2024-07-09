package Services;

import Exceptions.GateNotFoundException;
import Models.*;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import Repositories.GateRepository;
import Strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;
import Strategies.SpotAssignmentStrategy.SpotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gaterepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketService(
            GateRepository gaterepository,
            VehicleRepository vehicleRepository,

            ParkingLotRepository parkingLotRepository,

            TicketRepository ticketRepository
    ){
        this.gaterepository=gaterepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;
        this.ticketRepository=ticketRepository;

    }

    public Ticket issueTicket( VehicleType vehicleType,
    String vehicleNumber,String vehicleOwnerName,Long gateId) throws GateNotFoundException {

        //create a ticket obj
        //Assign a spot
        //Return ticket

        Ticket ticket=new Ticket();

        //Setting all the parameters of the ticket
        ticket.setEntryTime(new Date());

        //Assigning the gate number to the vehicle
        Optional<Gate> gateOptional =gaterepository.findGateById(gateId);


        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }

        Gate gate=gateOptional.get();




        //Stamping the vehicle details on the ticket

        //Check Vehicle in the database

        //1.Yes
        //---GetVehicle from the  database
        //--Put in ticket object

        //2.No
        //--Create New vehicle
        //---save it in database
        //--Put in ticket object


        Vehicle savedVehicle;

        Optional<Vehicle> vehicleOptional=vehicleRepository
                .getVehicleByNumber(vehicleNumber);

        if(vehicleOptional.isEmpty()){
            Vehicle vehicle=new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);

            savedVehicle=vehicleRepository.saveVehicle(vehicle);

        }else{
            savedVehicle=vehicleOptional.get();

        }

        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());




        //FACTORY DESIGN PATTERN : For getting the child class based on a specific
        // condition we do use this pattern like as follows we will create interface
        // we will implement the child classes for that interface and the child classes are the
        //required classes to get the required class  we will create a factory in which we create a method which will take that
        //condition and we will write if else condition to get the required child class based on the condition




        SpotAssignmentStrategyType assignmentStrategyType=parkingLotRepository.getParkingLotForGate(gate)
                        .getSpotAssignmentStrategyType();



        SpotAssignmentStrategy spotAssignmentStrategy= SpotAssignmentStrategyFactory.getSpotForType(assignmentStrategyType);

        ticket.setAssignedSpot(
                spotAssignmentStrategy.getSpot(gate,vehicleType)
        );

        ticket.setNumber("TICKET"+ticket.getId());
        return ticketRepository.saveTicket(ticket);


    }

}
