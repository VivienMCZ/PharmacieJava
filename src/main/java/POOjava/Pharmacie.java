package POOjava;



import java.util.ArrayList;
import java.util.List;

public class Pharmacie implements Stocks {
    private List<Produits> produits; // Nom plus clair

    public Pharmacie() {
        this.produits = new ArrayList<>();
    }

    @Override
    public void ajouterProduits(Produits produit) {
        if (produit.getPrix() > 0 && produit.getQuantite() > 0) {
            this.produits.add(produit);
        } else {
            System.out.println("Erreur : Le prix et la quantité doivent être supérieurs à zéro.");
        }
    }

    @Override
    public void enleverProduits(Produits produit) {
        if (this.produits.remove(produit)) {
            System.out.println(produit + " retiré du stock.");
        } else {
            System.out.println("Produit non trouvé dans le stock.");
        }
    }

    @Override
    public void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit en stock.");
        } else {
            System.out.println("Produits en stock :");
            for (Produits p : produits) {
                System.out.println(p.getNom() + " - Prix : " + p.getPrix() + " - Quantité : " + p.getQuantite());
            }
        }
    }

    @Override
    public void produitsRuptureDeStock() {
    //liste temporaire renvoyant les produits proches de la rupture de stock (quantité inférieure ou égale à 5)
        List<Produits> ruptureStock = new ArrayList<>();

        for (Produits p : produits) {
            if (p.getQuantite() <= 5) {
                ruptureStock.add(p);
            }
        }

        if (ruptureStock.isEmpty()) {
            System.out.println("Aucun produit proche de la rupture de stock.");
        } else {
            System.out.println("Ces produits sont proches de la rupture de stock :");
            for (Produits p : ruptureStock) {
                System.out.println(p.getNom() + " - Quantité: " + p.getQuantite());
            }
        }
    }


}
