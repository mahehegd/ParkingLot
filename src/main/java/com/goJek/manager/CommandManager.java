package com.goJek.manager;

import java.util.HashMap;

public class CommandManager {

    public void executeCommand(String commandLine, ParkingLot park){
        String[] command = commandLine.split(" ");
        switch(command[0]){
            case "create_parking_lot":
                park.create(Integer.parseInt(command[1]));
                break;

            case "park" :
                park.park(command[1], command[2]);
                break;
            case "leave" :
                park.leave(Integer.parseInt(command[1]));
                break;
            case "status":
                park.status();
                break;
            case "registration_numbers_for_cars_with_colour" :
                park.getRegistrationNumberWithColor(command[1]);
                break;
            case "slot_numbers_for_cars_with_colour":
                park.getSlotNumbersForColor(command[1]);
                break;
            case "slot_number_for_registration_number":
                park.getSlotNumberForRegNo(command[1]);
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}
