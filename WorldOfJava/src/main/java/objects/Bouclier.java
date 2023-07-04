package objects;

public class Bouclier implements IItems {

    private String nom;
    private Integer defense;
    private Integer poids;

    public Bouclier(String nom, Integer defense, Integer poids) {
        this.nom = nom;
        this.defense = defense;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defence) {
        this.defense = defense;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }
}

