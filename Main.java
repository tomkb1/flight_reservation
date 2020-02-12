
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main{
   public static void main(String[] args){
       Flight myFlight = new Flight("5819", "LCY", "ANC", "09/21/2018");
       myFlight.getSeat(1, 3).setConfirmation("Ricky Gervais", "ASDFGH");
       myFlight.getSeat(4, 4).setConfirmation("John Cleese", "HNGYUI");
       myFlight.getSeat(2, 5).setConfirmation("Terry Gilliam", "KNUIOF");
       myFlight.getSeat(2, 3).setConfirmation("Darth V", "HOPEAH");
       myFlight.getSeat(2, 4).setConfirmation("Dawn Tinsley", "OHNOOH");
       myFlight.getSeat(3, 5).setConfirmation("Michael Palin", "NVMNDH");
       System.out.println(myFlight.getPassengerCount());
       // System.out.println(myFlight.printSeats().toString());
       // System.out.println(myFlight.getConfirmedSeats("ASDFGH"));
       System.out.println(myFlight.seatMap());
       // System.out.println("My seat at row 20, column 4 is : \n" + myFlight.getSeat(20, 4).toString());
       // myFlight.getSeat(20, 4).removeConfirmation();
       // System.out.println(myFlight.getConfirmedSeats("ASDFGH"));
       // System.out.println("My seat at row 20, column 4 is : \n" + myFlight.getSeat(20, 4).toString());
   }
}
