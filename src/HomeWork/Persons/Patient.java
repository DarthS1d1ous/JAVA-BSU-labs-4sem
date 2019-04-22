package HomeWork.Persons;

import HomeWork.Enum.Gender;
import HomeWork.Enum.PatientCondition;

public class Patient extends Human {
    private int id;
    private String adress;
    private long number;
    private String diagnosis;
    private int medicalNumberCards;
    private int doctorId;
    private PatientCondition condition;
    private String treatment;

    public Patient(String name, String surname, String patronymic, int age, Gender gender, int id, String adress, long number, String diagnosis, int medicalNumberCards, PatientCondition condition) {
        super(name, surname, patronymic, age, gender);
        this.id = id;
        this.adress = adress;
        this.number = number;
        this.diagnosis = diagnosis;
        this.medicalNumberCards = medicalNumberCards;
        this.condition = condition;
        this.doctorId = 0;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getMedicalNumberCards() {
        return medicalNumberCards;
    }

    public void setMedicalNumberCards(int medicalNumberCards) {
        this.medicalNumberCards = medicalNumberCards;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public PatientCondition getCondition() {
        return condition;
    }

    public void setCondition(PatientCondition condition) {
        this.condition = condition;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }


    @Override
    public String toString() {
        return "Patient{ "+super.toString() +
                "Id:" +id +
                ",Adress:"+ adress +
                ",Number:"+number +
                ",Diagnosis:" + diagnosis +
                ",MedicalCard:"+medicalNumberCards+
                ",Doctor:"+doctorId+
                ",Condition:"+condition +
                ",Treatment:"+treatment+" }";

    }
}
