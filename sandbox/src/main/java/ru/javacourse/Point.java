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

    // функция для вычисления
    public double distance(Point p1, Point p2) {
        return Math.sqrt((Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2)));
    }
}
