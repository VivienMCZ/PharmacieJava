package POOjava;

public class CommandeUrgente extends Commande {
    public CommandeUrgente() {
        super("Urgente");  // Définir le type de commande comme "urgent"
    }

    @Override
    public boolean validerCommande(Pharmacie pharmacie) {
        System.out.println("Validation d'une commande urgente...");
        // Vous pouvez ajouter des fonctionnalités spécifiques ici, comme des frais supplémentaires pour l'urgence
        return super.validerCommande(pharmacie);  // Appeler la méthode de validation de la classe de base
    }
}
