public class Book {
    // title, author
    String title;
    String author;

    Book() {
        this("", "");
    }

    Book(String title) {
        this(title, "작자미상");
        // this.title = title;
        // author = "작자미상";
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        new Book();
        Book javaJungSuk = new Book("자바의 정석", "남궁 성");
        System.out.println(javaJungSuk.title + " / " + javaJungSuk.author);
        Book simchung = new Book("심청전");
        System.out.printf("%s / %s", simchung.title, simchung.author);
    }
}
