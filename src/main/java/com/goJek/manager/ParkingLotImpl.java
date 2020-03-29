package com.goJek.manager;

import com.goJek.model.Car;

import java.util.*;

public class ParkingLotImpl implements ParkingLot {
    //List to track open slots
    List<Integer> openSlots = new ArrayList<Integer>();

    public int MAXIMUM_SLOTS = 0;

    //HashMaps to store data
    public Map<Integer, Car> slotToCarMap = new TreeMap<Integer, Car>();
    public HashMap<String, Integer> regNoToSlotMap = new HashMap<String, Integer>();
    public HashMap<String, List<String>> colorToRegNoListMap = new HashMap<String, List<String>>();

    public void create(int slotNo) {
        this.MAXIMUM_SLOTS = slotNo;
        for(int i = 1 ; i <= slotNo ; i++ ) {
            openSlots.add(i);
        }
        System.out.println("Created a parking lot with " + slotNo + " slots" );
    }

    public void park(String regNo, String color) {
        if(this.MAXIMUM_SLOTS == 0){
            System.out.println("Parking lot is not created , retry with command \"create_parking_lot <number of slots>\" ");
            return;
        }

        if(regNo.isEmpty() || regNo == null || color.isEmpty() || color ==null) {
            System.out.println("Command for park : \"Park <registration Number> <color> \"");
            return;
        }
        else {

            if(this.slotToCarMap.size() == MAXIMUM_SLOTS) {
                System.out.println("Sorry, parking lot is full");
                return;
            }
            else {
                final Car car = new Car(regNo, color);
                Collections.sort(openSlots);
                Integer slot = openSlots.get(0);

                slotToCarMap.put(slot, car);
                regNoToSlotMap.put(regNo, slot);

                if(colorToRegNoListMap.containsKey(color))
                    colorToRegNoListMap.get(color).add(car.getRegNo());
                else
                    colorToRegNoListMap.put(color, new ArrayList<String>()
                         {{ add(car.getRegNo()); }});
                System.out.println("Allocated slot number: " + slot);
                openSlots.remove(slot);
            }
        }
    }

    public void leave(Integer slotNo) {
        if(MAXIMUM_SLOTS == 0){
            System.out.println("Parking lot is not created , retry with command \"create_parking_lot <number of slots>\" ");
            return;
        }
        if(openSlots.contains(slotNo)){
            System.out.println("Parking Slot is already empty");
            return;
        }

        if(slotToCarMap.containsKey(slotNo)) {
            Car car = slotToCarMap.get(slotNo);
            String color = car.getColor();
            String regNo = car.getRegNo();

            regNoToSlotMap.remove(regNo);
            colorToRegNoListMap.get(color).remove(regNo);
            slotToCarMap.remove(slotNo);
            System.out.println("Slot number " + slotNo + " is free");
            openSlots.add(slotNo);
        }
        else {
            System.out.println("Encountered Error, Maps not in Sync!!, please restart by exiting and creating new Parking lot");
        }

    }

    public void status() {
        if(slotToCarMap.size() == 0) {
            System.out.println("Parking Lot is empty");
            return;
        }
        System.out.println("Slot No\tRegistration No\tColour");

        for(Map.Entry<Integer, Car> entry : slotToCarMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue().getRegNo() + "\t" + entry.getValue().getColor());
        }
    }

    public void getRegistrationNumberWithColor(String color) {
        try{
            List<String> regNo = colorToRegNoListMap.get(color);

            if(regNo.size() ==0) throw new  RuntimeException();

            for(int i = 0 ; i < regNo.size(); i++ ) {
                System.out.print(regNo.get(i) );
                if(i != regNo.size() -1) System.out.print(", ");
            }
            System.out.print("\n");
        } catch (Exception e) {
            System.out.println("No cars found with color " + color );
        }
    }

    public void getSlotNumbersForColor(String color) {
        List<Integer> slotNumbers = new ArrayList<Integer>();
        try{
            List<String> regNos = colorToRegNoListMap.get(color);

            if(regNos.size() == 0) throw new RuntimeException();

            for(String regNo : regNos) {
                slotNumbers.add(regNoToSlotMap.get(regNo));
            }
            Collections.sort(slotNumbers);

            for(int i = 0 ; i < slotNumbers.size(); i++ ) {
                System.out.print(slotNumbers.get(i) );
                if(i != slotNumbers.size() -1) System.out.print(", ");
            }
            System.out.print("\n");
        } catch (Exception e){
            System.out.println("No car of " + color + " found");
        }
    }

    public void getSlotNumberForRegNo(String regNo) {
        try{
            if(regNoToSlotMap.containsKey(regNo))
            System.out.println(regNoToSlotMap.get(regNo));
            else System.out.println("Not found");
        } catch(Exception e){
            System.out.println("Error locating slot for Reg number");
            e.printStackTrace();
        }
    }
}
