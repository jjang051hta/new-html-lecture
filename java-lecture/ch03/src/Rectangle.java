public class Rectangle {
    // int width, height
    // int getArea
    int width;
    int height;

    // 생성자 함수()
    Rectangle() {

    }

    int getArea() {
        return width * height;
    }

    public static void main(String[] args) {
        Rectangle rect01 = new Rectangle();
        rect01.width = 10;
        rect01.height = 30;
        int area = rect01.getArea();
        System.out.println("사각형의 면적은 " + area + "입니다.");

    }
}
