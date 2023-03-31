package world;

import map.Coordonnes;
import objects.Armes;
import objects.Bouclier;

public class Personnage extends Combattant {

    private Armes armes;
    private Bouclier bouclier;

    public Personnage(Integer maxHealth, String nom, Integer force, Integer endurance, Integer health, Coordonnes coordonnes){
        super(nom, maxHealth, force, endurance, health, coordonnes);
    }


    public String toString(){
        return super.toString();
    }

    @Override
    public void setEndurance(Integer endurance) {

    }

    public Armes getArmes() {
        return armes;
    }

    public void setArmes(Armes armes) {
        this.armes = armes;
    }

    @Override
    public Bouclier getBouclier() {
        return bouclier;
    }

    @Override
    public void setBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }



}