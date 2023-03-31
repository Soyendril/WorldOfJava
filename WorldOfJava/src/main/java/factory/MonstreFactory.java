package factory;

import map.Coordonnes;
import map.Map;
import world.Monstre;

import java.util.Random;

public class MonstreFactory {

    /**
     * Factory de Monstre pour generer aléatoirement un Monstre
     *ce monstre possedera un prenom,un nom et des statisques qui sont generé aleatoirement
     * ainsi qu'une position aléatoire sur la map
     */
    public static Monstre build(){
        String nom = monstrePrenom[new Random().nextInt(monstrePrenom.length)]
                +monstreNom[new Random().nextInt(monstreNom.length)];
        Integer force = new Random().nextInt(5,11);
        Integer pdv = new Random().nextInt(50,101);
        int xRandom = new Random().nextInt(0, Map.MAX_X);
        int yRandom = new Random().nextInt(0,Map.MAX_Y);
        Coordonnes coordonne = new Coordonnes(xRandom, yRandom);

        return new Monstre(pdv,nom,force, 1000,pdv, coordonne);

        // Monstre monstre = new Monstre(pdv,nom,force, 100,pdv, coordonne);
        // return monstre;
    }

    /**
     * Liste de prenom possibble pour le monstre
     * **/
    public static String[] monstrePrenom = new String[] {
            "Sargeras ","Kil'jaeden ","Archimonde ","Mannoroth ","Azgalor ","Tichondrius ","Anetheron ","Méphistroth ","Talgath ",
            "Mal'Ganis ","Balnazzar ","Varimathras ","Detheroc ","Magtheridon ","Seigneur Funeste Kazzak ","Kaz'Rogal ","Généralissime Kruul ",
            "Gul'dan ","Teron Fielsang ","Socrethar ","Velhari ","Xavius "
    };

    /**
     *  Liste de nom possibble pour le monstre
     * **/
    public static String[] monstreNom = new String[] {
            "Le Terrifiant","Féroce","L'Implacable",
            "Le Meurtrier","Le Sanguinaire","Le Hideux","Le Repoussant",
            "Le Nauséabond","Le Maléfique","Le Démoniaque","Le Surnaturel","L'Énorme",
            "L'Invulnérable","L'Épouvantable","Le Mystérieux","L'Immortel","L'Invincible","L'Ancien",
            "Primitif","Surnaturel","Magique","Puissant"
    };
}
