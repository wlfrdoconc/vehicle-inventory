package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    public static void main(String[] args) {

        System.out.println("======== Welcome to the Vehicle Inventory! ========");

        // Create an array capable of holding 20 vehicles
        Vehicle[] inventory = new Vehicle[20];

        // Counter for the current number of vehicles
        int vehicleCount = 6;

        // Preload the first 6 vehicles
        inventory[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        inventory[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        inventory[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        inventory[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        inventory[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        inventory[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        // Scanner
        Scanner read = new Scanner(System.in);

        // Keeps the program running until the user exits
        int currentChoice = 0;

        // Display the menu
        // While loop that navigates through the program
        while (currentChoice != 6) {
            displayMenuOptions();
            currentChoice = read.nextInt();
            read.nextLine();

            switch (currentChoice) {
                case 1:
                    listAllVehicles(inventory);
                    break;
                case 2:
                    findVehiclesByMakeModel(inventory, read);
                    break;
                case 3:
                    findVehiclesByPriceRange(inventory, read);
                    break;
                case 4:
                    findVehiclesByColor(inventory, read);
                    break;
                case 5:
                    vehicleCount = addAVehicle(inventory, vehicleCount, read);
                    break;
                case 6:
                    System.out.println("See you later!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }


    }


    // Display method
    public static void displayMenuOptions() {
        System.out.print("""

            ========== VEHICLE INVENTORY MAIN MENU ==========
            What would you like to do?
            1. List all vehicles
            2. Search by make/model
            3. Search by price range
            4. Search by color
            5. Add a vehicle
            6. Exit the program
            ---------------------------------------
            Enter your command (1, 2, 3, 4, 5, 6):\s""");
    }

    // listAllVehicles()
    public static void listAllVehicles(Vehicle[] inventory) {
        System.out.println("=== All Vehicles ===");

        // Loop through every object in the array
        for (Vehicle vehicle: inventory) {
            if (vehicle != null) { // Prints all the current vehicles in the inventory
                System.out.println("ID: " + vehicle.getVehicleId()
                        + " | Make/Model: " + vehicle.getMakeModel()
                        + " | Color: " + vehicle.getColor()
                        + " | Odometer Reading: " + vehicle.getOdometerReading()
                        + " | Price $: " + vehicle.getPrice());
            }
        }

    }

    // findVehiclesByMakeModel()
    public static void findVehiclesByMakeModel(Vehicle[] inventory, Scanner read) {
        System.out.println("=== Find Vehicle by Make/Model ===");

        System.out.print("Enter the vehicle make/model: ");
        String enteredMakeModel = read.nextLine();

        for (Vehicle vehicle: inventory) {
            if (vehicle != null) {
                if (enteredMakeModel.equalsIgnoreCase(vehicle.getMakeModel())) { // If the user's input matches, return make/model
                    System.out.println("ID: " + vehicle.getVehicleId()
                            + " | Make/Model: " + vehicle.getMakeModel()
                            + " | Color: " + vehicle.getColor()
                            + " | Odometer Reading: " + vehicle.getOdometerReading()
                            + " | Price $: " + vehicle.getPrice());
                }
            }
        }
    }

    // findVehiclesByPriceRange()
    public static void findVehiclesByPriceRange(Vehicle[] inventory, Scanner read) {
        System.out.println("=== Find Vehicle by Price Range ===");

        // Prompt user for the minimum price
        System.out.print("Enter the minimum price: ");
        double minPrice = read.nextDouble();

        // Prompt user for the maximum price
        System.out.print("Enter the maximum price: ");
        double maxPrice = read.nextDouble();

        // If Price is in between minPrice and maxPrice, print vehicles within that range
        for (Vehicle vehicle: inventory) {
            if (vehicle != null) {
                if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                    System.out.println("ID: " + vehicle.getVehicleId()
                            + " | Make/Model: " + vehicle.getMakeModel()
                            + " | Color: " + vehicle.getColor()
                            + " | Odometer Reading: " + vehicle.getOdometerReading()
                            + " | Price $: " + vehicle.getPrice());
                }
            }
        }
    }

    // findVehiclesByColor()
    public static void findVehiclesByColor(Vehicle[] inventory, Scanner read) {
        System.out.println("=== Find Vehicle by Color ===");

        // Prompt user for the color of vehicles they're looking for
        System.out.print("Enter the color of vehicles you're looking for: ");
        String enteredColor = read.nextLine();

        for (Vehicle vehicle: inventory) {
            if (vehicle != null) {
                if (enteredColor.equalsIgnoreCase(vehicle.getColor())) { // Returns a vehicle with a matching color
                    System.out.println("ID: " + vehicle.getVehicleId()
                            + " | Make/Model: " + vehicle.getMakeModel()
                            + " | Color: " + vehicle.getColor()
                            + " | Odometer Reading: " + vehicle.getOdometerReading()
                            + " | Price $: " + vehicle.getPrice());
                }
            }
        }

    }

    // addAVehicle()
    public static int addAVehicle(Vehicle[] inventory, int vehicleCount, Scanner read) {
        System.out.println("=== Add a Vehicle ===");

        // Check if there's more room for another vehicle
        if (vehicleCount >= inventory.length) {
            System.out.println("The inventory is full!");
            return vehicleCount;
        }

        // Prompt user for the vehicle information
        System.out.print("Enter the vehicle ID: ");
        int vehicleId = read.nextInt();
        read.nextLine();

        System.out.print("Enter the make/model: ");
        String makeModel = read.nextLine();

        System.out.print("Enter the color: ");
        String color = read.nextLine();

        System.out.print("Enter the odometer reading: ");
        int odometerReading = read.nextInt();

        System.out.print("Enter the price: ");
        double price = read.nextDouble();

        // Create a new Vehicle object
        Vehicle newVehicle = new Vehicle(vehicleId, makeModel, color, odometerReading, price);

        // Add the new vehicle to the inventory
        inventory[vehicleCount] = newVehicle;

        // Increase the vehicle count
        vehicleCount++;

        System.out.println("Vehicle added successfully!");

        return vehicleCount;
    }
}
