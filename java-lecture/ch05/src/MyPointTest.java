class MyPoint {
    private int x, y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point (" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        MyPoint myPoint = (MyPoint) obj;
        if (x == myPoint.x && y == myPoint.y)
            return true;
        return false;
    }
}

public class MyPointTest {
    public static void main(String[] args) {
        MyPoint myPoint = new MyPoint(3, 3);
        MyPoint myPoint02 = new MyPoint(3, 3);
        System.out.println(myPoint.toString());
        System.out.println(myPoint.equals(myPoint02));
        System.out.println(myPoint.hashCode());
        System.out.println(myPoint02.hashCode());
    }
}