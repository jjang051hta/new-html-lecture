import java.util.Vector;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

}

public class VectorTest {
    public static void main(String[] args) {
        // List(순서가 있고 중복 허용) / Set(순서 없음, 중복 불가) / Map(키 값 키는 중복 불가, 값은 중복 허용)
        Vector<Integer> vec = new Vector<>();
        vec.add(100);
        vec.add(200);
        vec.add(300);
        // System.out.println(vec.get(0));
        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.get(i));
        }
        for (int i : vec) {
            System.out.println(i);
        }
        //
        String animals = "호랑이,사자,토끼,거북이"; // split(",")
        // String animalArray[] = animals.split(",");
        Vector<String> stringVec = new Vector<>();
        for (String animal : animals.split(",")) {
            stringVec.add(animal);
        }
        stringVec.add("캥거루");
        stringVec.add("캥거루");
        stringVec.remove(stringVec.size() - 1);
        // stringVec.removeAllElements();
        for (int i = 0; i < stringVec.size(); i++) {
            System.out.println(stringVec.get(i));
        }
        System.out.println(stringVec.size() + "/" + stringVec.capacity());
        // animals를 쪼개서 stringVec에 넣고 싶다.

        Vector<Point> pointVec = new Vector<>();
        pointVec.add(new Point(10, 10));
        pointVec.add(new Point(20, 20));
        pointVec.add(new Point(30, 30));
        pointVec.add(0, new Point(40, 40));
        Point point01 = pointVec.get(0);
        System.out.println(point01);
    }
}
