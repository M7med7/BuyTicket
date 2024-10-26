/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/
package pkg2239457_f2_program_2_buyticket;

import java.util.Date;


public class Concert extends Event{
    private String performers;

    public Concert(String performers, String name, Date SDate, Date EDate, double Price, String City, String Address, String TargetedAudience, int AvaliableTickets) {
        super(name, SDate, EDate, Price, City, Address, TargetedAudience, AvaliableTickets);
        this.performers = performers;
    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }
    public int CompareTo(Event o){
        
        return 0;
        
    }
     @Override
    public String toString() {
        return 
                "AddingConcert"+super.toString() + "performers: " + performers + "} was successfully completed";
    }

    @Override
    public int compareTo(Event o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
