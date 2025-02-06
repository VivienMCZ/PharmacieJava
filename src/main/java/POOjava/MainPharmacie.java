package POOjava;

public class MainPharmacie {
    public static void main(String[] args) {
        // Création de la pharmacie
        Pharmacie pharmacie = new Pharmacie();

        // Création de produits
        Produits produit1 = new Produits("Crème", 10, 50, "Cosmetique");
        Produits produit2 = new Produits("Shampooing", 15, 30, "Hygiène");
        Produits produit3 = new Produits("Gèle douche", 20, 4, "Hygiène");
        Produits produit4 = new Produits("Doliprane", 10, 5, "Médicament");
        Produits produit5 = new Produits("Smecta",15, 2, "Médicament");

        // Ajouter des produits au stock
        pharmacie.ajouterProduits(produit1);
        pharmacie.ajouterProduits(produit2);
        pharmacie.ajouterProduits(produit3);
        pharmacie.ajouterProduits(produit4);
        pharmacie.ajouterProduits(produit5);

        pharmacie.afficherProduits();

        // Commande commande = new Commande();
        Commande commandeUrgente = new CommandeUrgente();
        Commande commandeStandard  = new CommandeStandard();


        // Ajouter des produits aux commandes
        commandeUrgente.ajouterProduitCommande(produit1, 10);  // Ajouter 10 Crèmes à la commande urgente
        commandeStandard.ajouterProduitCommande(produit2, 5);  // Ajouter 5 Shampooings à la commande standard

        commandeUrgente.afficherCommande();
        commandeStandard.afficherCommande();

        commandeStandard.validerCommande(pharmacie);
        commandeUrgente.validerCommande(pharmacie);

        // Afficher les produits restants en stock après les commandes
        System.out.println("\nStock après les commandes:");
        pharmacie.afficherProduits();  // Appel sans argument
        pharmacie.produitsRuptureDeStock();


        GestionUtilisateurs gestion = getUtilisateurs();

        // Affichage après suppression
        gestion.afficherUtilisateurs();
    }

    private static GestionUtilisateurs getUtilisateurs() {
        Pharmacien admin = new Pharmacien("Viktor", Utilisateurs.Role.Admin);
        Pharmacien admin2 = new Pharmacien("Karim", Utilisateurs.Role.Admin);
        Pharmacien employe1 = new Pharmacien("Jayce", Utilisateurs.Role.Employe);
        Pharmacien employe2 = new Pharmacien("Alex", Utilisateurs.Role.Employe);

        GestionUtilisateurs gestion = new GestionUtilisateurs();

        gestion.ajouterUtilisateur(admin, employe1);
        gestion.ajouterUtilisateur(admin, employe2);
        gestion.ajouterUtilisateur(admin, new Pharmacien("David", Utilisateurs.Role.Employe));
        
        gestion.supprimerUtilisateur(admin2, "Karim");
        return gestion;
    }
}

