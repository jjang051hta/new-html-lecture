public class ColorPoint extends Point {
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void showColorPoint() {
        showPoint();
        System.out.printf("색상은 %s", color);
    }

}
