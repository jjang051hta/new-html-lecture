class MoneyConverter {
    private static double rate;

    public static double getRate() {
        return rate;
    }

    public static void setRate(double _rate) {
        rate = _rate;
    }

    static double toDollar(double won) {
        return won / rate;
    }

    static double toWon(double dollar) {
        return dollar * rate;
    }

}

public class ChangeMoney {
    public static void main(String[] args) {
        MoneyConverter.setRate(1380);
        double won = MoneyConverter.toDollar(240000000);
        double dollar = MoneyConverter.toWon(1000);
        System.out.printf("십만원은 달러로 환전하면 = %f%n", won);
        System.out.printf("천달러는 원으로 환전하면 = %f", dollar);
    }
}
