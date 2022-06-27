package ru.javacourse;
// класс для определения точки на плоскости
public class Point {

    public double x;
    public double y;
    // конструктор класса
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
//        перывый x - атрибут, второй - параметр
//        or: ... Point(double abscissa, ...) { x = abscissa; ...}
    }

    // метод для вычисления
    public double distance(Point p2) {
        return Math.sqrt((Math.pow((this.x - p2.x), 2) + Math.pow((this.y - p2.y), 2)));
    }
}
