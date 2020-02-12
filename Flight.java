import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
/**
 * Class to reprisent a flight.
 *
 * @author (Tom Blanchard)
 * @version (1.1)
 */
public class Flight{
    /** the specified number of seat rows */
    private static final int ROW_TOTAL = 40;
    
    /** the specified number of seat rows */
    private static final int COL_TOTAL = 6;
    
    /** the flight number */
    private String flightNumber;
    
    /** the flight origin */
    private String origin;
    
    /** the flight destination */
    private String destination;
    
    /** the flight date */
    private String date;
    
    /** the full list of seats on the flight */
    private Seat[][] seats;
    
    /**
     * Constructor for objects of class Flight
     * @param   flightNumber    reprisents the flight number
     * @param   origin          reprisents the flight origin
     * @param   destination     reprisents the flight destination
     * @param   date            reprisents the flight date
     */
    public Flight(String flightNumber, String origin, String destination, String date){
        if(flightNumber == "" || origin == "" || destination == "" || date == ""){
            throw new IllegalArgumentException("Error: Fields cannot be empty");
        }
        
         if(flightNumber.equals(null) || origin.equals(null) 
          || destination.equals(null) || date.equals(null)){
            throw new IllegalArgumentException("Error: Fields cannot be null");
        }
        
        if(!flightNumber.matches("^[a-zA-Z0-9]*$" )){
            throw new IllegalArgumentException("Invalid flight number");
        }else if(!(origin.matches("[A-Za-z]{3}")) || !(destination.matches("[A-Za-z]{3}"))){
            throw new IllegalArgumentException("Invalid origin or destination");
        } else if(!dateIsValid(date)){
            throw new IllegalArgumentException("Invalid date");
        }
        
        seats = new Seat[ROW_TOTAL][COL_TOTAL];
        for(int row = 0; row < ROW_TOTAL; row ++){
            for(int col = 0; col < COL_TOTAL; col++){
                seats[row][col] = new Seat(rowColToSeat(row,col), 250.78, 10, 
                MealType.SNACK);
            }
        }
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;  
        this.date = date;
    }
    
    /**
     * Method to validate date
     * @param       date        reprisents a date to validate
     * @return      boolean 
     */
    private boolean dateIsValid(String date){
        String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    
    /**
     * Method to access flight number
     * @return       flightNumber
     */
    public String getFlightNumber(){
        return flightNumber;
    }
    
    /**
     * Method to access flight origin
     * @return       origin
     */
    public String getOrigin(){
        return origin;
    }
    
    /**
     * Method to access flight destination
     * @return       destination
     */
    public String getDestination(){
        return destination;
    }
    
    /**
     * Method to access flight date
     * @return       date
     */
    public String getDate(){
        return date;
    }
    
    /**
     * Method to convert row and column Integer to String seat number e.g. "1A"
     * @param        row        reprisents the seat row
     * @param        col        reprisents the seat colomn 
     * @return       String 
     */
    static String rowColToSeat(int row, int col){
        row += 1;
        String letter = "";
        String number = Integer.toString(row);
        if(col == 0){
            letter = "A";
        } else if(col == 1){
            letter = "B";
        } else if(col == 2){
            letter = "C";
        } else if(col == 3){
            letter = "D";
        } else if(col == 4){
            letter = "E";
        } else if(col == 5){
            letter = "F";
        }
        return number + letter;
    }
    
    /**
     * Method to access flight seat by row and colomn
     * @param        row        reprisents the seat row
     * @param        col        reprisents the seat column
     * @return       flightNumber
     */
    public Seat getSeat(int row, int col){
        if(row < 1 || row > 40){
            throw new IllegalArgumentException("Invalid row");
        } else if(col < 1 || col > 6){
            throw new IllegalArgumentException("Invalid column");
        }
        return seats[row-1][col-1];
    }
    
    /**
     * Method to access total number of passengers
     * @return       passengerCount
     */
    public int getPassengerCount(){
        int passengerCount = 0;
        for(int row = 0; row < ROW_TOTAL; row++){
            for(int col = 0; col < seats[row].length; col++){
                if((seats[row][col].getConfirmation().getName().equals("EMPTY SEAT"))){
                    passengerCount++;
                } 
            }
        }
        return passengerCount;
    }
    
    /**
     * Method to access list of confirmed seats associated with confirmation number
     * @param        confirmationNumber      reprisents the confirmation number
     * @return       array of seats
     */
    public String getConfirmedSeats(String confirmationNumber){
        int size = getPassengerCount();
        int count = 0;
        Seat[] seatsConfirmed = new Seat[size];
        for(int row = 0; row < ROW_TOTAL; row++){
            for(int col = 0; col < seats[row].length; col++){
                if(seats[row][col].getConfirmation().getConfirmationNumber().equals(confirmationNumber)){
                    seatsConfirmed[count] = seats[row][col];
                    count++;
                }
            }
        }
        return Arrays.toString(seatsConfirmed);
    }
    
    /**
     * Method to print a map of the flight seats
     * @return       String result
     */
    public String seatMap(){
        String result = "";
        int count = 0;
        result += "Flight #" + getFlightNumber() + " from " + getOrigin() + 
        " to " + getDestination() + ", " + getDate() + "\n";
        result += "    A  B  C  D  E  F\n";
        for(int row = 0; row < ROW_TOTAL; row++){
            if(row < 9){
                result += " " + (row + 1) + "  ";
            }else{
                result += row + 1 + "  ";
            }
            for(int col = 0; col < COL_TOTAL; col++){
                if(seats[row][col].getConfirmation().getName().equals("EMPTY SEAT")){
                    result += "_" + "  ";
                } else{
                    result += "X" + "  ";
                }
            }
            result += "\n";
        }
        return result;
    }
    
    public String printSeats(){
        String result = "";
        for(int row = 19; row < 20; row++){
            for(int col = 0; col < seats[row].length; col++){
                System.out.println(seats[row][col]);
            }
        }
        return result;
    }
    
    /**
     * 
     */
    public Seat getSeat(String seatNumber){
        int seatRow;
        int seatCol;
        if(!seatNumber.matches("^[A-Fa-f1-40]*${2,3}")){
            throw new IllegalArgumentException("seat number not valid");
        }
        
        if(seatNumber.length() == 2){
            seatRow = seatNumber.charAt(0) - 'A';
            seatCol = seatNumber.charAt(1) - 'A';
        }else{
            String seatRowStr = seatNumber.substring(0,1);
            seatRow = Integer.parseInt(seatRowStr);
            seatCol = seatNumber.charAt(2) - 'A';
        }
        return getSeat(seatRow, seatCol);
    }
    
    public String toString(){
        String result = "";
        result += "FLight number: " + getFlightNumber() + "\n";
        result += "Origin: " + getOrigin() + "\n";
        result += "destination: " + getDestination() + "\n";
        result += "date: " + getDate() + "\n";
        return result;
    }
}
    

