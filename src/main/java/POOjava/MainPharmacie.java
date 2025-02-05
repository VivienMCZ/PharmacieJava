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

        // Création de commandes urgentes et standard
        CommandeUrgente commandeUrgente = new CommandeUrgente();
        CommandeStandard commandeStandard = new CommandeStandard();

        // Ajouter des produits aux commandes
        commandeUrgente.ajouterProduitCommande(produit1, 10);  // Ajouter 10 Crèmes à la commande urgente
        commandeStandard.ajouterProduitCommande(produit2, 5);  // Ajouter 5 Shampooings à la commande standard

         // Ajouter les commandes à la pharmacie
        pharmacie.ajouterCommande(commandeUrgente);
        pharmacie.ajouterCommande(commandeStandard);

        // Traiter les commandes en fonction de la priorité
        pharmacie.traiterCommandes();  // Traite d'abord la commande urgente, puis la commande standard

        // Afficher les produits restants en stock après les commandes
        System.out.println("\nStock après les commandes:");
        pharmacie.afficherProduits();  // Appel sans argument
    }
}
