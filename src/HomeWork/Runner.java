package HomeWork;

import HomeWork.Enum.DoctorClassification;
import HomeWork.Enum.Gender;
import HomeWork.Enum.PatientCondition;
import HomeWork.Persons.Doctor;
import HomeWork.Persons.Patient;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        /** Создаем докоторов*/
        Doctor firstDoctor = new Doctor("Nikolay","Zuec","Vasilevich",34, Gender.MALE,1, DoctorClassification.ALLERGIST,10);
        Doctor secondDoctor = new Doctor("Artem","Kazak","Vasilevich",28,Gender.MALE,2,DoctorClassification.DENTIST,9);
        Doctor thirdDoctor = new Doctor("Alex","Gomol","Ivanov",37,Gender.MALE,3,DoctorClassification.AUDIOLOGIST,8);
        Doctor fourDoctor = new Doctor("Katy","Ivkova","Alexandrovna",25,Gender.FEMALE,4,DoctorClassification.DERMATOLOGIST,7);
        Doctor fivesDoctor = new Doctor("Nastya","Smurago","Dmitievna",26,Gender.FEMALE,5,DoctorClassification.CARDIOLOGIST,6);
        Doctor nurse = new Doctor("Tanya","Vasha","Pavlovna",26,Gender.FEMALE,5,DoctorClassification.NURSE,10);
        /** Создаем список,где будут хранится доктора*/
        List<Doctor> doctors = new ArrayList<>();
        /** Добавляем докторов в этот список*/
        doctors.add(firstDoctor);
        doctors.add(secondDoctor);
        doctors.add(thirdDoctor);
        doctors.add(fourDoctor);
        doctors.add(fivesDoctor);
        doctors.add(nurse);
        /** Создаем пациентов*/
        Patient firstPatient = new Patient("Kostya","Pupkin","Alexandrovich",22,Gender.MALE,1,"Pushkina",257641,"Cough",123, PatientCondition.AWEREGE);
        Patient secondPatient = new Patient("Masha","Gnedko","Dmitry",24,Gender.FEMALE,2,"Kalatushkina",461235,"Head ache",127,PatientCondition.BAD);
        Patient thirdPatient = new Patient("Andrey","Pupkin","Alexandrovich",26,Gender.MALE,3,"Ekarrad",1548645,"Teath",173,PatientCondition.BAD);
        Patient fourPatient = new Patient("Jenya","Pupkin","Ivanoc",22,Gender.MALE,4,"Gempdse",45646,"Cough",185,PatientCondition.GOOD);
        Patient fivesPatient = new Patient("Vika","Pupkin","Alexandrovich",22,Gender.FEMALE,5,"Lenina",45612,"Leg",193,PatientCondition.AWEREGE);
        /** Создаем список пациентов, где будут хранится наши боьные*/
        List<Patient> patients = new ArrayList<>();
        /** Добавляем больных в список*/
        patients.add(firstPatient);
        patients.add(secondPatient);
        patients.add(thirdPatient);
        patients.add(fourPatient);
        patients.add(fivesPatient);
        /** Создаем сущность больница*/
        Hospital hospital = new Hospital("Madrid Ambulance",doctors,patients);

        System.out.println("Добро пожаловать в " +hospital.getName());
        /** Больница назначает каждому пациенту своего врача*/
        Hospital.setDoctorToPatient(firstDoctor,firstPatient);
        Hospital.setDoctorToPatient(secondDoctor,secondPatient);
        Hospital.setDoctorToPatient(thirdDoctor,thirdPatient);
        Hospital.setDoctorToPatient(fourDoctor,fivesPatient);
        /**Пациенту под номером один, его врач назначает лечение */
        firstDoctor.appointTreatment(firstPatient,"Лечения таблетками");
        /**Медсестра выполняет указания врача*/
        nurse.doTreatment(firstPatient);
        /**Пациенту 3 и 4 резко стало хорошо,и они захотели поехать домой*/
        thirdPatient.setCondition(PatientCondition.WELL);
        fourPatient.setCondition(PatientCondition.WELL);
        /**Поэтому добрая больница Мадрида кикает их. В общем,мы прощаемся с ними и желаем больше не посещать наше заведение!*/
        hospital.dischargeFromHospital();
        /**Ну и в итоге мы просто выводим всех калек нашего заведения. Конец)*/
        hospital.printAllPatientsInfo();




    }
}
