package world;

import map.Coordonnes;
import objects.Armes;
import objects.Bouclier;
import objects.Sac;

public interface ICombattants {

    public String getNom();
    public void setNom(String nom);
    public Integer getPointDeVieMax();
    public void setPointDeVieMax(Integer pointDeVieMax);
    public Integer getPointDeVie();
    public void setPointDeVie(Integer pointDeVie);
    public Integer getForce();
    public void setForce(Integer force);
    public Integer getEndurance();
    public void setEndurance(Integer endurance);
    public Armes getArmes();
    public void setArmes(Armes armes);
    public Bouclier getBouclier();
    public void setBouclier(Bouclier bouclier);
    public Sac getSac();
    public void attaquer(ICombattants adversaire);
    public void manger();
    public Coordonnes getCoordonnes();
    public void setCoordonnes(Coordonnes coordonnes);

}
