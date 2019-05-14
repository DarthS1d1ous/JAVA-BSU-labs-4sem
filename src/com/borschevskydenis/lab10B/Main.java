package com.borschevskydenis.lab10B;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество отрезков");
        int N = in.nextInt();
        ArrayList<Segment> segments = generate(N);
        System.out.println("Все отрезки");
        System.out.println(segments);
        TreeMap<Double, Double> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i != j && intersection(segments.get(i), segments.get(j)) != null) {
                    Point point = intersection(segments.get(i), segments.get(j));
                    treeMap.put(point.getX(),point.getY());
                }
            }
        }

        if(treeMap.size()!=0) {
            System.out.println("Все точки пересечения");
            System.out.println(treeMap);
            System.out.println("Точка с минимальной абсциссой");
            System.out.println(treeMap.firstKey());
        }
        else System.out.println("Никакие отрезки не пересекаются");
    }

    public static ArrayList<Segment> generate(int quantity) {
        Random random = new Random();
        ArrayList<Segment> segments = new ArrayList<Segment>();
        for (int i = 0; i < quantity; i++) {
            segments.add(new Segment(new Point(-100 + random.nextInt(201), -100 + random.nextInt(201)), new Point(-100 + random.nextInt(201), -100 + random.nextInt(201))));
        }
        return segments;
    }

    public static Point intersection(Segment first, Segment second) {

        if (is_intersection(first.getFirst(), first.getSecond(), second.getFirst(), second.getSecond())) {

            double A1 = (first.getFirst().getY() - first.getSecond().getY()) / (first.getFirst().getX() - first.getSecond().getX());
            double A2 = (second.getFirst().getY() - second.getSecond().getY()) / (second.getFirst().getX() - second.getSecond().getX());

            double b1 = first.getFirst().getY() - A1 * first.getFirst().getX();
            double b2 = second.getFirst().getY() - A2 * second.getFirst().getX();

            double X = (b2-b1)/(A1-A2);
            double Y = A2*X + b2;

            return new Point(X,Y);
        } else return null;
    }

    public static boolean is_intersection(Point p1, Point p2, Point p3, Point p4) {
        double d1 = determinant(p3, p4, p1);
        double d2 = determinant(p3, p4, p2);
        double d3 = determinant(p1, p2, p3);
        double d4 = determinant(p1, p2, p4);

        if (d1 == d2 && d2 == d3 && d3 == d4 && d4 == 0) {
            if ((p3.getX() - p1.getX()) * (p4.getX() - p1.getX()) + (p3.getY() - p1.getY()) * (p4.getY() - p1.getY()) <= 0 || (p3.getX() - p2.getX()) * (p4.getX() - p2.getX()) + (
                    p3.getY() - p2.getY()) * (p4.getY() - p2.getY()) <= 0 || (p1.getX() - p3.getX()) * (p2.getX() - p3.getX()) + (p1.getY() - p3.getY()) * (
                    p2.getY() - p3.getY()) <= 0 || (p1.getX() - p4.getX()) * (p2.getX() - p4.getX()) + (p1.getY() - p4.getY()) * (p2.getY() - p4.getY()) <= 0) {
                return true;
            } else return false;
        } else if (d1 * d2 <= 0 && d3 * d4 <= 0)
            return true;
        else return false;
    }

    public static double determinant(Point p1, Point p2, Point p) {
        double d = (p2.getX() - p1.getX()) * (p.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p.getX() - p1.getX());
        return d;
    }
}

class Segment {
    private Point first;
    private Point second;

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Segment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "{" + first +
                "," + second +
                '}';
    }
}

class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }
}
