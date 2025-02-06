package POOjava;

import java.util.ArrayList;
import java.util.List;

public class GestionUtilisateurs {
    private List<Pharmacien> utilisateurs;

    public GestionUtilisateurs() {
        this.utilisateurs = new ArrayList<>();
    }

    public void ajouterUtilisateur(Pharmacien admin, Pharmacien utilisateur) {
            if (admin.role() == Utilisateurs.Role.Admin) {
            utilisateurs.add(utilisateur);
            System.out.println(utilisateur.nom() + " a été ajouté avec succès.");
        } else {
            System.out.println("Erreur : Seul un administrateur peut ajouter un utilisateur.");
        }
    }

    public void supprimerUtilisateur(Pharmacien admin, String nom) {
        if (admin.role() == Utilisateurs.Role.Admin) {
            utilisateurs.removeIf(utilisateur -> utilisateur.nom().equals(nom));
            System.out.println(nom + " a été supprimé.");
        } else {
            System.out.println("Erreur : Seul un administrateur peut supprimer un utilisateur.");
        }
    }

    public void afficherUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré.");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (Pharmacien p : utilisateurs) {
                System.out.println(p);
            }
        }
    }
}
