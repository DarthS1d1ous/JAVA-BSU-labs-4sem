package com.borschevskydenis.lab4.Persons;

import com.borschevskydenis.lab4.IdentificationException;

public abstract class Human {
    private String name;
    private String surname;
    private String patronymic;

    public Human(String name, String surname, String patronymic) throws IdentificationException{
        if (name==null && surname ==null && patronymic == null) {
            throw new IdentificationException("Не удалось идентифицировать человека");
        }
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return  "Имя:" + name +
                "\nФамилия:"+ surname +
                "\nОтчество:" + patronymic;
    }
}
