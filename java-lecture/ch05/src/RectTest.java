class Rect {
    private int width;
    private int height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        Rect rect = (Rect) obj;
        if (width * height == rect.width * rect.height) {
            return true;
        }
        return false;
    }

    // 면적이 같으면 같은 사걱형으로 보기...
}

public class RectTest {
    public static void main(String[] args) {
        Rect rect01 = new Rect(10, 10);
        Rect rect02 = new Rect(20, 5);
        System.out.println(rect01.equals(rect02));
    }
}
