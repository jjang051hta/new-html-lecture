
class Mamal {
    public void feedMilk() {
        System.out.println("젖먹이다");
    }
}

interface Huntable {
    void hunt();
}

interface Flyable {
    void fly();
}

class Bird {
    public void makeEgg() {
        System.out.println("알낳는다.");
    }
}

class Reptiles {
    public boolean isColdBlood() {
        return true;
    }
}

class PolarBear extends Mamal implements Huntable, Swimmable {

    @Override
    public void swim() {
        System.out.println("나는 북극해를 수영으로 헤집고 다녀요");
    }

    @Override
    public void hunt() {
        System.out.println("나는 물범을 잡아먹어요.");
    }

}

interface Swimmable {
    // public static final String ability = "수영능력자";
    String ability = "수영능력자";

    void swim();
}

// 설계상의 개념... 유연하게 사용가능...

class Eagle extends Bird implements Flyable, Huntable {

    @Override
    public void fly() {
        System.out.println("하늘을 날 수 있다.");
    }

    @Override
    public void hunt() {
        System.out.println("나는 사냥해서 먹고 살아요.");
    }
}

// 거북이 만들고 파충류, 수영하고, 사냥한다.
class Tutle extends Reptiles implements Swimmable, Huntable {

    @Override
    public void hunt() {

    }

    @Override
    public void swim() {

    }

}

class Penguin extends Bird implements Swimmable, Huntable {

    @Override
    public void hunt() {

    }

    @Override
    public void swim() {

    }

}

public class InterfaceTest {
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        eagle.makeEgg();
        PolarBear polarBear = new PolarBear();
        polarBear.swim();
        System.out.println(polarBear.ability);

        Huntable huntable = new PolarBear();
        huntable.hunt();

    }
}
