package com.goJek.manager;

public interface ParkingLot {

    public void create(int slotNo);

    public void park(String regNo, String color);

    public void leave(Integer slotNo);

    public void status();

    public void getRegistrationNumberWithColor(String color);

    public void getSlotNumbersForColor(String color);

    public void getSlotNumberForRegNo(String regNo);

}
