package com.borschevskydenis.lab4.Persons;

import com.borschevskydenis.lab4.Enum.ApartmentClass;
import com.borschevskydenis.lab4.IdentificationException;
import com.borschevskydenis.lab4.Request;
import com.borschevskydenis.lab4.Enum.Status;
import com.borschevskydenis.lab4.Enum.Payment;
import com.borschevskydenis.lab4.Room;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Client extends Human {
    private static int nextId = 1;
    private final int id;
    private BigInteger phone;
    private BigInteger creditCardNumber;
    private int requestId;
    private int roomId;

    public Client(String name, String surname, String patronymic, String phone, String creditCardNumber) throws IdentificationException {
        super(name, surname, patronymic);
        this.id = nextId;
        nextId++;
        try {
            this.phone = new BigInteger(phone);
            this.creditCardNumber = new BigInteger(creditCardNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.requestId = 0;
        this.roomId = 0;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public BigInteger getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public void setCreditCardNumber(BigInteger creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nId клиента: " + id +
                "\nНомер телефона: " + phone +
                "\nНомер заявки: " + requestId +
                "\nНомер апартаментов: " + roomId + "\n";
    }

    public Request submitYourApplication(int numberOfPlaces, ApartmentClass apartmentClass, LocalDate stayTime) {
        Request request = new Request(Status.PROCESSED, Payment.NOTPAID, numberOfPlaces, apartmentClass, stayTime);
        requestId = request.getId();
        request.setClientNumber(this.id);
        return request;
    }

    public void Payment(Request request ,ArrayList<Room> rooms) {
        if (requestId == request.getId()) {
            if (request.getStatus() == Status.CONFIRMED) {
                request.setPayment(Payment.PAID);
                roomId = request.getRoomId();
                for (Room room : rooms) {
                    if(request.getRoomId() == room.getNumber())
                        room.setStayTime(request.getStayTime());
                }

            }
        }
    }
}
