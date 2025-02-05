package POOjava;

public class Produits {
    private String nom;
    private int prix;
    private int quantite;
    private Categorie categorie;

    public Produits(String nom, int prix, int quantite, String typeCategorie) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = new Categorie(typeCategorie);
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {  // Ajout de la méthode setQuantite
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "Produit: " + nom + ", Prix: " + prix + ", Quantité: " + quantite;
    }
}
