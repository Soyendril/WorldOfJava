package objects;

public class Bouclier implements IItems {

    private String nom;
    private Integer defence;
    private Integer poids;

    public Bouclier(String nom, Integer defence, Integer poids) {
        this.nom = nom;
        this.defence = defence;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }
}

