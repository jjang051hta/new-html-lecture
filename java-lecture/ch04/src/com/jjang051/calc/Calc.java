
package com.jjang051.calc;

public abstract class Calc {
    public int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    abstract int calculate();
}