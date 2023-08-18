package com.jjang051.shape;

abstract class Shape {
    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {

    @Override
    public void draw() {
        System.out.println("Rect");
    }

}

class Weapon {
    int fire() {
        return 1;
    }
}

class Canon extends Weapon {
    int fire() {
        return 10;
    }
}

public class MethodOverrideTest {
    public static void main(String[] args) {
        // new Shape().draw();
        // new Line().draw();
        // Shape line = new Line();
        // line.draw();
        Weapon weapon;
        weapon = new Weapon();
        System.out.printf("기본무기의 파워는 %d", weapon.fire());
        weapon = new Canon();
        System.out.printf("캐논의 파워는 %d", weapon.fire());
    }
}
