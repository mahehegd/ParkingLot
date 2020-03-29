package com.goJek;

import com.goJek.inputReader.ConsoleReader;
import com.goJek.manager.CommandManager;
import com.goJek.manager.FileManager;
import com.goJek.manager.ParkingLot;
import com.goJek.manager.ParkingLotImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Runner {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLotImpl();

        if(args.length == 0) {
            System.out.println("Interactive console activated");
            System.out.println("Proceed with command");
            CommandManager commandManager = new CommandManager();

            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String commandLine = bufferedReader.readLine();

                while(!commandLine.equalsIgnoreCase("exit")){
                    commandManager.executeCommand(commandLine, parkingLot);
                    commandLine = bufferedReader.readLine();
                }
                System.out.println("Closing the interactive session");
            } catch(Exception e){
                System.out.println("Application crashed unexpectedly");
                e.printStackTrace();
            }
        }
        if(args.length == 1){
            //System.out.println("Handling commands from file " + args[0]);
            FileManager fileManager = new FileManager();
            fileManager.executeCommandFromFile(args[0] , parkingLot);

        }
    }
}
