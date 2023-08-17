//이름 전화번호

import java.util.Scanner;

class Phone {
    private String name;
    private String tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}

public class PhoneBook {
    // 전화번호를 잔뜩 모아놓은 뭔가....
    // has-a (다른 클래스를 품고 있을때...)
    private Phone phoneList[];
    private Scanner scanner;

    public PhoneBook() {
        scanner = new Scanner(System.in);
    }

    public void write() {
        System.out.println("몇명을 입력하시겠습니까?");
        int total = scanner.nextInt();
        phoneList = new Phone[total];
        for (int i = 0; i < total; i++) {
            System.out.println("이름과 전화번호를 입력하시오.");
            String name = scanner.next();
            String tel = scanner.next();
            phoneList[i] = new Phone(name, tel);
        }
        System.out.println(total + "명의 전화번호부가 입력되었습니다.");
    }

    // 전화번호 찾기 search(이름) 전화번호
    public String search(String name) {
        // 이름에 맞는 전화번호 꺼내기...
        for (int i = 0; i < phoneList.length; i++) {
            if (phoneList[i].getName().equals(name)) {
                return phoneList[i].getTel();
            }
        }
        return null;
    }

    public void run() {
        while (true) {
            System.out.println("이름을 쓰세요.");
            String name = scanner.next();
            if (name.equals("그만"))
                break;
            String tel = search(name);
            if (tel == null) {
                System.out.println("없는 사람입니다. 다시 입력해 주세요.");
            } else {
                System.out.println(name + "님의 전화번호는 " + tel + "입니다.");
            }
        }
    }
}
