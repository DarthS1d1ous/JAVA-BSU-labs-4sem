package com.borschevskydenis.lab6;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        String text = "Текст текст текст текст";
        printer.printText(text);
        printer.setMode(Mode.COLORED);
        printer.printText(text);
        System.out.println(printer);
        System.out.println("////////////////////////////////////////////");
        LaserPrinter laserPrinter = new LaserPrinter();
        laserPrinter.printText(text);
        System.out.println(laserPrinter);
    }
}
