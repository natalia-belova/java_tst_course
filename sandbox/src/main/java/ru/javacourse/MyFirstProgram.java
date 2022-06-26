package ru.javacourse;

public class MyFirstProgram {
    // запускаемый класс, вывод результата
    public static void main(String[] args) {
        // keyword new - creation of object with a specified type
        Point p1 = new Point(2,-3);
        Point p2 = new Point(-2,0);
        System.out.println("The distance between specified points is " + distance(p1, p2));
    }

    // функция для вычисления
    public static double distance(Point p1, Point p2) {
        return Math.sqrt((Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2)));
    }
}