
/**
 * Class that reprisents a confirmation 
 *
 * @author (Tom Blanchard)
 * @version (1.1)
 */
public class Confirmation {
    /** Passanger name */
    private String name;
    
    /** Confirmation number */
    private String confirmationNumber;
    
    /**
     * Constructor for objects of class Confirmation
     * @param       name                accepts a string to reprisent a name
     * @param       confirmationNumber  accepts a string to reprisent the confirmation number    
     */
    public Confirmation(String name, String confirmationNumber){
        setName(name);
        setConfirmationNumber(confirmationNumber);
    }
    
    /**
     * Method to set name
     * @param       name        accepts a string to respisent name
     */
    public void setName(String name){
        if(name == "" || name.equals(null)){
            throw new IllegalArgumentException("Error: Fields cannot be empty");
        } else 
        if(!name.matches("[a-zA-Z][a-zA-Z ]*")){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }
    
    /**
     * Method to set name
     * @param       name        accepts a string to respisent the confirmation number
     */
    public void setConfirmationNumber(String confirmationNumber){
         if(confirmationNumber == ""|| confirmationNumber.equals(null)
         ||!confirmationNumber.matches("[A-Za-z]{6}")){
            throw new IllegalArgumentException("Invalid confirmation");
        }
        this.confirmationNumber = confirmationNumber;
    }
    
    /**
     * Method to access name
     * @return      name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Method to access confirmation number
     * @return      confirmationNumber
     */
    public String getConfirmationNumber(){
        return confirmationNumber;
    }
    
    /**
     * Method to reprisent confirmation attributes as a String
     * @return       result         String to display 
     */
    public String toString(){
        String result = "";
        result += "\n\tName: " + getName() + "\n\tConfirmation Number: " + getConfirmationNumber();
        return result;
    }
}
