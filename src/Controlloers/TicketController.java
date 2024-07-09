package Controlloers;

import Models.Ticket;
import Services.TicketService;
import dtos.ResponseStatus;
import dtos.issueTicketRequestdto;
import dtos.issueTicketResponsedto;

public class TicketController {
    private TicketService ticketService;
    Ticket ticket;
    issueTicketResponsedto response=new issueTicketResponsedto();


    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public issueTicketResponsedto issueTicket(issueTicketRequestdto request)
    {
       try{ticketService.issueTicket(
                request.getVehicleType(),
                request.getVehicleNumber(),
                request.getVehicleOwnerName(),

                request.getGateId()
                    );}

       // Request Object,Service Object---->Controller will talk to the service
       // by passing the parameters from the client...It will get the parameters from the request object get methods------>
       // The service method will set the needed object and sets the properties of the object based on
       //the information sent by the client.If the properties of the needed object i.e.TICKET are not primitive properties
       // then it will check the database if it is not found in the database it will store in the database otherwise it will throw  an error
       //whatever the needed object that is thrown by the service method will be used and set as the value for the property of the response object

       catch (Exception e){
           response.setResponseStatus(ResponseStatus.FAILURE);
           return response;
       }



        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);

        return response;
    }
}
