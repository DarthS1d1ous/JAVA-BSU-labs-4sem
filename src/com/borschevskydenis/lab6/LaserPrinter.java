package com.borschevskydenis.lab6;

import java.awt.*;

public class LaserPrinter extends Printer {
    private Toner powder = new Toner();

    public class Toner extends Cartridge {
        public Toner(Double state){
            super(Color.CYAN, state);
        }
        public Toner(){
            super(Color.CYAN, 100.);
        }
    }

    @Override
    public String toString(){
        return "Запас порошка: " + powder.getState() ;
    }

    public void ChangeState(Cartridge toner,String text){
        toner.setState(toner.getState()-text.length()*0.0005);
    }

    @Override
    public void printText(String text) {
        ChangeState(powder,text);
        System.out.println(text);

    }

}
