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

        Commande commande = new Commande();

        // Ajouter des produits aux commandes
        commande.ajouterProduitCommande(produit1, 10);  // Ajouter 10 Crèmes à la commande urgente
        commande.ajouterProduitCommande(produit2, 5);  // Ajouter 5 Shampooings à la commande standard

        commande.afficherCommande();

        commande.validerCommande(pharmacie);

        // Afficher les produits restants en stock après les commandes
        System.out.println("\nStock après les commandes:");
        pharmacie.afficherProduits();  // Appel sans argument
    }
}
