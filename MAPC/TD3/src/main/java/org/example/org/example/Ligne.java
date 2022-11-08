package org.example;

public class Ligne implements PrePostVisitable, Visitable {
    private String name;
    private int sum;

    public Ligne(String name) {
        this.name = name;
    }

    public Ligne(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor visitor) {
        throw new UnsupportedOperationException();
    }
}
