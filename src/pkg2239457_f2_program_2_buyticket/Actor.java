/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/
package pkg2239457_f2_program_2_buyticket;


public class Actor {
    private String Name;
    private char Gender;
    private int Birthyear;

    public Actor(String Name, char Gender, int Birthyear) {
        this.Name = Name;
        this.Gender = Gender;
        this.Birthyear = Birthyear;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public int getBirthyear() {
        return Birthyear;
    }

   public void setBirthyear(int Birthyear) {
        this.Birthyear = Birthyear;
    }

    @Override
    public String toString() {
        return Name;
    }
    
}
