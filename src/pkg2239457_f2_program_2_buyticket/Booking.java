/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/


package pkg2239457_f2_program_2_buyticket;

import java.util.ArrayList;

public class Booking {

    private final  String bookingID;
    private Customer customer;
    private ArrayList<Event> events;
    private final double discount;
    private double finaltotalPrice;
    private double amountSaved;

  
   

    public Booking(String BookingID, Customer Customer, ArrayList<Event> Events) {
        this.bookingID = BookingID;
        this.customer = Customer;
        this.events = Events;
        if (customer.getAge(customer) <= 3) {

                discount= 1;
            } else if (customer.getAge(customer) <= 15) {
               discount= 0.5;
            }
            else {
                discount=0;
            }
    }

    public ArrayList<Event> getEvents() {

        return this.events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.events = Events;
    }


    public String getBookingID() {
        return bookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getDiscount() {
        return discount;

    }
    //Method to calculate the final price
    public double calculateFinalPrice() {
       
        finaltotalPrice=0;
        amountSaved=0;
        for (int i = 0; i < events.size(); i++) {
            double finalPrice = getFinalPrice(events.get(i));
            finaltotalPrice+=finalPrice;
            amountSaved+=events.get(i).getPrice()-finalPrice;
        }
        return finaltotalPrice;
    }
    //Method to get the final price
    public double getFinalPrice(Event event) {
       
        return event.getPrice()*(1-getDiscount(event));
    }
    //Method to get the total price
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < events.size(); i++) {
            totalPrice += events.get(i).getPrice();

        }
        return totalPrice;

    }
    //Method to get discount
    public double getDiscount(Event event) {
        if (event instanceof Festival) {
           return discount;

        }
        return 0;
    }
    //Method to get the number of discount
    public int getNumberOfDiscountEvent() {

        if (customer.getAge(customer) <= 15) {
            int num = 0;
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i) instanceof Festival) {
                    num++;
                }
            }
            return num;
        }

        return 0;

    }

    public double getSavingAmount() {
        return amountSaved;
    }

    

}
