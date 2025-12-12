public class Train {
    //  id 
    private int trainId;
    private String name;
    private String source;
    private String destination;

    private int totalSeats;
    private int availableSeats;

    //  let's build a constructor 
    public Train(int trainId,String name,String source,String destination,int totalSeats){
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    //  getter and setter 
    //  trainId 
    void setTrainId(int id){
        trainId = id;
    }
    int getTrainId(){
        return trainId;
    }

    //  name 
    String getName(){
        return name;
    }
    void setname(String name){
        this.name = name;
    }

    //  source
    String getSource(){
        return source;
    }
    void setSource(String source){
        this.source = source;
    }
    //  destination 
    String getDestination(){
        return destination;
    }
    void setDestination(String destination){
        this.destination = destination;
    }

    //  totalSeats 
    int getTotalSeats(){
        return totalSeats;
    }
    void setTotalSeats(int totalSeats){
        this.totalSeats = totalSeats;
    }
    //  availableSeats 
    int getAvailableSeats(){
        return availableSeats;
    }
    void setAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }

    //  let's generate the getter and setter of these 
    //  book seat and cancel seat should be in that particular train 
    public boolean bookSeats(int count){
        //  if count is < availableSteasts then decrease 
        if(count <= availableSeats){
            availableSeats -= count;
            return true;
        }
        return false;
    }

    //  increasing the available seats 
    public void cancelSeats(int count){
        availableSeats += count;
    }

    @Override
    public String toString() {
        return trainId + " | " + name + " | " + source + " -> " + destination + " Seats Available:  " + availableSeats;
    }


}
