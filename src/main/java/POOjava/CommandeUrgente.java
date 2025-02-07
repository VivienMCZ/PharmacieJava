package POOjava;

public class CommandeUrgente extends Commande {
    public CommandeUrgente() {
        super("Urgente");
    }

    @Override
    public boolean validerCommande(Pharmacie pharmacie) {
        System.out.println("Validation d'une commande urgente...");
        return super.validerCommande(pharmacie);
    }
}