package pkg2239457_f2_program_2_buyticket;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Customer {

    private String CustomerID;
    private String name;
    private char Gender;
    private String email;
    private Date DateofBirth;
    private String City;
    

    public Customer(String CustomerID, String name, char Gender, String email, Date DateofBirth,String City) {
        this.City=City;
        this.CustomerID = CustomerID;
        this.name = name;
        this.Gender = Gender;
        this.email = email;
        this.DateofBirth = DateofBirth;
    }

    public String getID() {
        return CustomerID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return Gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateofBirth() {
        return DateofBirth;
    }

    public void setID(String CID) {
        this.CustomerID = CID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate setLocalDate(Date date){
         return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public int getAge(Customer customer){
        LocalDate startDate=setLocalDate(customer.getDateofBirth());
        LocalDate nowDate=LocalDate.now();
        int age=Period.between(startDate, nowDate).getYears();
        return age;
    }

    @Override
    public String toString() {
        return name;
    }

}
