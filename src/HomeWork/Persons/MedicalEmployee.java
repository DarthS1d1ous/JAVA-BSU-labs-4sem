package HomeWork.Persons;

import HomeWork.Enum.DoctorClassification;
import HomeWork.Enum.Gender;

public abstract class MedicalEmployee extends Human {
    private int id;
    private DoctorClassification doctorClassification;
    public MedicalEmployee(String name, String surname, String patronymic, int age, Gender gender, int id, DoctorClassification doctorClassification) {
        super(name, surname, patronymic, age, gender);
        this.id = id;
        this.doctorClassification = doctorClassification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorClassification getDoctorClassification() {
        return doctorClassification;
    }

    public void setDoctorClassification(DoctorClassification doctorClassification) {
        this.doctorClassification = doctorClassification;
    }

    /**Абстрактный метод назначит лечение*/
    public abstract void appointTreatment(Patient patient, String treatment);
    /**Абстрактный метод выполнить лечение*/
    public abstract void doTreatment(Patient patient);

    @Override
    public String toString() {
        return super.toString() +",Id:"+id + ",DoctorClassification:"+doctorClassification;
    }
}
