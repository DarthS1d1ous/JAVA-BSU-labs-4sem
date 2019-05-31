package com.borschevskydenis.lab11;

import java.util.ArrayList;
import java.util.List;

public class ParkingTest {
    public static void main (String ... args){
        int carQty = 10, stationLimit = 7;
        Parking parking = new Parking(stationLimit);
        List<Thread> carList = createCars(carQty, parking);
        waitCars( carList);


        System.out.println(carList);
        System.out.println(parking.getVisitedCars());
    }

    public static List<Thread> createCars( int carQty, Parking station){
        List<Thread> carList = new ArrayList<>();
        for( int carNumber = 0; carNumber < carQty; carNumber++){
            int waitTime = (int) (Math.random()* 25);
            int startTime = (int) (Math.random()* 5);
            int parkedTime = (int) (Math.random()*25);
            carList.add(new CarThread(waitTime, startTime, parkedTime, station));
        }

        return carList;
    }

    public static void waitCars(List<Thread> threads){
        try{
            for(Thread thread: threads)
                thread.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
