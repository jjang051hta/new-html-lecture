class Circle {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle(" + x + "," + y + "," + radius + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Circle circle = (Circle) obj;
        if (circle.x == x && circle.y == y)
            return true;
        return false;
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle circle01 = new Circle(3, 4, 10);
        Circle circle02 = new Circle(3, 4, 20);
        System.out.println(circle01.toString());
        System.out.println(circle01.equals(circle02));
    }
}
