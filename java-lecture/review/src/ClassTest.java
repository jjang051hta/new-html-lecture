
// int

import java.util.ArrayList;
import java.util.List;

class Circle {
    // 속성(properties)과 메서드(methods)
    private int radius;
    private String name;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Circle() {
        name = "";
        radius = 1;
    }

    Circle(String name, int radius) {
        this.name = name;
        this.radius = radius;
    }

    Circle(int radius) {
        this.radius = radius;
    }

    static void show() {
        System.out.println("나는 static 메서드");
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }
}

class ColorCircle extends Circle {
    private String color;

    ColorCircle() {

    }

    ColorCircle(String name, int radius, String color) {
        super(name, radius);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

class Goo extends ColorCircle {

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

// 추상클래스
// 인터페이스

// 포유류 곰(사냥), 토끼, 박쥐(사냥, 날아다니기)
// 파충류 거북(수영), 날도마뱀(날아다님)
// 조류 독수리, 펭귄

abstract class Calculator {
    public abstract int add(int a, int b);
}

class SamsungCalc extends Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

}

// 부모 타입을 바꾸지 않아도 됨...
class LGCalc extends Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

}

public class ClassTest {
    public static void main(String[] args) {
        // primitive type 은 복사
        // reference type 은 참조
        Circle circle = new Circle();
        circle.setName("도미노");
        circle.setRadius(20);
        System.out.println(circle.getArea());
        // Circle.show();
        Circle copyCircle = circle;
        copyCircle.setName("피자 헛");
        System.out.println(circle.getName());
        System.out.println(copyCircle.getName());

        ColorCircle colorCircle = new ColorCircle("컬러 도미노", 30, "red");
        Goo goo = new Goo();
        if (circle instanceof Circle) {
            System.out.println("나는 원");
        }
        if (colorCircle instanceof Circle) {
            System.out.println("나는 원");
        }
        if (goo instanceof Circle) {
            System.out.println("나도 원인가?");
        }
        List<String> list = new ArrayList<>();
        Calculator Calc = new LGCalc();
        System.out.println(Calc.add(10, 20));
    }
}
