package com.goJek;

import com.goJek.manager.CommandManager;
import com.goJek.manager.ParkingLot;
import com.goJek.manager.ParkingLotImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParkingLotImplTest {

    CommandManager commandManager = new CommandManager();
    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(consoleOutput));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testCreateParkingLot() {
        commandManager.executeCommand("create_parking_lot 6", new ParkingLotImpl());
        String expected = "Created a parking lot with 6 slots\n";
        assertEquals(expected,consoleOutput.toString() );
    }

    @Test
    public void testPark() {
        ParkingLot parkingLot = new ParkingLotImpl();
        commandManager.executeCommand("create_parking_lot 6", parkingLot);
        commandManager.executeCommand("park ka-25-mb-0812 red", parkingLot);
        String expected = "Created a parking lot with 6 slots\nAllocated slot number: 1\n";
        assertEquals(expected,consoleOutput.toString() );
    }

    @Test
    public void testLeave() {
        ParkingLot parkingLot = new ParkingLotImpl();
        commandManager.executeCommand("create_parking_lot 6", parkingLot);
        commandManager.executeCommand("park ka-25-mb-0812 red", parkingLot);
        commandManager.executeCommand("leave 1", parkingLot);
        String expected = "Created a parking lot with 6 slots\nAllocated slot number: 1\nSlot number 1 is free\n";
        assertEquals(expected,consoleOutput.toString() );

    }

    @Test
    public void testStatus() {
        ParkingLot parkingLot = new ParkingLotImpl();
        commandManager.executeCommand("create_parking_lot 6", parkingLot);
        commandManager.executeCommand("park ka-25-mb-0812 red", parkingLot);
        commandManager.executeCommand("status", parkingLot);
        String expected = "Created a parking lot with 6 slots\nAllocated slot number: 1\nSlot No\tRegistration No\tColour\n" +
                "1\tka-25-mb-0812\tred\n";
        assertEquals(expected,consoleOutput.toString() );
    }


}
