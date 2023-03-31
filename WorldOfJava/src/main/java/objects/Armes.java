package objects;

public class Armes implements IItems{

    private String nom;
    private Integer degat;
    private Integer longueur;
    private Integer poids;

    public Armes(String nom, Integer degat, Integer longueur, Integer poids) {
        this.nom = nom;
        this.degat = degat;
        this.longueur = longueur;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Integer getDegat() {
        return degat;
    }
    public void setDegat(Integer degat) {
        this.degat = degat;
    }
    public Integer getLongueur() {
        return longueur;
    }
    public void setLongueur(Integer longueur) {
        this.longueur = longueur;
    }
    public Integer getPoids() {
        return poids;
    }
    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Armes{" +
                "nom='" + nom + '\'' +
                ", degat=" + degat +
                ", longueur=" + longueur +
                ", poids=" + poids +
                '}';
    }
}