package com.mt;

import java.util.ArrayList;

// Dealership will hold information about the dealership (name, address, …)
// and maintain a list of vehicles.  Since it has the list of vehicles,
// it will also have the methods that search the list for matching vehicles
// as well as add/remove vehicles.
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(float min, float max) {
        ArrayList<Vehicle> vehiclesToDisplay = new ArrayList<>();

        for(Vehicle vehicle: this.inventory){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                vehiclesToDisplay.add(vehicle);
            }
        }

        return vehiclesToDisplay;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByYear(int year) {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){

    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
