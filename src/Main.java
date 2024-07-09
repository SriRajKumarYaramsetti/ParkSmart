import Controlloers.TicketController;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import Services.TicketService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        GateRepository gateRepository=new GateRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();     //The creation of the
                                                                                  // objects are in the topological order
        TicketRepository ticketRepository=new TicketRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();
        TicketService ticketService=new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);
        TicketController ticketController=new TicketController(
                ticketService);



    }
}