package com.jjang051.converter;

import java.util.Scanner;

public class WonToDollar extends Converter {
    public WonToDollar(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public double convert(double src) {
        return src / ratio;
    }

    @Override
    public String srcString() {
        return "원";
    }

    @Override
    public String destString() {
        return "달러";
    }

    public static void main(String[] args) {
        WonToDollar wonToDollar = new WonToDollar(1380);
        wonToDollar.run();
    }
}
