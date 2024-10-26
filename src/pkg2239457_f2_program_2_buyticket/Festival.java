/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/
package pkg2239457_f2_program_2_buyticket;

import java.util.Arrays;
import java.util.Date;


public class Festival extends Event{
    private String[] FoodVenues;
    private String[] Activity;

    public Festival(String[] FoodVenues, String[] Activity, String name, Date SDate, Date EDate, double Price, String City, String Address, String TargetedAudience, int AvaliableTickets) {
        super(name, SDate, EDate, Price, City, Address, TargetedAudience, AvaliableTickets);
        this.FoodVenues = FoodVenues;
        this.Activity = Activity;
    }

    public String[] getFoodVenues() {
        return FoodVenues;
    }

    public void setFoodVenues(String[] FoodVenues) {
        this.FoodVenues = FoodVenues;
    }

    public String[] getActivity() {
        return Activity;
    }

    public void setActivity(String[] Activity) {
        this.Activity = Activity;
    }
   
    @Override
    public String toString() {
         return "AddingFestival"+super.toString()+" FoodVenuss=" + Arrays.toString(FoodVenues) + ", Activity=" + Arrays.toString(Activity) + "} was successfully completed"; 
    }

    @Override
    public int compareTo(Event o) {
        if(!(o instanceof Festival)){
            return -1;
        } 
        Festival festival=(Festival)o;
        if(this.getSDate().getTime() > festival.getSDate().getTime()){
            return 1;
        } else if(this.getSDate().getTime() < festival.getSDate().getTime()) {
            return -1;
        } else{
            return 0;
        }
    }
    
    
   
    
}
