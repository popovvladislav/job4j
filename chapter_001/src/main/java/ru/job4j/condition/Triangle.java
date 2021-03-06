package ru.job4j.condition;

/**
 * Вычисление площади треугольника.
 * @author Popov vladislav (mailto:navodbmd.2@mail.ru).
 */

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    /**
     * Создание конструктора.
     * @param a точка 1.
     * @param b точка 2.
     * @param c точка 3.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * @param ab Длина стороны 1.
     * @param ac Длина стороны 2.
     * @param bc Длина стороны 3.
     * @return Полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод вычисления площади треугольника.
     * @return  Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return false.
     */
    public boolean exist(double ab, double ac, double bc) {
        return !(ab >= bc + ac | ab == 0 | bc >= ab + ac | bc == 0 | ac >= bc + ab | ac == 0);
    }
}
