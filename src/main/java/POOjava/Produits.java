package POOjava;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Produits {
    private String nomProduit;
    private double prixProduit;
    private int quantiteEnStock;
    private Categorie categorieProduit;
    private Map<Date, Integer> ventes;

    public Produits(String nomProduit, double prixProduit, int quantiteEnStock, String typeCategorie) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.quantiteEnStock = quantiteEnStock;
        this.categorieProduit = new Categorie(typeCategorie);
        this.ventes = new HashMap<>();
    }



    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public Categorie getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(Categorie categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    public void ajouterVente(int quantiteVendue) {
        Date dateActuelle = new Date();
        ventes.put(dateActuelle, ventes.getOrDefault(dateActuelle, 0) + quantiteVendue);
    }

    public Map<Date, Integer> getVentes() {
        return ventes;
    }

    @Override
    public String toString() {
        return "Produit : " + nomProduit + ", Prix : " + prixProduit + ", Quantité : " + quantiteEnStock;
    }
}