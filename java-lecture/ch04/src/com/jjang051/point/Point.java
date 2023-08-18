package com.jjang051.point;

import java.util.Scanner;

public class Point {
    private int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void showPoint() {
        System.out.printf("(%d,%d)", x, y);
    }
}
