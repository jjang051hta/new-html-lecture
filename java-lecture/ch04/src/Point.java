class Point {
    // 필드 / 속성
    private int x, y;

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() {
        System.out.printf("(%d,%d)", x, y);
    }

    // public static void main(String[] args) {
    // Point point = new Point();
    // point.set(30, 40);
    // point.showPoint();
    // }
}
