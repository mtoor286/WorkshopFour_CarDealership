package com.mt;

public class Main {
    public static void main(String[] args) {

        Dealership dealership = new Dealership(
                "RoCars",
                "124 Kingston Rd",
                "980-123-1234");

        UserInterface userInterface = new UserInterface();
        userInterface.processAddVehicleRequest();


    }

}