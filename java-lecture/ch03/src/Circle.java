

public class Circle {
    int radius;
    String name;

    // 생성자를 여러개 만들 수 있다. overload
    Circle() {
        radius = 1;
        name = "";
    }

    Circle(int radius) {
        this.radius = radius;
        name = "";
    }

    Circle(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    // 반지름만 가지는 생성자 만들어 보기...
    double getArea() {
        return radius * radius * 3.14;
    }

    public static void main(String[] args) {
        Circle domino = new Circle();
        domino.name = "도미노";
        double dominoArea = domino.getArea();
        System.out.println(domino.name + "의 면적은 " + dominoArea);

        Circle pizzaHut = new Circle(20, "피자헛");
        double pizzaHutArea = pizzaHut.getArea();
        System.out.println(pizzaHut.name + "의 면적은 " + pizzaHutArea);

        Circle obj01 = new Circle(1);
        Circle obj02 = new Circle(2);
        Circle obj03;
        obj03 = obj02;
        obj01 = obj02;
        System.out.printf("obj01의 반지름은===%d%n", obj01.radius);
        System.out.printf("obj02의 반지름은===%d", obj02.radius);

        Circle c01 = new Circle(1);
        Circle c02 = new Circle(2);
        Circle c03 = new Circle(3);
        Circle c04 = new Circle(4);
        Circle c05 = new Circle(5);
        // int intArray[] = new int[5];
        Circle circles[] = new Circle[5];
        for (int i = 0; i < 5; i++) {
            circles[i] = new Circle((i + 1) * 10);
        }

        System.out.println(circles[0].radius);
        System.out.println(circles[1].radius);

    }
}
