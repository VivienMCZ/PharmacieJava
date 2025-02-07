package POOjava;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pharmacie implements Stocks {
    private List<Produits> produits;

    public Pharmacie() {
        this.produits = new ArrayList<>();
    }

    @Override
    public void ajouterProduit(Produits produit) {
        this.produits.add(produit);
    }

    public void supprimerProduits(Produits produit) {
        Scanner scanner = new Scanner(System.in); // Scanner créé ici

        if (this.produits.remove(produit)) {
            System.out.println("Êtes-vous sûr de vouloir supprimer le produit suivant ?");
            System.out.println("Nom : " + produit.getNomProduit() + ", Prix : " + produit.getPrixProduit() + ", Quantité : " + produit.getQuantiteEnStock());
            System.out.print("Tapez 'oui' pour confirmer : ");

            String confirmation = scanner.nextLine();

            if ("oui".equalsIgnoreCase(confirmation)) {
                this.produits.remove(produit);
                System.out.println(produit + " retiré du stock.");
            } else {
                System.out.println("Annulation de la suppression");
            }
        } else {
            System.out.println("Produit non trouvé dans le stock.");
        }

        scanner.close(); // Fermer le scanner après utilisation
    }

    @Override
    public Produits rechercherProduitParNom(String nom) {
        for (Produits produit : produits) {
            if (produit.getNomProduit().equals(nom)) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public List<Produits> rechercherProduitsParCategorie(String categorie) {
        List<Produits> produitsParCategorie = new ArrayList<>();
        for (Produits produit : produits) {
            if (produit.getCategorieProduit().getType().equals(categorie)) {
                produitsParCategorie.add(produit);
            }
        }
        return produitsParCategorie;
    }

    @Override
    public List<Produits> filtrerProduitsEnRuptureDeStock() {
        List<Produits> produitsEnRuptureDeStock = new ArrayList<>();
        for (Produits produit : produits) {
            if (produit.getQuantiteEnStock() == 0) {
                produitsEnRuptureDeStock.add(produit);
            }
        }
        return produitsEnRuptureDeStock;
    }

    @Override
    public void afficherTousLesProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit dans le stock.");
        } else {
            System.out.println("Liste des produits :");
            for (Produits produit : produits) {
                System.out.println(produit);
            }
        }
    }

    @Override
    public void augmenterQuantiteStock(Produits produit, int quantite) {
        produit.setQuantiteEnStock(produit.getQuantiteEnStock() + quantite);
    }

    @Override
    public void diminuerQuantiteStock(Produits produit, int quantite) {
        if (produit.getQuantiteEnStock() >= quantite) {
            produit.setQuantiteEnStock(produit.getQuantiteEnStock() - quantite);
        } else {
            System.out.println("Quantité insuffisante en stock pour " + produit.getNomProduit());
        }
    }

    public void enregistrerVente(Produits produit, int quantiteVendue) {
        produit.ajouterVente(quantiteVendue);
    }

    public Produits getProduitLePlusVendu() {
        Produits produitLePlusVendu = null;
        int quantiteMaxVendue = 0;

        for (Produits produit : produits) {
            int quantiteVendue = produit.getVentes().values().stream().mapToInt(Integer::intValue).sum();
            if (quantiteVendue > quantiteMaxVendue) {
                quantiteMaxVendue = quantiteVendue;
                produitLePlusVendu = produit;
            }
        }

        return produitLePlusVendu;
    }

    public Map<String, Integer> getQuantitesVenduesParProduit() {
        Map<String, Integer> quantitesVendues = new HashMap<>();

        for (Produits produit : produits) {
            int quantiteVendue = produit.getVentes().values().stream().mapToInt(Integer::intValue).sum();
            quantitesVendues.put(produit.getNomProduit(), quantiteVendue);
        }

        return quantitesVendues;
    }

    public double calculerChiffreDaffairesTotal() {
        double chiffreDaffairesTotal = 0;

        for (Produits produit : produits) {
            int quantiteVendue = produit.getVentes().values().stream().mapToInt(Integer::intValue).sum();
            chiffreDaffairesTotal += produit.getPrixProduit() * quantiteVendue;
        }

        return chiffreDaffairesTotal;
    }

    public void exporterStatistiquesDeVentes(String nomFichier) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomFichier))) {
            // Produit le plus vendu
            Produits produitLePlusVendu = getProduitLePlusVendu();
            writer.println("Produit le plus vendu : " + (produitLePlusVendu != null ? produitLePlusVendu.getNomProduit() : "Aucun"));

            // Quantités vendues par produit
            writer.println("\nQuantités vendues par produit :");
            Map<String, Integer> quantitesVendues = getQuantitesVenduesParProduit();
            for (Map.Entry<String, Integer> entry : quantitesVendues.entrySet()) {
                writer.println(entry.getKey() + " : " + entry.getValue());
            }

            // Chiffre d'affaires total
            double chiffreDaffairesTotal = calculerChiffreDaffairesTotal();
            writer.println("\nChiffre d'affaires total : " + chiffreDaffairesTotal);

            System.out.println("Statistiques de ventes exportées dans le fichier : " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'exportation des statistiques de ventes : " + e.getMessage());
        }
    }
}