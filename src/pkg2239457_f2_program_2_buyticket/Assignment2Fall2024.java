/*
Name: Mohammed Rashid Alharbi
ID: 2239457
Section: F2
*/

package pkg2239457_f2_program_2_buyticket;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Assignment2Fall2024 {

    private static ArrayList<Event> currentEvent = new ArrayList<>();
    private static ArrayList<Customer> currentCustomers = new ArrayList<>();
    public static StringBuilder stringBuilder = new StringBuilder();
    public static int counter = 0;
    
    //Print the project
    public static void saveOutput(String outputFile) throws FileNotFoundException {
        try {
            File output = new File(outputFile);
            PrintWriter owrite = new PrintWriter(output);
            owrite.append(stringBuilder.toString());
            owrite.flush();
            owrite.close();
        } catch (FileNotFoundException e) {
            System.out.println("output file not created");
            throw e;
        }
    }
//--------------------------------------------------------------------------
    
// Print argument
    public static void print(String str) {
        stringBuilder.append(str);
    }
//--------------------------------------------------------------------------
// Print argument then new line
    public static void println(String str) {
        print(str);
        stringBuilder.append("\n");
    }
//--------------------------------------------------------------------------
// Print new line
    public static void println() {
        stringBuilder.append("\n");
    }
//--------------------------------------------------------------------------
// Print with format
    public static void printf(String pattern, Object... objects) {
        print(String.format(pattern, objects));
    }
//--------------------------------------------------------------------------

    public static void printfln(String pattern, Object... objects) {
        printf(pattern, objects);
        println();
    }
//--------------------------------------------------------------------------

    public static void newLine() {
        println();
    }
//--------------------------------------------------------------------------

    public static void printLine(int n) {
        for (int i = 0; i < n; i++) {
            newLine();
        }
    }
//--------------------------------------------------------------------------

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        File input = new File("input.txt");
        //Checking if the file exists
        if (!input.exists()) {
            System.out.println("input file" + input + "Does not exist");
            System.exit(0);
        }

        
        println("########################################################################################################");
        println("############################# Welcome to Entertainment Booking System ##################################");
        println("########################################################################################################\n");
        //Making a scanner to read the input file
        Scanner read = new Scanner(input);
        ArrayList<Event> shoppingCart = new ArrayList<Event>();
        String notFoundCustomer = null;
        Customer bookingCustomer = null;
        Booking booking = null;
        do {
            // do-while loop to check the Command
            String Command = read.nextLine();
            if (Command.startsWith("AddMovie")) {
                Movie movie = addMovie(getCommand(Command));
                currentEvent.add(movie);
                printfln("AddingMovie{Name:%s, Dates:%s - %s, City: %s, Address: %s, Price: %s, Target Audience: %s, Tickets Available: %s, Rating:%s, Language:%s, Genre:%s, Actor: %s } was successfully completed", movie.getName(), dateToshortString(movie.getSDate()), dateToshortString(movie.getEDate()), movie.getCity(), movie.getAddress(), movie.getPrice(), movie.getTargetedAudience(), movie.getAvailableTickets(), movie.getRating(), movie.getLanguage(), movie.getGenre(), movie.getActor());
            } else if (Command.startsWith("AddFestival")) {
                Festival festival = addFestival(getCommand(Command));
                currentEvent.add(festival);
                printfln("AddingFestival{Name:%s, Dates:%s - %s, City: %s, Address: %s, Price: %s, Target Audience: %s, Tickets Available: %s, FoodVenues:%s, Activities:%s } was successfully completed", festival.getName(), dateToshortString(festival.getSDate()), dateToshortString(festival.getEDate()), festival.getCity(), festival.getAddress(), festival.getPrice(), festival.getTargetedAudience(), festival.getAvailableTickets(), Arrays.toString(festival.getFoodVenues()), Arrays.toString(festival.getActivity()));
            } else if (Command.startsWith("AddConcert")) {
                Concert concert = addConcert(getCommand(Command));
                currentEvent.add(concert);
                printfln("AddingConcert{Name:%s, Dates:%s - %s, City: %s, Address: %s, Price: %s, Target Audience: %s, Tickets Available: %s, Performers: %s } was successfully completed", concert.getName(), dateToshortString(concert.getSDate()), dateToshortString(concert.getEDate()), concert.getCity(), concert.getAddress(), concert.getPrice(), concert.getTargetedAudience(), concert.getAvailableTickets(), concert.getPerformers());
            } else if (Command.startsWith("AddCustomer")) {
                Customer customer = addCustomer(getCommand(Command));
                currentCustomers.add(customer);
                printfln("AddingCustomer {Customer Number :%s, Name: %s, Email: %s, DateOfBirth: %s } was successfully completed", customer.getID(), customer.getName(), customer.getEmail(), dateToshortString(customer.getDateofBirth()));
            } else if (Command.startsWith("BuyTicket")) {
                if (BuyTicket(getCommand(Command), shoppingCart)) {
                    println("Ticket is successfully added to the ShoppingCart: Cart Size -> " + shoppingCart.size());
                } else {
                    println("Ticket not successfully added to the ShoppingCart: Cart Size -> " + shoppingCart.size());
                }
            } else if (Command.startsWith("For")) {
                String[] arguments = getCommand(Command);
                bookingCustomer = FindCustomer(arguments);
                if (bookingCustomer == null) {
                    println("The customer " + arguments[0] + " is not found");
                    notFoundCustomer = arguments[0];
                    shoppingCart.clear();
                    booking = null;
                } else {
                    booking = new Booking(GetBookingID(bookingCustomer.getID()), bookingCustomer, shoppingCart);

                }

            } else if (Command.startsWith("Submit")) {
                if (submit(shoppingCart, bookingCustomer)) {
                    println("**Buying Ticket for " + booking.getCustomer() + " was successfully completed");
                    invoice(booking);
                } else {
                    println("**Buying Ticket for " + notFoundCustomer + " was not successfully completed");
                    notFoundCustomer = null;
                }
                println();
                shoppingCart.clear();
                booking = null;

            } else if (Command.equalsIgnoreCase("PrintSortMovies")) {
                SearchForMovie();
            } else if (Command.equalsIgnoreCase("PrintSortFestivals")) {
                SearchForFestival();
            }
            // It will stop the loop when there is nothing left in the file
        } while (read.hasNext());
        {
            read.close();
            
        }
        saveOutput("Output.txt");

    }

//--------------------------------------------------------------------------
    //Method to split and clear the text we read from the input file
    public static String[] getCommand(String line) {
        String Array[] = null;

        if (line.startsWith("AddMovie")) {
            Array = line.substring("AddMovie--".length()).split(", ");

        } else if (line.startsWith("AddFestival")) {
            Array = line.substring("AddFestival--".length()).split(", ");
        } else if (line.startsWith("AddConcert")) {
            Array = line.substring("AddConcert--".length()).split(", ");
        } else if (line.startsWith("AddCustomer")) {
            Array = line.substring("AddCustomer--".length()).split(", ");
        } else if (line.startsWith("BuyTicket")) {
            Array = line.substring("BuyTicket--".length()).split(", ");
        } else if (line.startsWith("For")) {
            Array = line.substring("For--".length()).split(", ");
        }

        return Array;
    }

//--------------------------------------------------------------------------
    //Method to store the print information
    
    public static void invoice(Booking book) {
        println();
        println("------------------------- Invoice Details -------------------------");
        println("Booking# " + book.getBookingID());
        println("Customer #:" + book.getCustomer().getID());
        println("-------------------------------------------------------------------");
        printf("%-20s\t%-8s\t%-8s\t%-11s", "Events", "Price", "Discount", "Final_Price \n");
        for (int i = 0; i < book.getEvents().size(); i++) {
            Event event = book.getEvents().get(i);
            double discount = 0;
            if (event instanceof Festival) {
                discount = book.getDiscount((Festival) event) * 100;
            }
            printf("%-20s\t%.2f\t\t%-14s\t%.2f\n", event.getName(), event.getPrice(), discount + "%", book.getFinalPrice(event));
        }
        println("-------------------------------------------------------------------");
        println("Number of dicount items " + book.getNumberOfDiscountEvent());
        println("- Total Price: " + book.getTotalPrice());
        println("- Final Price: " + book.calculateFinalPrice());
        println("- Saving amount: " + (book.getSavingAmount()));
        println("-------------------------------------------------------------------\n");
    }

//--------------------------------------------------------------------------
    //Method for buying tickets
    
    public static boolean BuyTicket(String[] argument, ArrayList<Event> shoppingCart) throws ParseException {
        String eventname = argument[0];
        Date bookingDate = new SimpleDateFormat("d/M/yyyy").parse(argument[1]);
        Event event = FindEvent(eventname);
        if (event == null) {
            println("The event " + eventname + " is not found");
            return false;
        }
        if (event.getAvailableTickets() <= 0 && !(event instanceof Concert)) {
            println("The event " + event.getName() + " is not available");
            return false;
        }

        if ((bookingDate.before(event.getSDate()) || bookingDate.after(event.getEDate()))) {
            println("The requested event " + event.getName() + " is not available in the selected date");
            return false;

        }
        shoppingCart.add(event);
        println("The requested event " + event.getName() + " is available in the selected date");
        return true;

    }

//--------------------------------------------------------------------------
    //Method for finding customer 
    
    public static Customer FindCustomer(String[] argument) {
        for (int i = 0; i < currentCustomers.size(); i++) {
            if (currentCustomers.get(i).getName().equalsIgnoreCase(argument[0])) {
                return currentCustomers.get(i);
            }
        }
        return null;

    }
//--------------------------------------------------------------------------
    //Method for finding the event
    
    public static Event FindEvent(String arguments) {
        for (int i = 0; i < currentEvent.size(); i++) {
            if (currentEvent.get(i).getName().equalsIgnoreCase(arguments)) {
                return currentEvent.get(i);
            }
        }
        return null;

    }
//--------------------------------------------------------------------------
    //Method confirms the booking the deeduct
    
    public static boolean submit(ArrayList<Event> shoppingCart, Customer customer) {
        if (shoppingCart.isEmpty() || customer == null) {
            return false;
        }
        for (int i = 0; i < shoppingCart.size(); i++) {
            shoppingCart.get(i).setAvaliableTickets(shoppingCart.get(i).getAvailableTickets() - 1);

        }
        return true;
    }

   
//--------------------------------------------------------------------------
    //Method to sort the movies by there rating
    
    public static void SearchForMovie() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < currentEvent.size(); i++) {
            if (currentEvent.get(i) instanceof Movie) {
                movies.add((Movie) currentEvent.get(i));
            }

        }
        Collections.sort(movies, Collections.reverseOrder());
        println("----------------------------------------- Movie Sorted By Rating ------------------------------------------");
        printf("%-20s\t%-18s\t%-16s\t%-14s\t%-12s\n", "Movie name", "Dates", "Actor", "Ratings", "Available Tickets");
        println("---------------------------------------------------------------------------------------------------------");
        for (Movie movie : movies) {
            printf("%-20s\t%-18s\t%-18s\t%-18s\t%-18s\n", movie.getName(), dateToshortString(movie.getSDate()) + "-" + dateToshortString(movie.getEDate()), movie.getActor(), movie.getRating(), movie.getAvailableTickets());
        }
        println("---------------------------------------------------------------------------------------------------------\n\n");
    }
//--------------------------------------------------------------------------
    //Method to sort the festivals by there date
    
    public static void SearchForFestival() {
        ArrayList<Festival> festivals = new ArrayList<>();
        for (int i = 0; i < currentEvent.size(); i++) {
            if (currentEvent.get(i) instanceof Festival) {
                festivals.add((Festival) currentEvent.get(i));
            }
        }
        Collections.sort(festivals);
        println("---------------------------------------- Festival Sorted By Starting Date -----------------------------------------------");
        printf("%-20s\t%-20s\t%-25s\t%-20s\t%-12s\n", "Festival Name", "Dates", "FoodVenues", "Activities", "Available Tickets");
        println("------------------------------------------------------------------------------------------------------------------------");
        for (Festival festival : festivals) {
            printf("%-20s\t%-20s\t%-25s\t%-20s\t%-12s\n", festival.getName(), (dateToshortString(festival.getSDate()) + "-" + dateToshortString(festival.getEDate())), Arrays.toString(festival.getFoodVenues()), Arrays.toString(festival.getActivity()), festival.getAvailableTickets());
        }
        println("------------------------------------------------------------------------------------------------------------------------\n");
    }

//--------------------------------------------------------------------------
    //Method for adding customers
    public static Customer addCustomer(String[] argument) throws ParseException {
        String customerID = GetCustomerID();
        String customerName = argument[0];
        char gender = argument[1].charAt(0);
        String city = argument[2];
        Date dateOfBirth = GetDate(argument[3]);
        String email = argument[4];
        return new Customer(customerID, customerName, gender, email, dateOfBirth, city);

    }
//--------------------------------------------------------------------------
    //Method for adding movies
    public static Movie addMovie(String[] argument) throws ParseException {
        String name = argument[0];
        Date startingDate = GetDate(argument[1]);
        Date endingDate = GetDate(argument[2]);
        double price = Double.parseDouble(argument[3]);
        String city = argument[4];
        String address = argument[5];
        String language = argument[6];
        String targetedAudience = argument[7];
        double rating = Double.parseDouble(argument[8]);
        int avaliableTickets = Integer.parseInt(argument[9]);
        String Genre = argument[10];
        String mainActorName = argument[11];
        char mainActorGender = argument[12].charAt(0);
        int mainActorBirthYear = Integer.parseInt(argument[13]);
        return new Movie(language, rating, Genre, new Actor(mainActorName, mainActorGender, mainActorBirthYear), name, startingDate, endingDate, price, city, address, targetedAudience, avaliableTickets);
    }
//--------------------------------------------------------------------------
     //Method for adding festivals
    public static Festival addFestival(String[] argument) throws ParseException {
        String name = argument[0];
        Date startingDate = GetDate(argument[1]);
        Date endingDate = GetDate(argument[2]);
        double price = Double.parseDouble(argument[3]);
        String city = argument[4];
        String address = argument[5];
        String targetedAudience = argument[6];
        int availableTickets = Integer.parseInt(argument[7]);
        String[] foodVenues = argument[8].split(" ");
        String[] activites = argument[9].split(" ");
        return new Festival(foodVenues, activites, name, startingDate, endingDate, price, city, address, targetedAudience, availableTickets);

    }
//--------------------------------------------------------------------------
    //Method for adding concerts
    public static Concert addConcert(String[] argument) throws ParseException {
        String name = argument[0];
        Date startingDate = GetDate(argument[1]);
        Date endingDate = GetDate(argument[2]);
        double price = Double.parseDouble(argument[5]);
        String city = argument[3];
        String address = argument[4];
        String targetedAudience = argument[7];
        int availableTickets = Integer.parseInt(argument[6]);
        String performers = argument[8];
        return new Concert(performers, name, startingDate, endingDate, price, city, address, targetedAudience, availableTickets);
    }
//--------------------------------------------------------------------------
    //Method to get the customerID
    public static String GetCustomerID() {

        return String.format("%06d", ++counter);

    }
//--------------------------------------------------------------------------
    //Method to get the bookingId
    public static String GetBookingID(String CustomerID) {
        return CustomerID + String.format("%03d", (int) (Math.random() * 999));

    }
//--------------------------------------------------------------------------
    //Method to get the date
    public static Date GetDate(String s) throws ParseException {
        return new SimpleDateFormat("d/M/yyyy").parse(s);

    }
//--------------------------------------------------------------------------
    //Method to print the date
    public static String dateToshortString(Date date) {

        return new SimpleDateFormat("dd/MM/yy").format(date);

    }
}
