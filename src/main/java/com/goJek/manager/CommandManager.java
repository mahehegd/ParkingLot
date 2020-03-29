package com.goJek.manager;

import java.util.HashMap;

public class CommandManager {

    public void executeCommand(String commandLine, ParkingLot park){
        String[] command = commandLine.split(" ");
        switch(command[0]){
            case "create_parking_lot":
                park.create(Integer.parseInt(command[1]));

            case "park" :
                park.park(command[1], command[2]);
            case "leave" :
                park.leave(Integer.parseInt(command[1]));
            case "status":
                park.status();
            case "registration_numbers_for_cars_with_colour" :
                park.getRegistrationNumberWithColor(command[1]);
            case "slot_numbers_for_cars_with_colour":
                park.getSlotNumbersForColor(command[1]);
            case "slot_number_for_registration_number":
                park.getSlotNumberForRegNo(command[1]);
            default:
                System.out.println("Invalid command");

        }
    }
}
