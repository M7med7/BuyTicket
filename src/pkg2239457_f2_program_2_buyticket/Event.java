/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/
package pkg2239457_f2_program_2_buyticket;

import java.util.Date;


public abstract class Event implements Comparable<Event>{
    private String name;
    private Date SDate;
    private Date EDate;
    private double Price;
    private String City;
    private String Address;
    private String TargetedAudience;
    private int AvaliableTickets;

    public Event(String name, Date SDate, Date EDate, double Price, String City, String Address, String TargetedAudience, int AvaliableTickets) {
        this.name = name;
        this.SDate = SDate;
        this.EDate = EDate;
        this.Price = Price;
        this.City = City;
        this.Address = Address;
        this.TargetedAudience = TargetedAudience;
        this.AvaliableTickets = AvaliableTickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSDate() {
        return SDate;
    }

    public void setSDate(Date SDate) {
        this.SDate = SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTargetedAudience() {
        return TargetedAudience;
    }

    public void setTargetedAudience(String TargetedAudience) {
        this.TargetedAudience = TargetedAudience;
    }

    public int getAvailableTickets() {
        return AvaliableTickets;
    }

    public void setAvaliableTickets(int AvaliableTickets) {
        this.AvaliableTickets = AvaliableTickets;
    }

    @Override
    public String toString() {
        return "Event{" + "name=" + name + ", SDate=" + SDate + ", EDate=" + EDate + ", Price=" + Price + ", City=" + City + ", Address=" + Address + ", TargetedAudience=" + TargetedAudience + ", AvaliableTickets=" + AvaliableTickets + '}';
    }
    
}
