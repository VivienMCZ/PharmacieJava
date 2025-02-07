package POOjava;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<ProduitCommande> produitsCommande;
    private String typeCommande;
    private LocalDateTime dateEtHeure;

    public Commande(String typeCommande) {
        this.produitsCommande = new ArrayList<>();
        this.typeCommande = typeCommande;
        this.dateEtHeure = LocalDateTime.now();
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
            System.out.println("Voici la commande " + getTypeCommande() + ":");
            for (ProduitCommande pc : produitsCommande) {
                System.out.println(pc.getProduit().getNomProduit() + " - Quantité : " + pc.getQuantite());
            }
        }
    }

    public boolean validerCommande(Pharmacie pharmacie) {
        for (ProduitCommande pc : produitsCommande) {
            Produits produit = pc.getProduit();
            int quantiteDemandee = pc.getQuantite();

            if (produit.getQuantiteEnStock() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour le produit : " + produit.getNomProduit());
                return false;
            }

            produit.setQuantiteEnStock(produit.getQuantiteEnStock() - quantiteDemandee);

            if (produit.getQuantiteEnStock() < 5) {
                System.out.println("Alerte : Stock critique pour le produit : " + produit.getNomProduit());
            }
        }

        System.out.println("Commande validée avec succès.");
        return true;
    }

    public String getTypeCommande() {
        return typeCommande;
    }

    public LocalDateTime getDateEtHeure() {
        return dateEtHeure;
    }

    public List<ProduitCommande> getProduitsCommande() {
        return produitsCommande;
    }

    class ProduitCommande {
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