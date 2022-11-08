package org.example;

import java.util.Collection;
import java.util.Iterator;

public class GroupeClient implements PrePostVisitable, Visitable {
    private String name;
    private Collection<Client> clients;

    public GroupeClient(String name) {
        this.name = name;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addClient(String name, Commande commande) {
        throw new UnsupportedOperationException();
    }

    public void addLigne(String a, String b, Ligne ligne) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(PrePostVisitor prePostVisitor) {
        prePostVisitor.preVisit(this);

        Iterator<Client> it = this.clients.iterator();
        Client client = it.next();
        while(it.hasNext()) {
            client.accept(prePostVisitor);
        }

        prePostVisitor.postVisit(this);
    }

    @Override
    public void accept(Visitor visitor) {
        throw new UnsupportedOperationException();
    }
}
