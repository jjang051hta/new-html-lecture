public class TV {
    private String brand;
    private int size;
    private int year;

    public TV(String brand, int size, int year) {
        this.brand = brand;
        this.size = size;
        this.year = year;
    }

    public void show() {
        System.out.printf("%s에서 만든 %d년형 %d인치 TV입니다.", this.brand, this.year, this.size);
    }

    public static void main(String[] args) {
        TV myTv = new TV("LG", 64, 2023);
        myTv.show();
    }
}
