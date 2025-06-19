package com.example.demo.util;

public class BitCalculator {

    private int value = 0;
    private String mode = "standard";
    private boolean isSigned = true;

    public BitCalculator(int initialValue) {
        this.value = initialValue;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int add(int num) {
        return this.value + num;
    }

    public int subtract(int num) {
        return this.value - num;
    }

    public int multiply(int num) {
        return this.value * num;
    }

    public int divide(int num) {
        if (num == 0) throw new ArithmeticException("Divide by zero");
        return this.value / num;
    }

    public int modulus(int num) {
        return this.value % num;
    }

    public int bitwiseAnd(int num) {
        return this.value & num;
    }

    public int bitwiseOr(int num) {
        return this.value | num;
    }

    public int bitwiseXor(int num) {
        return this.value ^ num;
    }

    public int leftShift(int bits) {
        return this.value << bits;
    }

    public int rightShift(int bits) {
        return this.value >> bits;
    }

    public int unsignedRightShift(int bits) {
        return this.value >>> bits;
    }

    public boolean isEven() {
        return this.value % 2 == 0;
    }

    public boolean isNegative() {
        return this.value < 0;
    }

    public void reset() {
        this.value = 0;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isSignedMode() {
        return isSigned;
    }

    public void toggleSigned() {
        this.isSigned = !this.isSigned;
    }

    @Override
    public String toString() {
        return "BitCalculator{" +
                "value=" + value +
                ", mode='" + mode + '\'' +
                ", isSigned=" + isSigned +
                '}';
    }
}
