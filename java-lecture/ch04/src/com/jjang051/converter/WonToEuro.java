package com.jjang051.converter;

public class WonToEuro extends Converter {
    WonToEuro(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public double convert(double src) {
        return src / ratio;
    }

    @Override
    public String destString() {
        return "유로";
    }

    @Override
    public String srcString() {
        return "원";
    }

    public static void main(String[] args) {
        new WonToEuro(1450).run();
    }
}
