package POOjava;


public class Categorie {
    private String type;

    public Categorie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
