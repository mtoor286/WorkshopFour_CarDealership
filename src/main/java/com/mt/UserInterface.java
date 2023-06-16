package com.mt;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// UserInterface will be responsible for all output to the screen, reading of
// user input, and "dispatching" of the commands to the Dealership as needed.
// (ex:  when the user selects "List all Vehicles", UserInterface would call the
// appropriate Dealership method and then display the vehicles it returns.)
public class UserInterface {
    private Dealership dealership;
    static Scanner scanner = new Scanner(System.in);
    private DealershipFileManager dealershipFileManager = new DealershipFileManager();


    private void init(){
        // Load dealership and inventory from a file
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() throws FileNotFoundException {
        init();
        System.out.println("Current Dealership: " + this.dealership);
        String input;

        do {
            System.out.println("Please enter a command: ");
            System.out.println("\t1: Get all vehicles");
            System.out.println("\t2: Get all vehicles by price");
            System.out.println("\t3: Add a Vehicle");
            System.out.println("\t4: Remove a Vehicle");
            System.out.println("\t5: Exit");

            System.out.print("Command: ");
            input = scanner.nextLine();

            switch(input){
                case "1":
                    processGetAllVehiclesRequest();
                    break;
                case "2":
                    processGetVehiclesByPriceRequest();
                    break;
                case "3":
                    processAddVehicleRequest();
                    break;
                case "4":
                    processRemoveVehicleRequest();
                    break;
                case "5":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Command not found, please try again");
            }

        } while(!input.equalsIgnoreCase("5"));
    }

    public void processGetVehiclesByPriceRequest() {
        System.out.println("Please give me a min price");
        float minValue = scanner.nextFloat();
        System.out.println("Please give me a max price");
        float maxValue = scanner.nextFloat();

        ArrayList<Vehicle> vehiclesByPrice = this.dealership.getVehiclesByPrice(minValue, maxValue);
        for(Vehicle vehicle: vehiclesByPrice){
            System.out.println(vehicle);
        }

        scanner.nextLine();
    }

    public void processGetVehiclesByMakeModelRequest() {


    }

    public void processGetVehiclesByYearRequest() {

    }

    public void processGetVehiclesByColorRequest() {

        File file = new File("./src/main/java/com/mt/availableCarsAtDealership.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the color of car that you want: ");
        String Color = scanner.next();

        try {
            scanner = new Scanner(file);

            System.out.println("All the cars with this color at our dealership: ");
            System.out.println("< Vin | Year | Make | Model | Color | Type | Mileage | Price >");

            while (scanner.hasNext()) {

                final String linesFromFile = scanner.nextLine();
                if (linesFromFile.contains(Color)) {

                    System.out.println(linesFromFile);
                }

            }
            System.out.println("End of the List.");

        } catch (IOException e) {
            System.out.println("No car was found with this color, please try again.");
            e.printStackTrace();
        }
    }

    public void processGetVehiclesByMileageRequest() {

    }

    public void processGetVehiclesByTypeRequest() {

        File file = new File("./src/main/java/com/mt/availableCarsAtDealership.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of the car your looking for(Car, Truck, SUV, Van): ");
        String Type = scanner.next();

        try {
            scanner = new Scanner(file);

            System.out.println("All the cars under this type at our dealership: ");
            System.out.println("< Vin | Year | Make | Model | Color | Type | Mileage | Price >");

            while (scanner.hasNext()) {

                final String linesFromFile = scanner.nextLine();
                if (linesFromFile.contains(Type)) {

                    System.out.println(linesFromFile);
                }

            }
            System.out.println("End of the List.");

        } catch (IOException e) {
            System.out.println("No car was found under this type, please try again.");
            e.printStackTrace();
        }

    }

    public void processGetAllVehiclesRequest() throws FileNotFoundException {

        Scanner input = new Scanner(new File("./src/main/java/com/mt/availableCarsAtDealership.txt"));

        System.out.println("< Vin | Year | Make | Model | Color | Type | Mileage | Price >");

        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
        System.out.println("End of the list.");
    }

    public void processAddVehicleRequest(){
//        int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price
        System.out.println("Enter the vin number of the car(5-digit): ");
        String Vin = scanner.nextLine();

        System.out.println("Enter the year of the car: ");
        String Year = scanner.nextLine();

        System.out.println("Enter the make of the car: ");
        String Make = scanner.nextLine();

        System.out.println("Enter the model of the car: ");
        String Model = scanner.nextLine();

        System.out.println("Enter the color of the car: ");
        String Color = scanner.nextLine();

        System.out.println("Enter the mileage of the car: ");
        String Mileage = scanner.nextLine();

        System.out.println("Enter the price of the car: ");
        String Price = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("./src/main/java/com/mt/availableCarsAtDealership.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Vin + "|" + Year + "|" + Make + "|" + Model + "|" + Color + "|" + Mileage + "|" + Price);
            System.out.println("New car has benn added to the dealership.");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Adding new car was not successful.");
            e.printStackTrace();
        }
    }

    public void processRemoveVehicleRequest(){
        // Display all vehicles and allow user to select one to remove
        System.out.println("Remove");
    }
}
