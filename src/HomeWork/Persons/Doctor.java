package HomeWork.Persons;

import HomeWork.Enum.DoctorClassification;
import HomeWork.Enum.Gender;

public class Doctor extends MedicalEmployee {

    private int expirience;

    public Doctor(String name, String surname, String patronymic, int age, Gender gender, int id, DoctorClassification doctorClassification, int expirience) {
        super(name, surname, patronymic, age, gender, id, doctorClassification);
        this.expirience = expirience;

    }

    /**Так как наследуемся от абстрактного класса,то обятзательно нужно реализовать все методы этого класса
     * Реализуем метод appointTreatment. Только врач,который привязан к пациенту может назначить лечение.*/
    @Override
    public void appointTreatment(Patient patient, String treatment) {
        if(patient.getDoctorId() == this.getId()) {
            System.out.println(this.getName() + "(" + getDoctorClassification() + ")" + "назначает лечение" + treatment + " для " + patient.getName() + " " + patient.getSurname());
            patient.setTreatment(treatment);
        }
        else System.out.println("К сожалению это не ваш лечащий врач");
    }
    /**Мы выполняем лечение <=> когда пациенту было поставлено лечение. Иначе,мы просто выводим,что ему еще не поставили лечение*/
    @Override
    public void doTreatment(Patient patient) {
        if (patient.getTreatment() != null) {
            System.out.println(this.getName() + " " + this.getSurname()+" "+this.getPatronymic() +" id:"+this.getId()+ this.getDoctorClassification()+" выполняет лечение над пациентом:" );
            System.out.println(patient.getName() + " " + patient.getSurname()+ " "+ patient.getPatronymic()+" под номером "+patient.getId());
        }
        else System.out.println("У этого патицента нет лечения");


    }

    @Override
    public String toString() {
        return "Doctor{ " +super.toString()+",expirience"+expirience;
    }
}
