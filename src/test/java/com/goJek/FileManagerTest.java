package com.goJek;

import com.goJek.manager.FileManager;
import com.goJek.manager.ParkingLotImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class FileManagerTest {
    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    public ExpectedException exception = ExpectedException.none();
    FileManager fileManager = new FileManager();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(consoleOutput));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testFileInput() {
        String expected = "Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n";
        fileManager.executeCommandFromFile("src/main/resources/unitTestInput.txt", new ParkingLotImpl());
        assertEquals(expected, consoleOutput.toString());
    }

    @Test
    public void expectFileNotFoundException() {
        fileManager.executeCommandFromFile("src/main/resources/nonExistentFile.txt", new ParkingLotImpl());
        exception.expect(FileNotFoundException.class);
    }
}
