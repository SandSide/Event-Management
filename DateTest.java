
/**
 * Write a description of class Date Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Date;
import java.util.Scanner;

public class DateTest
{
    // instance variables - replace the example below with your own
    private Date time_joined;

    /**
     * Constructor for objects of class ParseInput
     */
    public DateTest()
    {
        time_joined = new Date();
    }
    
    /**
     * Standard main method
     */
    public static void main(String args[])
    {
        DateTest datetest = new DateTest();
        datetest.runTest();
    }
   

    /**
     * Output time
     */
    public void runTest()
    {
        String input = "";
        long elapsed;
        System.out.println("\nTime test");
        Scanner s = new Scanner(System.in);
        
        while (!input.equals("q"))
        {
            System.out.print("\nPress return or enter q to quit: ");
            input = s.nextLine();
            elapsed = getElapsedTime();
            System.out.println("Elapsed time = " + elapsed + " millisecs");
        }
        System.out.println("Bye!");
    }  
    
     /**
     * Elapsed - calculate the time elapsed since this object was created
     * 
     * @param       NONE
     * @return      time in seconds
     */
    public long getElapsedTime()
    {
        Date time_now = new Date();
        long elapsed;
        
        elapsed = time_now.getTime() - time_joined.getTime();   
        return elapsed;
    }
}
