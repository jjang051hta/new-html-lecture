public class AA {
    public static void registerDutyMonth(String name, int month) {
        if (month < 1 || month > 12) {
            throw new IndexOutOfBoundsException(
                    "우리 %s씨는 1년에 몇 달이 있는지 아직 못 배웠나봐?"
                            .formatted(name));
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
    }

    public static void main(String[] args) {
        try {
            registerDutyMonth("장성호", 13);
        } catch (IndexOutOfBoundsException e) {
            // TODO: handle exception
            // e.printStackTrace();
            System.out.println();
            System.out.println("없는 달입니다.");
        }
    }
}