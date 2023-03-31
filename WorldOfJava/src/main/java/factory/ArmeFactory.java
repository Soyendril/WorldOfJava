package factory;

import objects.Armes;

import java.util.Random;

public class ArmeFactory {
    /**
     * Factory d'arme qui permet de generer des armes de manière aleatoire
     * 3 choix possibles: Epee,Gourdin et Poings
     * @return
     */
    public static Armes build(){
        int rand = new Random().nextInt(0,16);
        Armes armes;
        if (rand<5){
            armes = new Armes("Epee", 15, 150, 1400);
        }
        else if (rand>=5 && rand < 10){
            armes = new Armes("Gourdin", 10, 80, 1200);
        }
        else{
            armes = new Armes("Poings",5,15,150);
        }
        return armes;
    }
}
