package com.goJek.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileManager extends CommandManager {

    public void executeCommandFromFile(String file, ParkingLot park){
        File commandFile = new File(file);
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(commandFile));
            String line = "";

            while((line = bufferedReader.readLine())!= null) {
                executeCommand(line , park);
            }

        }catch(Exception e){
            System.out.println("Error handling file ");
            e.printStackTrace();
        }
    }
}
