package world;

import map.Coordonnes;
import objects.Armes;
import objects.Bouclier;

public class Monstre extends Combattant {

    private Armes armes;
    private Bouclier bouclier;

    public Monstre(Integer pointDeVieMax, String nom, Integer force, Integer endurance, Integer pointDeVie, Coordonnes coordonnes) {
        super(nom, pointDeVieMax, force, endurance, pointDeVie, coordonnes);
    }

    public Armes getArmes() {
        return armes;
    }

    public void setArmes(Armes armes) {
        this.armes = armes;
    }

    public Bouclier getBouclier() {
        return bouclier;
    }

    public void setBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }

}