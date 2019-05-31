package com.borschevskydenis.lab11;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
public class SimpleGUI extends JFrame{

    public SimpleGUI() {
        super("Вращение четырёхугольника вокруг своего центра тяжести");
        this.setBounds(800,350,500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleGUI jFrame=new SimpleGUI();
        Timer tm= new Timer(50, new ActionListener(){
            int i=0;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr=(Graphics2D)jFrame.getRootPane().getGraphics();
                jFrame.update(gr);
                gr.translate(150, 150);
                GeneralPath path=new GeneralPath();
                path.append(new Polygon(new int[]{-50,250,250,-50},new int[]{20,20,100,100},4),true);
                int x=(250-50)/2,y=(100+20)/2;
                gr.drawOval(x,y,1,1);
                AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.05,x,y);
                gr.transform(tranforms);
                gr.draw(path);

            }});
        tm.start();
    }
}