package org.example;

import java.util.Collection;

public class Commande implements PrePostVisitable, Visitable {
    private String name;
    private Collection<Ligne> lignes;

    Commande(String name) {
        this.name = name;
    }

    public void addLigne(Ligne ligne) {
        throw new UnsupportedOperationException();
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
