package ru.javacourse;

public class MyFirstProgram {
    // запускаемый класс, вывод результата
    public static void main(String[] args) {
        // keyword new - creation of object with a specified type
        Point p1 = new Point(2,-3);
        Point p2 = new Point(-2,0);
        System.out.println(p1.distance(p2));

        Point p3 = new Point(1,1);
        Point p4 = new Point(1,1);
        System.out.println(p3.distance(p4));

        Point p5 = new Point(2,3);
        Point p6 = new Point(3,4);
        System.out.println(p5.distance(p6));
    }

}