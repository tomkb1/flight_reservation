
/**
 * Reprisents a seat on the flight.
 *
 * @author (Tom Blanchard)
 * @version (1.1)
 */
public class Seat{
    /** the seat number */
    private String seatNumber;
    
    /** the seat price */
    private double price;
    
    /** the seat recline specifications */
    private int recline;
    
    /** the type of meal for the seat */
    private MealType mealType;
    
    /** the confirmation */
    private Confirmation confirmation;
    
    /** number of passangers */
    private int passangerCount;
    /**
     * Constructor for objects of class Seat
     * @param       seatNumber         Reprisents the seat number
     * @param       price              Reprisents the seat price
     * @param       recline            Reprisents the seat recline
     * @param       mealType           Reprisents the seat meal type
     */
    public Seat(String seatNumber, double price, int recline, 
                MealType mealType){
        setSeatNumber(seatNumber);
        setPrice(price);
        setRecline(recline);
        setMealType(mealType);
        confirmation = new Confirmation("EMPTY SEAT", "XXXXXX");
    }
    
    /**
     * Method to set the seat number
     * @param       seatNumber          Reprisents the seat number
     */
    public void setSeatNumber(String seatNumber){
        if(seatNumber == "" || seatNumber.equals(null)){
            throw new IllegalArgumentException("Invalid seat number");
        }
        this.seatNumber = seatNumber;
    }
    
    /**
     * Method to set the seat price
     * @param       seatNumber          Reprisents the seat price
     */
    public void setPrice(double price){
        if(price <= 0){
            throw new IllegalArgumentException("Price cannot be less than or equal to zero");
        }
        this.price = price;
    }
    
    /**
     * Method to set the seat recline
     * @param       seatNumber          Reprisents the seat recline
     */
    public void setRecline(int recline){
        if(recline < 0){
            throw new IllegalArgumentException("recline cannot be below zero");
        }
        this.recline = recline;
    }
    
    /**
     * Method to set the seat meal type
     * @param       seatNumber          Reprisents the seat meal type
     */
    public void setMealType(MealType mealType){
        this.mealType = mealType;
    }
    
    /**
     * Method to set the seat confirmation
     * @param       name                Reprisents name of person booking the seat
     * @param       confirmationNumber  Reprisents the confirmation number
     */
    public void setConfirmation(String name, String confirmationNumber){
        confirmation = new Confirmation(name, confirmationNumber);
    }
    
    /**
     * Method to remove seat confirmation
     * @param       seatNumber          Reprisents the seat number
     */
    public void removeConfirmation(){
        this.confirmation = new Confirmation("EMPTY SEAT", "XXXXXX");
    }
   
    /**
     * Method to access seat number
     * @return       seatNumber
     */
    public String getSeatNumber(){
        return seatNumber;
    }
    
    /**
     * Method to access seat price
     * @return       price
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Method to access seat recline
     * @return       recline
     */
    public int getRecline()
    {
        return recline;
    }
    
    /**
     * Method to access seat meal type
     * @return       mealType
     */
    public MealType getMealType()
    {
        return mealType;
    }
    
    /**
     * Method to access seat cofirmation
     * @return       confirmation
     */
    public Confirmation getConfirmation(){
        return confirmation;
    }
    
    /**
     * Method to reprisent seat attributes as a String
     * @return       result         String to display 
     */
    public String toString(){
        String result = "";
        result += "Seat Number: " + getSeatNumber() + "\n";
        result += "Price: $" + getPrice() + "\n";
        result += "Recline: " + getRecline() + " inches \n";
        result += "Meal Type: " + getMealType() + "\n";
        result += "Confirmation: " + getConfirmation() + "\n";
        return result;
    }
}
