package POOjava;

public class MainPharmacie {
    public static void main(String[] args) {
        // Création de la pharmacie
        Pharmacie pharmacie = new Pharmacie();

        // Création de produits
        Produits produit1 = new Produits("Crème", 10.50, 50, "Cosmétique");
        Produits produit2 = new Produits("Shampoing", 15.00, 30, "Hygiène");
        Produits produit3 = new Produits("Paracétamol", 2.50, 100, "Médicament");

        // Ajout des produits au stock de la pharmacie
        pharmacie.ajouterProduit(produit1);
        pharmacie.ajouterProduit(produit2);
        pharmacie.ajouterProduit(produit3);

        // Affichage du stock initial
        System.out.println("Stock initial :");
        pharmacie.afficherTousLesProduits();

        // Création de commandes
        Commande commande1 = new Commande("Standard");
        commande1.ajouterProduitCommande(produit1, 2);
        commande1.ajouterProduitCommande(produit2, 1);

        Commande commande2 = new Commande("Urgente");
        commande2.ajouterProduitCommande(produit3, 5);

        // Validation et enregistrement des ventes
        commande1.validerCommande(pharmacie);
        for (Commande.ProduitCommande pc : commande1.getProduitsCommande()) {
            pharmacie.enregistrerVente(pc.getProduit(), pc.getQuantite());
        }

        commande2.validerCommande(pharmacie);
        for (Commande.ProduitCommande pc : commande2.getProduitsCommande()) {
            pharmacie.enregistrerVente(pc.getProduit(), pc.getQuantite());
        }

        // Affichage du stock après les ventes
        System.out.println("\nStock après les ventes :");
        pharmacie.afficherTousLesProduits();

        // Affichage des statistiques de ventes
        System.out.println("\nStatistiques de ventes :");
        System.out.println("Produit le plus vendu : " + pharmacie.getProduitLePlusVendu().getNomProduit());
        System.out.println("Quantités vendues par produit : " + pharmacie.getQuantitesVenduesParProduit());
        System.out.println("Chiffre d'affaires total : " + pharmacie.calculerChiffreDaffairesTotal());

        // Exportation des statistiques de ventes
        pharmacie.exporterStatistiquesDeVentes("statistiques_ventes.txt");
    }
}