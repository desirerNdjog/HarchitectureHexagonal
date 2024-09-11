package com.accenture.utils;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

public class Tuplet<F, S, T> {
    private F first;
    private S second;
    private T thirt;

    public Tuplet(F one, S second, T thrith){
        this.first = one;
        this.second = second;
        this.thirt = thrith;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public T getThirt() {
        return thirt;
    }

    public void setThirt(T thirt) {
        this.thirt = thirt;
    }
}
