package com.borschevskydenis.lab4.Persons;

import java.lang.String;

import com.borschevskydenis.lab4.Enum.Status;
import com.borschevskydenis.lab4.IdentificationException;
import com.borschevskydenis.lab4.Request;
import com.borschevskydenis.lab4.Room;

import java.util.ArrayList;

public class Administrator extends Human  {
    private static int nextId = 1;
    private final int id;

    public Administrator(String name, String surname, String patronymic) throws IdentificationException {
        super(name, surname, patronymic);
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public void reviewApplication(Request request, ArrayList<Room> rooms) {
        for (Room i : rooms) {
            if (request.getNumberOfPlaces() == i.getNumberOfPlaces() && request.getApartmentClass() == i.getApartmentClass() && i.getStayTime()==null) {
                request.setStatus(Status.CONFIRMED);
                request.setRoomId(i.getNumber());
                break;
            }
        }
        if (request.getStatus() != Status.CONFIRMED) {
            request.setStatus(Status.REJECTED);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nId администратора: " + id + "\n";
    }
}
