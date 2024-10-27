package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Dealership dealership;
    static Scanner scnr = new Scanner(System.in);

    private static void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public static void display() {
        init();
        int choice;

        do {
            System.out.println("Please select one of the following options -");
            System.out.println(" 1) Find vehicles within a price range");
            System.out.println(" 2) Find vehicles by make/model");
            System.out.println(" 3) Find vehicles by year range");
            System.out.println(" 4) Find vehicles by color");
            System.out.println(" 5) Find vehicles by mileage range");
            System.out.println(" 6) Find vehicles by type (car, truck, SUV, van)");
            System.out.println(" 7) List all vehicles");
            System.out.println(" 8) Add a vehicle");
            System.out.println(" 9) Remove a vehicle");
            System.out.println(" 0) Exit\n");
            System.out.print("Please enter the number that corresponds to your selection: ");

            try {
                choice = scnr.nextInt();
                scnr.nextLine();

                switch (choice) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetByAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 0:
                        System.out.println("\nExiting...\nSee you soon :)");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid choice. Please try again.\n");
                scnr.next();
            }
        } while (true);
    }

    private static void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            String vehicleInfo = String.format(
                    "VIN: %d, Year: %d, Make: %s, Model: %s, Type: %s, Color: %s, Odometer: %d, Price: $%.2f",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
            System.out.println(vehicleInfo);
        }
    }

    private static void processGetByPriceRequest() {}

    private static void processGetByMakeModelRequest() {}

    private static void processGetByYearRequest() {}

    private static void processGetByColorRequest() {}

    private static void processGetByMileageRequest() {}

    private static void processGetByVehicleTypeRequest() {}

    private static void processGetByAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private static void processAddVehicleRequest() {}

    private static void processRemoveVehicleRequest() {}
}