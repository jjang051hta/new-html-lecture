package com.jjang051.calc;

import java.util.Scanner;

// Add , Multiply, Subtract, Divide 의 클래스 만들기...

class Add extends Calc {
    @Override
    int calculate() {
        return a + b;
    }
}

class Multiply extends Calc {
    @Override
    int calculate() {
        return a * b;
    }
}

class Subtract extends Calc {
    @Override
    int calculate() {
        return a - b;
    }
}

class Divide extends Calc {
    @Override
    int calculate() {
        return a / b;
    }
}

public class MyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 두개를 입력하고 연산자를 입력하시오.");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();
        Calc exp = null;
        int result = 0;
        switch (operator) {
            case "+":
                exp = new Add();
                break;
            case "-":
                exp = new Subtract();
                break;
            case "*":
                exp = new Multiply();
                break;
            case "/":
                exp = new Divide();
                break;
        }
        exp.setValue(a, b);
        result = exp.calculate();
        System.out.println(result);
    }
}
