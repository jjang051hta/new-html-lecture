public class Song {
    private String title;
    private String artist;
    private String country;
    private int year;

    public Song() {
    }

    public Song(String title, String artist, String country, int year) {
        this.title = title;
        this.artist = artist;
        this.country = country;
        this.year = year;
    }

    public void show() {
        System.out.printf("%d년도에 출시된 %s 국적의 %s가 부른 %s", this.year, this.country, this.artist, this.title);
    }

    public static void main(String[] args) {
        Song eta = new Song("ETA", "뉴진스", "한국", 2023);
        eta.show();
    }
}
