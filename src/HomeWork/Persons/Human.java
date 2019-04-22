package HomeWork.Persons;

import HomeWork.Enum.Gender;

public abstract class Human {
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private Gender gender;

    public Human(String name, String surname, String patronymic, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  "Name:" + name +
                ",Surname:"+ surname +
                ",Patronym:" + patronymic +
                ",Age:"+ age +
                ",Gender:" + gender;
    }
}
