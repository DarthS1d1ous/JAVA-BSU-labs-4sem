package com.borschevskydenis.lab3;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Collator;
import java.util.Arrays;

public class Customer {
    private static int nextId = 1;

    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private BigInteger phone;
    private final int id;
    private BigInteger creditCardNumber;
    private BigInteger bankAccountNumber;

    public Customer(String firstName, String lastName, String patronymic, String address, String phone, String creditCardNumber, String bankAccountNumber) {
        this.id = nextId;
        nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone =  new BigInteger(phone);
        this.creditCardNumber =  new BigInteger(creditCardNumber);
        this.bankAccountNumber = new BigInteger(bankAccountNumber);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public BigInteger getCreditCardNumber() {
        return creditCardNumber;
    }

    public BigInteger getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public void setCreditCardNumber(BigInteger creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setBankAccountNumber(BigInteger bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

   @Override public String toString() {
        return "Id:" + this.id + "\nFull name: " + this.firstName + " " + this.lastName + " " + this.patronymic + "\nAddress: " + this.address + "\nPhone number: " + this.phone + "\n";
    }

    public static Customer[] ObjectsArray(int quantity) {
        Customer[] customers = new Customer[quantity]   ;
        return customers;
    }

    public static void alphabeticalSorting(Customer[] customers) {
        String[] array = new String[customers.length];
        for (int i = 0; i < customers.length; i++)
            array[i] = customers[i].getFirstName();
        for (int i = customers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swap(customers, j, j + 1);
                }
        }
        for (int i = 0; i < customers.length; i++)
            array[i] = customers[i].getLastName();
        for (int i = customers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (customers[j].getFirstName().compareTo(customers[j + 1].getFirstName()) == 0) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        swap(array, j, j + 1);
                        swap(customers, j, j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < customers.length; i++)
            array[i] = customers[i].getPatronymic();
        for (int i = customers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (customers[j].getFirstName().compareTo(customers[j + 1].getFirstName()) == 0) {
                    if (customers[j].getLastName().compareTo(customers[j + 1].getLastName()) == 0) {
                        if (array[j].compareTo(array[j + 1]) > 0) {
                            swap(array, j, j + 1);
                            swap(customers, j, j + 1);
                        }
                    }
                }
            }
        }

    }

    public static void outputByCreditCardNumber(Customer[] customers, String first, String second) {
        BigInteger bottom = new BigInteger(first);
        BigInteger top = new BigInteger(second);
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getCreditCardNumber().compareTo(bottom)>0 && customers[i].getCreditCardNumber().compareTo(top)<0 ){
                System.out.println(customers[i].toString());
            }
        }
    }

    public static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void main(String[] args) {
//        Customer Man = new Customer("Денис", "Борщевский", "Александрович", "Гагарино 8 кв.21", "3752595885370", "7859000021914300", "5182300004651653000000");
//        System.out.println(Man.toString());
        Customer[] mans = Customer.ObjectsArray(3);
        mans[0] = new Customer("Денис", "Борщевский", "Олександрович", "Гагарино 8 кв.21", "375295885370", "7859000089635100", "5182300004651653000000");
        mans[1] = new Customer("Паша", "Борщевский", "Александрович", "Гагарино 8 кв.21", "375295637145", "5859000067184300", "5185617482547653000000");
        mans[2] = new Customer("Денис", "Борщевский", "Александрович", "Гагарино 8 кв.21", "375296719021", "9859000083516200", "5182561834263853000000");
        for (Customer e : mans)
            System.out.println(e.toString());
        Customer.alphabeticalSorting(mans);
        System.out.println("///////////////////////////////////////////////////////////////");
        for (Customer e : mans)
            System.out.println(e.toString());
        System.out.println("///////////////////////////////////////////////////////////////");
        Customer.outputByCreditCardNumber(mans, "5859000067184299", "8859000067184300");
    }
}
