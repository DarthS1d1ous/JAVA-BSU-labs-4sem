package com.borschevskydenis.lab4;

public class RoomInformationException extends Exception {
    private Exception roomInformation;

    public Exception getRoomInformation() {
        return roomInformation;
    }

    public RoomInformationException() {
        super();
    }

    public RoomInformationException(String message) {
        super(message);
    }

    public RoomInformationException(String message, Exception e) {
        super(message);
        roomInformation = e;
    }
}
