package POOjava;
import java.util.Scanner;
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
        pharmacie.ajouterProduit(produit1);
        pharmacie.ajouterProduit(produit2);
        pharmacie.ajouterProduit(produit3);
        pharmacie.ajouterProduit(produit4);
        pharmacie.ajouterProduit(produit5);

        pharmacie.afficherTousLesProduits();

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
        pharmacie.afficherTousLesProduits();  // Appel sans argument
        pharmacie.produitsRuptureDeStock();

        Scanner scanner = new Scanner(System.in);
        pharmacie.supprimerProduits(produit1); // 
        scanner.close();
    }

}
