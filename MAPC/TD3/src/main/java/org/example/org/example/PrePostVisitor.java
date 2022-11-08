package org.example;

public interface PrePostVisitor extends AbstractVisitor {
    void preVisit(GroupeClient groupeClient);
    void preVisit(Client client);
    void postVisit(GroupeClient groupeClient);
}
