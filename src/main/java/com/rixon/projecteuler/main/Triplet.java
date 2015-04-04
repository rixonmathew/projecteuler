package com.rixon.projecteuler.main;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class Triplet<T> {
    private T left;
    private T middle;
    private T right;

    public Triplet(T left, T middle, T right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getMiddle() {
        return middle;
    }

    public T getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "left=" + left +
                ", middle=" + middle +
                ", right=" + right +
                '}';
    }
}
