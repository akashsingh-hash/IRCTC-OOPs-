import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class BookingService {
    //  all the information should there 
    //  list of trains
    private List<Train> trainList = new ArrayList<>();
    
    //  Ticket list 
    private List<Ticket> ticketList = new ArrayList<>();

    public BookingService(){
        trainList.add(new Train(101,"Rajdhani Express","NDLS","Mumbai Central",100));
        trainList.add(new Train(102,"Shatabdi Express","NDLS","Siwan JN",80));
        trainList.add(new Train(103,"Duronto Express","NDLS","Gorakhput",93));
        trainList.add(new Train(104,"VandeBharat Expree","NDLS","Mumbai",103));
        trainList.add(new Train(105,"Tejas Expree","NDLS","Kanpur",78));
    }

    //  list of train for a source or destination -> search result 
    public List<Train> searchTrain(String source,String destination){
        List<Train> res = new ArrayList<>();

        for(Train train:trainList){
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)){
                res.add(train);
            }
        }
        return res;
    }

    //  homework add date to train and add a filter for date 
    //  booking 
    public Ticket bookTicket(User user,int trainId,int seatCount){
        for(Train train:trainList){
            if(train.getTrainId() == trainId){
                if(train.bookSeats(seatCount)){
                    Ticket ticket = new Ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else{
                    System.out.println("Not enough seat available.");
                    return null;
                }
            }
        }

        System.out.println("Train id Not Found ! ");
        return null;
    }

    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res = new ArrayList<>();

        for(Ticket ticket:ticketList){
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                res.add(ticket);
            }
        }
        return res;
    }

    public boolean cancelTicket(int ticketId,User user){
        Iterator<Ticket> iterator = ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket = iterator.next();
            if(ticket.getTicketId() == ticketId && 
                ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                Train train = ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket : " + ticketId + "cancelled successfully");
                return true;
            }
        }
        System.out.println("Ticket not found or does not belong to current user");
        return false;
    }

    //  list of all trains 
    public void listAllTrains(){
        System.out.println("List of All Trains : ");
        for(Train train:trainList){
            System.out.println(train);
        }
    }

}
