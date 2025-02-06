package POOjava;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<ProduitCommande> produitsCommande;
    private String typeCommande;

    public Commande(String typeCommande) {
        this.produitsCommande = new ArrayList<>();
        this.typeCommande = typeCommande;
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
                System.out.println("Voici la commande " + getTypeCommande() + ": " + pc.getProduit().getNom() + " - Quantité : " + pc.getQuantite());
            }
        }
    }

    public boolean validerCommande(Pharmacie pharmacie) {
        for (ProduitCommande pc : produitsCommande) {
            Produits produit = pc.getProduit();
            int quantiteDemandee = pc.getQuantite();

            // Vérifier le stock
            if (produit.getQuantite() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour le produit : " + produit.getNom());
                return false;
            }

            // Décrémenter le stock
            produit.setQuantite(produit.getQuantite() - quantiteDemandee);

            // Alerte de stock critique
            if (produit.getQuantite() < 5) {
                System.out.println("Alerte : Stock critique pour le produit : " + produit.getNom());
            }
        }

        System.out.println("Commande validée avec succès.");
        return true;
    }

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