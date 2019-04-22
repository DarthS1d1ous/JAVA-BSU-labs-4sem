package HomeWork;


import HomeWork.Enum.PatientCondition;
import HomeWork.Persons.Doctor;
import HomeWork.Persons.Patient;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name, List<Doctor> doctors, List<Patient> patients) {
        this.name = name;
        this.doctors = doctors;
        this.patients = patients;
    }

    public String getName() {
        return name;
    }

    public void printDoctorInfo ()
    {
        System.out.println("Введите id доктора");
        Scanner in = new Scanner(System.in);
        int currentId = in.nextInt();
        for (Doctor doctor : this.doctors) {
            if (doctor.getId() == currentId) {
                System.out.println(doctor);
            }
        }
        in.close();
    }
    public void printPatientInfo ()
    {
        System.out.println("Введите id пациента");
        Scanner in = new Scanner(System.in);
      //  int currentId = in.nextInt();
        for (Patient patient : patients) {
      //      if (patient.getId() == currentId) {
                System.out.println(patient);
        //    }
        }
        //in.close();
    }

    public void printAllDoctorsInfo()
    {
        doctors.forEach(System.out::println);
    }

    public void printAllPatientsInfo()
    {
        patients.forEach(System.out::println);
    }

    public static void setDoctorToPatient (Doctor doctor,Patient patient)
    {
        System.out.println("Пациенту " +patient.getName() + " " + patient.getSurname() + " " + patient.getPatronymic() + " под номером " + patient.getId());
        System.out.printf(" назначен доктор " + doctor.getName() + " " + doctor.getSurname()+ " " + doctor.getPatronymic() + " под номером " +doctor.getId());
        System.out.println();

        patient.setDoctorId(doctor.getId());
    }

    public void dischargeFromHospital ()
    {
        Predicate <Patient> predicate = o -> o.getCondition()== PatientCondition.WELL;
        patients.removeIf(predicate);
    }

}
