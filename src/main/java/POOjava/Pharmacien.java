package POOjava;

public record Pharmacien(String nom, Role role) implements Utilisateurs {

    @Override
    public String toString() {
        return "Nom: " + nom + ", Rôle: " + role;
    }
}
