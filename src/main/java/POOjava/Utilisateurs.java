package POOjava;

public interface Utilisateurs {
    String nom();
    Role role();

    enum Role {
        Admin, Employe
    }
}

