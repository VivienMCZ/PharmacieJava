package POOjava;

public class CommandeStandard extends Commande {
    public CommandeStandard() {
        super("standard");  // Définir le type de commande comme "standard"
    }

    @Override
    public boolean validerCommande(Pharmacie pharmacie) {
        System.out.println("Validation d'une commande standard...");
        // Vous pouvez ajouter des fonctionnalités spécifiques ici, comme des remises pour les commandes standard
        return super.validerCommande(pharmacie);  // Appeler la méthode de validation de la classe de base
    }
}
