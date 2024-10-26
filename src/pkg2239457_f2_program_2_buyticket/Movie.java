/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/
package pkg2239457_f2_program_2_buyticket;

import java.util.Date;


public class Movie extends Event{
    private String Language;
    private double Rating;
    private String Genre;
    private Actor Actor;

   
    public Movie(String Language, double Rating, String Genre, Actor Actor, String name, Date SDate, Date EDate, double Price, String City, String Address, String TargetedAudience, int AvaliableTickets) {
        super(name, SDate, EDate, Price, City, Address, TargetedAudience, AvaliableTickets);
        this.Language = Language;
        this.Rating = Rating;
        this.Genre = Genre;
        this.Actor = Actor;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public Actor getActor() {
        return Actor;
    }

    public void setActor(Actor Actor) {
        this.Actor = Actor;
    }

    public String getLanguage() {
        return Language;
    }
       
    @Override
    public int compareTo(Event o) {
        if(!(o instanceof Movie)){
            return -1;
        } 
        Movie movie=(Movie)o;
        if(this.Rating > movie.Rating){
            return 1;
        } else if(this.Rating < movie.Rating) {
            return -1;
        } else{
            return 0;
        }
    }
    
    
    
    
}
