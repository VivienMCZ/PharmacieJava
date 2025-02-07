package POOjava;

import java.util.List;

public interface Stocks {
    void ajouterProduit(Produits produit);
    void supprimerProduits(Produits produit);
    Produits rechercherProduitParNom(String nom);
    List<Produits> rechercherProduitsParCategorie(String categorie);
    List<Produits> filtrerProduitsEnRuptureDeStock();
    void afficherTousLesProduits();
    void augmenterQuantiteStock(Produits produit, int quantite);
    void diminuerQuantiteStock(Produits produit, int quantite);
}