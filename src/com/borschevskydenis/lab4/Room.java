package com.borschevskydenis.lab4;

import com.borschevskydenis.lab4.Enum.ApartmentClass;

import java.time.LocalDate;
import java.util.Date;

public class Room {
    private static int nextNumber = 1;
    private int number;
    private int numberOfPlaces;
    private ApartmentClass apartmentClass;
    private LocalDate stayTime;

    public Room() {

    }

    public Room(int numberOfPlaces, ApartmentClass apartmentClass) {
        try {
            if (numberOfPlaces == 0 || apartmentClass == null)
                throw new RoomInformationException("Не удалось инициализировать комнату!");
            this.number = nextNumber;
            nextNumber++;
            this.numberOfPlaces = numberOfPlaces;
            this.apartmentClass = apartmentClass;
            this.stayTime = null;
        } catch (RoomInformationException e) {
            e.printStackTrace();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setApartmentClass(ApartmentClass apartmentClass) {
        this.apartmentClass = apartmentClass;
    }

    public ApartmentClass getApartmentClass() {
        return apartmentClass;
    }

    public void setStayTime(LocalDate stayTime) {
        this.stayTime = stayTime;
    }

    public LocalDate getStayTime() {
        return stayTime;
    }

    @Override
    public String toString() {
        return "Номер апартаментов: " + number +
                "\nЧисто комнат: " + numberOfPlaces +
                "\nКласс апартаментов: " + apartmentClass +
                "\nСданы до: " + stayTime + "\n";
    }
}
