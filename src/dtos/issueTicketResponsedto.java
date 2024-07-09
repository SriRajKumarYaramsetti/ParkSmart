package dtos;

import Models.Ticket;
import Models.VehicleType;

public class issueTicketResponsedto {
    private Ticket ticket;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }
}
