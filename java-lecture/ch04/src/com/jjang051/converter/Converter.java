package com.jjang051.converter;

import java.util.Scanner;

abstract class Converter {
    abstract public double convert(double src);

    abstract public String srcString();

    abstract public String destString();

    public double ratio;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s를 %s로 변환해 드리겠습니다.", this.srcString(), this.destString());
        System.out.printf("%s를 입력하세요.", this.srcString());
        double inputMoney = scanner.nextDouble();
        double changedMoney = convert(inputMoney);
        System.out.printf("변환값은 %f%s입니다.", changedMoney, this.destString());

    }
}