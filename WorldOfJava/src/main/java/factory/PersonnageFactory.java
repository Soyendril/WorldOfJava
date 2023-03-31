package factory;

import map.Coordonnes;
import map.Map;
import world.Personnage;

import java.util.Random;

public class PersonnageFactory {

    /**
     * Factory de Hero pour generer aléatoirement un Hero
     *ce dernier possedera un nom et des statisques qui sont generé aleatoirement
     * ainsi qu'une position aléatoire sur la map
     */
    public static Personnage build(){
        String nom = heroNom[new Random().nextInt(heroNom.length)];
        Integer force = new Random().nextInt(5,11);
        Integer pdv = new Random().nextInt(50,101);
        int xRandom = new Random().nextInt(0, Map.MAX_X);
        int yRandom = new Random().nextInt(0,Map.MAX_Y);
        Coordonnes coordonne = new Coordonnes(xRandom, yRandom);

        return new Personnage(pdv,nom,force, 1000,pdv, coordonne);

        // Personnage personnage = new Personnage(pdv,nom,force, 100,pdv, coordonne);
        // return personnage;
    }

    public static String[] heroNom = new String[] {
            "Soyendril","Uther le Porteur de lumière","Sylvanas Coursevent","Arthas","Main-noire","Orgrim-Marteau du Destin","Ner'zhul","Thrall",
            "Garrosh Hurlenfer","Vol'jin","Jaina Portvaillant","Anduin Wrynn","Mathias Shaw","Grand Amiral Jes-Tereth","Seigneur Darius Crowley",
            "Nobundo","Jarode Chantelombre"
    };
}

