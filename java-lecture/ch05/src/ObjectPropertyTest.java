class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "나는 (" + x + "," + y + ") 점 입니다.";
    }

    public boolean equals(Object object) {
        Point point = (Point) object;
        if (x == point.x && y == point.y) {
            return true;
        } else {

            return false;
        }

    }

}

public class ObjectPropertyTest {
    public static void main(String[] args) {
        Point point = new Point(10, 10);
        Point point02 = new Point(10, 10);
        System.out.println(point.getClass().getName());
        System.out.println(point.hashCode());
        System.out.println(point02.hashCode());
        System.out.println(point.toString());
        System.out.println(point02.toString());
        System.out.println(point.equals(point02));
    }
}
