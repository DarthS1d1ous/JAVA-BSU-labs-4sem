package com.borschevskydenis.lab11;

public class CarThread extends Thread {
    private int waitTime;
    private int startTime;
    private int parkedTime;
    private Parking parking;
    private static int threadQty = 0;
    private int number = ++threadQty;

    public int getWaitTime(){ return waitTime;}

    public CarThread( int waitTime, int startTime, int parkedTime, Parking parking){
        this.waitTime= waitTime;
        this.startTime = startTime;
        this.parkedTime = parkedTime;
        this.parking = parking;
        start();
    }


    @Override
    public void run(){
        try{
            Thread.sleep(startTime*1000);
            boolean isAccepted = parking.accept(this);
            if(isAccepted){
                Thread.sleep(parkedTime*1000);
                System.out.println(this + "отбыл");
                parking.release(this);
            } else{
                System.out.println( this + "can't wait more");
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString(){
        return "Thread number: " + number
                + " waitTime: " + waitTime
                + " startTime:" + startTime
                + " parkedTime:" + parkedTime
                + "\n";
    }
}
