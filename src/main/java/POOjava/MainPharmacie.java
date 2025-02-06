package POOjava;


public class MainPharmacie {
    public static void main(String[] args) {
        // Création de la pharmacie
        Pharmacie pharmacie = new Pharmacie();

        // Création de produits
        Produits produit1 = new Produits("Crème", 10, 50, "Cosmetique");
        Produits produit2 = new Produits("Shampooing", 15, 30, "Hygiène");

        // Ajouter des produits au stock
        pharmacie.ajouterProduits(produit1);
        pharmacie.ajouterProduits(produit2);

        pharmacie.afficherProduits();

        HistoriqueCommandes historique = new HistoriqueCommandes();

        Commande commande1 = new Commande("Standard");
        commande1.ajouterProduitCommande(produit1, 45); // Quantité importante pour tester l'alerte
        commande1.ajouterProduitCommande(produit2, 25);
        historique.ajouterCommande(commande1);

        Commande commande2 = new Commande("Urgente");
        commande2.ajouterProduitCommande(produit1, 5);
        commande2.ajouterProduitCommande(produit2, 5);
        historique.ajouterCommande(commande2);

        commande1.validerCommande(pharmacie);
        commande2.validerCommande(pharmacie);

        System.out.println("\nStock après les commandes:");
        pharmacie.afficherProduits();

        System.out.println("\nHistorique des commandes:");
        historique.afficherHistorique();
    }
}