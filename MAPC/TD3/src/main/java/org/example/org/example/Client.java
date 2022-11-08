package org.example;

public class Client implements PrePostVisitable, Visitable {
    private String name;

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
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor visitor) {
        throw new UnsupportedOperationException();
    }
}
