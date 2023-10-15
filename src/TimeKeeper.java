/***
 JAVADOC
 TimeKeeper class
 @author Pablo Yague
 @version 12/10/2023
 Created for CS180 Project 2
 **/
import java.util.Scanner;
public class TimeKeeper {
    public static void main(String[] args) {
        Scanner kbin = new Scanner(System.in);
        Lab[] labs = new Lab[3];
        boolean goodInput = false;
        boolean exitProgram = false;
        System.out.println("Welcome to the TimeKeeper application!");
        while (!goodInput) {
            initMenu();
            int initializedMenu = kbin.nextInt();
            kbin.nextLine();
            if (initializedMenu == 2) {
                System.out.println("Thank you for using TimeKeeper!");
                goodInput = true;
                exitProgram = true;
            } else if (initializedMenu != 1) {
                System.out.println("Invalid input. Please try again.");
            } else {
                goodInput = true;
            }
        }
        if (!exitProgram) {
            for (int i = 0; i < labs.length; i++) {
                System.out.println("Enter the capacity for Lab " + (i + 1));
                int capacity = kbin.nextInt();
                kbin.nextLine();
                System.out.println("Enter the location for Lab " + (i + 1));
                String location = kbin.nextLine();
                labs[i] = new Lab(capacity, location);
            }
        }
        LabManager labManager = new LabManager(labs[0], labs[1], labs[2]);
        boolean loopCurrentMenu = true;
        while (loopCurrentMenu && !exitProgram) {
            goodInput = false;
        /* ongoing & statistics menu
        1. View Current Lab Schedule
        2. List Labs by Availability
        3. List Labs by Reservation
        4. Add a Reservation
        5. Remove a Reservation
        6. Modify a Reservation
        7. Calculate Statistics
        8. Exit
         */
            int ongoingMenu = 0;
            while (!goodInput) {
                ongoingMenu();
                ongoingMenu = kbin.nextInt();
                kbin.nextLine();
                if (ongoingMenu > 8 || ongoingMenu < 1) {
                    System.out.println("Invalid input. Please try again.");
                } else {
                    goodInput = true;
                }
            }
            switch (ongoingMenu) {
                case 1:
                    for (int i = 0; i < labs.length; i++) {
                        System.out.println(labs[i].toString());
                    }
                    break;
                case 2:
                    System.out.println(labManager.listAvailableLabs());
                    break;
                case 3:
                    System.out.println(labManager.listReservedLabs());
                    break;
                case 4:
                    System.out.println("Enter the location of the lab:");
                    String location = kbin.nextLine();
                    System.out.println("Enter the time of the reservation:");
                    String time = kbin.nextLine();
                    System.out.println("Enter the name of the reservation:");
                    String name = kbin.nextLine();
                    System.out.println("Enter the expected enrollment:");
                    int enrollment = kbin.nextInt();
                    kbin.nextLine();
                    System.out.println(labManager.addReservation(location, time, name, enrollment));
                    break;
                case 5:
                    System.out.println("Enter the location of the lab");
                    location = kbin.nextLine();
                    System.out.println("Enter the time of the reservation");
                    time = kbin.nextLine();
                    System.out.println(labManager.removeReservation(location, time));
                    break;
                case 6:
                    System.out.println("Enter the location of the lab:");
                    location = kbin.nextLine();
                    System.out.println("Enter the time of the reservation:");
                    time = kbin.nextLine();
                    System.out.println("Enter the updated name of the reservation:");
                    name = kbin.nextLine();
                    System.out.println("Enter the updated enrollment:");
                    enrollment = kbin.nextInt();
                    kbin.nextLine();
                    System.out.println(labManager.modifyReservation(location, time, name, enrollment));
                    break;
                case 7:
                    boolean back = false;
                    while (!back) {
                        goodInput = false;
                        int statsMenu = 0;
                        while (!goodInput) {
                            statsMenu();
                            statsMenu = kbin.nextInt();
                            kbin.nextLine();
                            if (statsMenu < 1 || statsMenu > 4) {
                                System.out.println("Invalid input. Please try again.");
                            } else {
                                goodInput = true;
                            }
                        }
                        switch (statsMenu) {
                            case 1:
                                System.out.println("Total Capacity: " +
                                        Integer.toString(labManager.calculateTotalCapacity()));
                                break;
                            case 2:
                                System.out.println("Total Utilization: "
                                        + String.format("%.2f", labManager.calculateTotalUtilization()));
                                break;
                            case 3:
                                System.out.println("Available seats: "
                                        + Integer.toString(labManager.calculateAvailableSeats()));
                                break;
                            case 4:
                                back = true;
                                break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("Thank you for using TimeKeeper!");
                    loopCurrentMenu = false;
                    break;
            }
        }
    }
    public static void initMenu() {
        System.out.println("1. Initialize Application");
        System.out.println("2. Exit");
    }
    public static void ongoingMenu() {
        String mainMenu = "1. View Current Lab Schedule\n2. List Labs by Availability\n" +
                "3. List Labs by Reservation\n4. Add a Reservation\n5. Remove a Reservation\n" +
                "6. Modify a Reservation\n7. Calculate Statistics\n8. Exit";
        System.out.println(mainMenu);
    }
    public static void statsMenu() {
        String out = "1. Total Capacity\n2. Total Utilization\n3. Available Seats\n4. Return to main menu";
        System.out.println(out);
    }
}