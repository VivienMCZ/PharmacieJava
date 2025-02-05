package POOjava;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<ProduitCommande> produitsCommande;  // Liste pour stocker les produits et leurs quantités
    private String typeCommande;  // Type de commande (urgent, standard)

    public Commande(String typeCommande) {
        this.produitsCommande = new ArrayList<>();  // Initialisation de la liste vide
        this.typeCommande = typeCommande;  // Type de commande : "urgent" ou "standard"
    }

    public void ajouterProduitCommande(Produits produit, int quantite) {
        for (ProduitCommande pc : produitsCommande) {
            if (pc.getProduit().equals(produit)) {
                pc.setQuantite(pc.getQuantite() + quantite);
                return;
            }
        }
        produitsCommande.add(new ProduitCommande(produit, quantite));
    }

    public void afficherCommande() {
        if (produitsCommande.isEmpty()) {
            System.out.println("La commande est vide.");
        } else {
            for (ProduitCommande pc : produitsCommande) {
                System.out.println(pc.getProduit().getNom() + " - Quantité : " + pc.getQuantite());
            }
        }
    }

    public boolean validerCommande(Pharmacie pharmacie) {
        // Valider le stock comme avant
        for (ProduitCommande pc : produitsCommande) {
            Produits produit = pc.getProduit();
            int quantiteDemandee = pc.getQuantite();
            if (produit.getQuantite() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour le produit : " + produit.getNom());
                return false;
            }
        }

        // Mise à jour du stock
        for (ProduitCommande pc : produitsCommande) {
            Produits produit = pc.getProduit();
            int quantiteDemandee = pc.getQuantite();
            produit.setQuantite(produit.getQuantite() - quantiteDemandee);
        }

        System.out.println("Commande validée avec succès.");
        return true;
    }

    // Getter pour typeCommande
    public String getTypeCommande() {
        return typeCommande;
    }

    private class ProduitCommande {
        private Produits produit;
        private int quantite;

        public ProduitCommande(Produits produit, int quantite) {
            this.produit = produit;
            this.quantite = quantite;
        }

        public Produits getProduit() {
            return produit;
        }

        public int getQuantite() {
            return quantite;
        }

        public void setQuantite(int quantite) {
            this.quantite = quantite;
        }
    }
}
