import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String name;
    private double price;

    public Destination(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Price: " + price;
    }
}

class Booking {
    private Destination destination;
    private String customerName;

    public Booking(Destination destination, String customerName) {
        this.destination = destination;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Booking for " + customerName + " to " + destination.getName() + " at " + destination.getPrice();
    }
}

public class TravelBookingSystem {
    private static ArrayList<Destination> destinations = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Destination");
            System.out.println("2. Book a Trip");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDestination(scanner);
                    break;
                case 2:
                    bookTrip(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addDestination(Scanner scanner) {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();
        System.out.print("Enter destination price: ");
        double price = scanner.nextDouble();
        destinations.add(new Destination(name, price));
        System.out.println("Destination added successfully.");
    }

    private static void bookTrip(Scanner scanner) {
        if (destinations.isEmpty()) {
            System.out.println("No destinations available to book.");
            return;
        }
        System.out.println("Available Destinations:");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println((i + 1) + ". " + destinations.get(i));
        }
        System.out.print("Select destination by number: ");
        int destIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (destIndex < 0 || destIndex >= destinations.size()) {
            System.out.println("Invalid destination selection.");
            return;
        }

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        bookings.add(new Booking(destinations.get(destIndex), customerName));
        System.out.println("Trip booked successfully.");
    }

    private static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            System.out.println("Bookings:");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}