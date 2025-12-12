import java.util.*;

public class IRCTCAPP {
    
    private final Scanner scanner = new Scanner(System.in);

    //  saari service kon control kar rha hai 
    private final UserService userService = new UserService();

    //  booking service 
    private final BookingService bookingService = new BookingService();
    public static void main(String[] args){
        new IRCTCAPP().Start();
    }

    public void Start(){
        while(true){
            System.out.println("\n--- Welcome to IRCTC App -----");
            //  check user is login or not 
            if(!userService.isLoggedIn()){
                System.out.println("1. Register : ");
                System.out.println("2. Login : ");
                System.out.println("3. Exit : ");
                System.out.println("4. Enter your choice  : ");
                int choice = scanner.nextInt();

                switch(choice){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();

                    default -> System.out.println("Invalid Choice..");
                }
            }
            else{
                //  if user already logged in show him different menu 
                showUserMenu();
            }
        }
    }

    public void register(){
        System.out.println("Enter UserName : ");
        String userName = scanner.next();
        System.out.println("Enter password : ");
        String password = scanner.next();
        System.out.println("Enter Full Name : ");
        scanner.nextLine();
        String fullName = scanner.nextLine();
        System.out.println("Enter Contact details : ");
        String contact = scanner.next();

        userService.registerUser(userName,password,fullName,contact);
    }

    public void login(){
        System.out.println("Enter UserName : ");
        String userName = scanner.next();
        System.out.println("Enter password : ");
        String password = scanner.next();
        userService.loginUser(userName, password);
    }

    public void showUserMenu(){
        while(userService.isLoggedIn()){
            System.out.println("\n --- User Menu ---");
            System.out.println("1. Search Train ");
            System.out.println("2. Book Ticket ");
            System.out.println("3. View My Ticket ");
            System.out.println("4. Cancel Tickets  ");
            System.out.println("5. View all Trains  ");
            System.out.println("6. Logout   ");
            System.out.println("Enter Choice :  ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1 -> searchTrain();
                case 2 -> bookTicket();
                case 3 -> viewMyTicket();
                case 4 -> cancelTicket();
                case 5 -> bookingService.listAllTrains();
                case 6 -> userService.logOut();
                default -> System.out.println("Invalid Choice ");
            }
        }
    }

    private void searchTrain(){
        System.out.println("Enter Source Station : ");
        String source = scanner.next();
        System.out.println("Enter Destination Station : ");
        String destination = scanner.next();

        List<Train> trains = bookingService.searchTrain(source, destination);
        if(trains.isEmpty()){
            System.out.println("No Trains found between " + source + " and " + destination);
            return;
        }
        
        System.out.println("Trains Found");
        for(Train train:trains){
            System.out.println(train);
        }

        //  ask a question whether they want to book it or not 
        System.out.println("Do you want to book train ticket from this window only ? (yes/no): ");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase(choice)){
            System.out.println("Enter Train Id to book : ");
            int trainID = scanner.nextInt();
            System.out.println("Enter Number of Seats to be booked..");
            int seats = scanner.nextInt();

            Ticket ticket  = bookingService.bookTicket(userService.getCurrentUSer(),trainID,seats);
            if(ticket != null){
                //  
                System.out.println("Booking Succesfull .. ");
                System.out.println(ticket);
            }
        }
        else{
            System.out.println("Returning to user Menu ..");
        }
    }

    private void bookTicket(){
        System.out.println("Enter Source Station : ");
        String source = scanner.next();
        System.out.println("Enter Destination Station : ");
        String destination = scanner.next();
        List<Train> trains = bookingService.searchTrain(source, destination);
        if(trains.isEmpty()){
            System.out.println("No Trains available to book between these  stations.");
            return;
        }
        System.out.println("Available trains : ");
        for(Train train:trains){
            System.out.println(train);
        }
        System.out.println("Enter Train Id to book : ");
        int trainID = scanner.nextInt();
        System.out.println("Enter Number of Seats to be booked..");
        int seats = scanner.nextInt();

        Ticket ticket  = bookingService.bookTicket(userService.getCurrentUSer(),trainID,seats);
        if(ticket != null){
                //  
            System.out.println("Booking Succesfull .. ");
            System.out.println(ticket);
        }
    }

    private void viewMyTicket(){
        
        List<Ticket> ticketByUser  = bookingService.getTicketByUser(userService.getCurrentUSer());
        if(ticketByUser.isEmpty()){
            System.out.println(
                "No ticket found ");
        }
        else{
            System.out.println("Your Tickets : ");
            for(Ticket ticket:ticketByUser){
                System.out.println(ticket);
            }
        }


    }

    private void cancelTicket(){
        System.out.println("Enter ticket Id to cancel : ");
        int ticketID = scanner.nextInt();
        bookingService.cancelTicket(ticketID,userService.getCurrentUSer());
    }

    private void exitApp(){
        System.out.println("Thank You for using the IRCTC App.");
        System.exit(0);
    }

}
