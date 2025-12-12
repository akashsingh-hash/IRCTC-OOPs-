

public class Ticket{
    
    private static int counter = 1001;

    private final int ticketId;
    
    // passenger details should be there 
    private User user;
    //  Train details 
    private Train train;

    private int seatBooked;

    //  constructor 
    public Ticket(User user,Train train,int seatBooked){
        this.ticketId = counter++;
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }

    //  generate getter and setter 
    void setUser(User user){
        this.user = user;
    }

    User getUser(){
        return user;
    }

    void setTrain(Train train){
        this.train = train;
    }

    Train getTrain(){
        return train;
    }    

    int getTicketId(){
        return ticketId;
    }

    int getSeatBooked(){
        return seatBooked;
    }



    //  now toString method 
    @Override

    public String toString(){
        return "Ticket ID: " + ticketId + " |Train: " + train.getName() + " | Route:  " + 
        train.getSource() + " -> " + train.getDestination() + " | Seats Available : " + train.getAvailableSeats() + 
        " | Booked By : " + user.getFullName();
    }
}
