package org.example;

import java.util.Collection;

public class Client implements PrePostVisitable, Visitable {
    private String name;
    private Collection<Commande> commandes;

    Client(String name) {
        this.name = name;
    }

    public void addCommande(Commande commande) {
        throw new UnsupportedOperationException();
    }

    public void addLigne(Ligne ligne) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        prePostVisitor.preVisit(this);

    }

    @Override
    public void accept(Visitor visitor) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return this.name;
    }
}
