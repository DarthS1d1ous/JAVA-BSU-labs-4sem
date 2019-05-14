package com.borschevskydenis.lab4;

import com.borschevskydenis.lab4.Enum.ApartmentClass;
import com.borschevskydenis.lab4.Enum.Payment;
import com.borschevskydenis.lab4.Enum.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Request implements Serializable {
    private static int nextId = 1;
    private final int id;
    private Status status;
    private Payment payment;
    private int numberOfPlaces;
    private ApartmentClass apartmentClass;
    private LocalDate stayTime;
    private int clientNumber;
    private int roomId;

    public Request(Status status, Payment payment, int numberOfPlaces, ApartmentClass apartmentClass, LocalDate stayTime){
        this.id = nextId;
        nextId++;
        try {

            if(numberOfPlaces==0 || apartmentClass==null || stayTime==null)
                throw new RequestException("Не удалось оформить заявку!");

            this.status=status;
            this.payment=payment;
            this.numberOfPlaces = numberOfPlaces;
            this.apartmentClass = apartmentClass;
            this.stayTime=stayTime;
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
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

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Номер заявки: " + id +
                "\nНомер клиента: " + clientNumber +
                "\nСтатус заявки: " + status +
                "\nОплата заявки: " + payment +
                "\nНомер апартаментов: " + roomId +
                "\nНа апартаменты с чистом комнат: " + numberOfPlaces +
                "\nНа апартаменты класса: " + apartmentClass +
                "\nДо: " + stayTime + "\n";
    }
}
