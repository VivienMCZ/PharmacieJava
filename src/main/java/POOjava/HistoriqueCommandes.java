package POOjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HistoriqueCommandes {
    private List<Commande> commandes;

    public HistoriqueCommandes() {
        this.commandes = new ArrayList<>();
    }

    public void ajouterCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public void afficherHistorique() {
        if (commandes.isEmpty()) {
            System.out.println("Aucune commande dans l'historique.");
        } else {
            // Tri des commandes par date et heure décroissante
            Collections.sort(commandes, Comparator.comparing(Commande::getDateEtHeure).reversed());

            System.out.println("Historique des commandes :");
            for (Commande commande : commandes) {
                System.out.println("--------------------");
                System.out.println("Date et heure : " + commande.getDateEtHeure());
                System.out.println("Type : " + commande.getTypeCommande());

            }
        }
    }
}