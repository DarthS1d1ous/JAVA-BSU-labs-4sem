package com.borschevskydenis.lab4;

import com.borschevskydenis.lab4.Enum.ApartmentClass;
import com.borschevskydenis.lab4.Persons.Administrator;
import com.borschevskydenis.lab4.Persons.Client;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        /** Создаём список слиентов */
//        ArrayList<Client> clients = new ArrayList<>();
//        Client firstClient = new Client("Денис", "Борщевский", "Александрович", "375295885370", "7859000089635100");
//        Client secondClient = new Client("Паша", "Купрас", "Михайлович", "375295637145", "5859000067184300");
//        Client thirdClient = new Client("Евгений", "Кухарчик", "Альбертович", "375296719021", "9859000083516200");
//        Client fourClient = new Client("Cемён", "Смолик", "Михайлович", "375296718411", "9839000091515200");
//        clients.add(firstClient);
//        clients.add(secondClient);
//        clients.add(thirdClient);
//        clients.add(fourClient);
//        /** Создаём список апартаментов */
//        ArrayList<Room> rooms = new ArrayList<>();
//        Room room1 = new Room(4, ApartmentClass.B);
//        Room room2 = new Room(2, ApartmentClass.A);
//        Room room3 = new Room(1, ApartmentClass.A);
//        Room room4 = new Room(4, ApartmentClass.LUXURY);
//        Room room5 = new Room(5, ApartmentClass.C);
//        Room room6 = new Room(6, ApartmentClass.LUXURY);
//        Room room7 = new Room(3, ApartmentClass.B);
//        rooms.add(room1);
//        rooms.add(room2);
//        rooms.add(room3);
//        rooms.add(room4);
//        rooms.add(room5);
//        rooms.add(room6);
//        rooms.add(room7);
//        /** Создаём администратора */
//        Administrator administrator = new Administrator("Александр", "Серафинович", "Александрович");
//        /** Создаём заявки для каждого клиента */
//        ArrayList<Request> requests = new ArrayList<>();
//        Request forFirst = firstClient.submitYourApplication(2, ApartmentClass.A, LocalDate.of(2019,03,19));
//        Request forSecond = secondClient.submitYourApplication(3, ApartmentClass.LUXURY, LocalDate.of(2019,03,26));
//        Request forThird = thirdClient.submitYourApplication(3, ApartmentClass.C, LocalDate.of(2019,04,16));
//        Request forFour = fourClient.submitYourApplication(6, ApartmentClass.LUXURY, LocalDate.of(2019,03,23));
//        requests.add(forFirst);
//        requests.add(forSecond);
//        requests.add(forThird);
//        requests.add(forFour);
//        /** Администратор рассматривает заявки */
//        administrator.reviewApplication(forFirst, rooms);
//        administrator.reviewApplication(forSecond, rooms);
//        administrator.reviewApplication(forThird, rooms);
//        administrator.reviewApplication(forFour, rooms);
//        /** Если администратор одобрил заявку, то клиент её оплачивает*/
//        firstClient.Payment(forFirst);
//        secondClient.Payment(forSecond);
//        thirdClient.Payment(forThird);
//        fourClient.Payment(forFour);
//        /** Вывод всех заявок и клиентов на экран */
//        requests.forEach(System.out::println);
//        clients.forEach(System.out::println);
//        System.out.println("////////////////////////////////////");

        /** Создаём список слиентов */
        ArrayList<Client> clients = new ArrayList<>();
        Client firstClient = null;
        try {
            firstClient = new Client(null, null, null, "375295885370", "7859000089635100");
            clients.add(firstClient);
        } catch (IdentificationException e) {
            e.printStackTrace();
        }
        Client secondClient = null;
        try {
            secondClient = new Client("Паша", "Купрас", "Михайлович", "375295637145", "5859000067184300");
            clients.add(secondClient);
        } catch (IdentificationException e) {
            e.printStackTrace();
        }
        Client thirdClient = null;
        try {
            thirdClient = new Client("Евгений", "Кухарчик", "Альбертович", "375296719021", "9859000083516200");
            clients.add(thirdClient);
        } catch (IdentificationException e) {
            e.printStackTrace();
        }
        Client fourClient = null;
        try {
            fourClient = new Client("Cемён", "Смолик", "Михайлович", "375296718411", "9839000091515200");
            clients.add(fourClient);
        } catch (IdentificationException e) {
            e.printStackTrace();
        }

        /** Создаём администратора */
        Administrator administrator = null;
        try {
            administrator = new Administrator("Александр", "Серафинович", "Александрович");
        } catch (IdentificationException e) {
            e.printStackTrace();
        }

        /** Создаём заявки для каждого клиента */
        ArrayList<Request> requests = new ArrayList<>();
        Request forFirst = null;
        if (firstClient != null) {
            forFirst = firstClient.submitYourApplication(2, ApartmentClass.A, LocalDate.of(2019, 03, 19));
            requests.add(forFirst);
        }
        Request forSecond = null;
        if (secondClient != null) {
            forSecond = secondClient.submitYourApplication(3, ApartmentClass.LUXURY, LocalDate.of(2019, 03, 26));
            requests.add(forSecond);
        }
        Request forThird = null;
        if (thirdClient != null) {
            forThird = thirdClient.submitYourApplication(3, ApartmentClass.C, LocalDate.of(2019, 04, 16));
            requests.add(forThird);
        }
        Request forFour = null;
        if (fourClient != null) {
            forFour = fourClient.submitYourApplication(6, ApartmentClass.LUXURY, LocalDate.of(2019, 03, 23));
            requests.add(forFour);
        }


        /** Создаём список апартаментов */
        ArrayList<Room> rooms = new ArrayList<>();
        Room room1 = new Room(4, ApartmentClass.B);
        Room room2 = new Room(0, ApartmentClass.A);
        Room room3 = new Room(1, ApartmentClass.A);
        Room room4 = new Room(4, ApartmentClass.LUXURY);
        Room room5 = new Room(5, null);
        Room room6 = new Room(6, ApartmentClass.LUXURY);
        Room room7 = new Room(3, ApartmentClass.B);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);

        /** Администратор рассматривает заявки */
        if (forFirst != null && administrator != null) {
            administrator.reviewApplication(forFirst, rooms);
        }
        if (forSecond != null && administrator != null) {
            administrator.reviewApplication(forSecond, rooms);
        }
        if (forThird != null && administrator != null) {
            administrator.reviewApplication(forThird, rooms);
        }
        if (forFour != null && administrator != null) {
            administrator.reviewApplication(forFour, rooms);
        }

        /** Если администратор одобрил заявку, то клиент её оплачивает*/
        if (firstClient != null && forFirst != null) {
            firstClient.Payment(forFirst, rooms);
        }
        if (secondClient != null && forSecond != null) {
            secondClient.Payment(forSecond, rooms);
        }
        if (thirdClient != null && forThird != null) {
            thirdClient.Payment(forThird, rooms);
        }
        if (fourClient != null && forFour != null) {
            fourClient.Payment(forFour, rooms);
        }
        /** Вывод всех заявок и клиентов на экран */
        requests.forEach(System.out::println);
        System.out.println("////////////////////////////////////");
        clients.forEach(System.out::println);
        System.out.println("////////////////////////////////////");
        rooms.forEach(System.out::println);
    }
}
