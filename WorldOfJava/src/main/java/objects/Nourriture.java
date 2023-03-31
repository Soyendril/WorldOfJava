package objects;

public class Nourriture implements IItems {

    private String nom;
    private Integer poids;
    private Integer endurance;

    public String getNom() {
        return nom;
    }
    public Integer getPoids() {
        return poids;
    }
    public Integer getEndurance() {
        return endurance;
    }

    public Nourriture(String nom, Integer poids, Integer endurance) {
        this.nom = nom;
        this.poids = poids;
        this.endurance = endurance;
    }
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public void setPoids(Integer poids) {
        this.poids = poids;
    }
}
