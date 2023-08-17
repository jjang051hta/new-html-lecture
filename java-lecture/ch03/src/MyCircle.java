public class MyCircle {
    private double x, y;
    private int radius;

    public MyCircle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public void show() {
        System.out.printf("x좌표 : %f,y좌표 : %f 반지름은 %d이고 면적은 %f %n", x, y, radius, getArea());
    }

    public static void main(String[] args) {
        // MyCircle myCircle = new MyCircle(10, 10, 5);
        // myCircle.show();
        MyCircle myCircles[] = new MyCircle[3];
        for (int i = 0; i < 3; i++) {
            double x = Math.random() * 200 + 100;
            double y = Math.random() * 200 + 100;
            int radius = (int) (Math.random() * 40 + 10);
            myCircles[i] = new MyCircle(x, y, radius);
        }
        int big = 0;
        for (int i = 1; i < myCircles.length; i++) {
            if (myCircles[i].getArea() > myCircles[big].getArea()) {
                big = i;
            }
        }
        myCircles[0].show();
        myCircles[1].show();
        myCircles[2].show();
        myCircles[big].show();
    }
}
