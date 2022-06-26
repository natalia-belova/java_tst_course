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
}
