package com.jjang051.tv;

public class ColorTV extends TV {
    private int nColor;

    public ColorTV(int size, int nColor) {
        super(size);
        this.nColor = nColor;
    }

    public int getnColor() {
        return nColor;
    }

    void showInfo() {
        System.out.printf("%d인치에 %d 컬러 TV입니다", this.getSize(), this.getnColor());
    }

    // public static void main(String[] args) {
    // new ColorTV(64, 256);
    // }

}
