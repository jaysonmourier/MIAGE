package org.example;

public class XMLRapportCommandes implements PrePostVisitor {

    public void preVisit(GroupeClient groupeClient) {
        System.out.println("<groupe>");
    }

    public void preVisit(Client client) {
        String n = client.getName();
        System.out.println("<client name='" + n + "'>");
    }

    public void postVisit(GroupeClient groupeClient) {
        System.out.println("</groupe>");
    }
}
