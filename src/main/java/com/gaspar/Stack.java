package com.gaspar;


public class Stack {

    private int[] mElements;
    private int mTop;


    public Stack(int capacity) {
        mElements = new int[capacity];
        mTop = -1;
    }


    public int size() {
        return mTop + 1;
    }


    public void push(int element) {
        if (isFull()) {
            throw new Overflow();
        }

        mElements[++mTop] = element;
    }


    public int pop() {
        if (!isEmpty()) {
            return mElements[mTop--];
        }

        throw new Underflow();
    }


    private boolean isEmpty() {
        return mTop == -1;
    }


    private boolean isFull() {
        return mTop == mElements.length-1;
    }


    public class Underflow extends RuntimeException {

    }


    public class Overflow extends RuntimeException {

    }
}
