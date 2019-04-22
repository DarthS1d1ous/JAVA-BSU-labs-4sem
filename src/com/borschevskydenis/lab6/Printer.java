package com.borschevskydenis.lab6;

import java.awt.*;

interface PrintingDevice {

    void printText(String text);
}

public class Printer implements PrintingDevice {

    private Cartridge black = new Cartridge();
    private Cartridge colored = new Cartridge(Color.RED);
    private Mode mode;

    public class Cartridge {
        private Color color;
        private Double state;

        public Cartridge() {
            this.color = Color.BLACK;
            this.state = 100.0;
        }

        public Cartridge(Color color) {
            this.color = color;
            this.state = 100.0;
        }

        public Cartridge(Color color, Double state) {
            this.color = color;
            this.state = state;
        }

        public Cartridge(Double state) {
            this.state = state;
            this.color = Color.BLACK;
        }



        public void setState(Double state) {
            this.state = state;
        }

        public Double getState() {
            return state;
        }

    }


    @Override
    public String toString(){
        return "Режим: " + black.color.toString() +
                "\nЗапас краски: " + black.getState() +
                "\nРежим: " + colored.color.toString() +
                "\nЗапас краски: " + colored.getState();
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void ChangeState(Cartridge cartridge,String text){
//        cartridge.setState(cartridge.getState()-text.length()*0.0001);
        cartridge.state-=text.length()*0.0001;
    }

    @Override
    public void printText(String text) {
        if (mode == Mode.BLACK) {
            System.out.println(black.color.toString());
            System.out.println(text);
            ChangeState(black,text);
        }
        if (mode == Mode.COLORED) {
            System.out.println(colored.color.toString());
            System.out.println(text);
            ChangeState(colored,text);
        }
        else System.out.println("Select mode!");
    }
}
