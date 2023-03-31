package factory;

import objects.Bouclier;

import java.util.Random;

public class BouclierFactory {
    public static Bouclier build(){
        /**
         * Factory de bouclier pour generer aléatoirement un bouclier
         * 6 choix possible:Ecu, Pavois, Targe, Rondache, Scutum et Mains nue.
         * chaque possibilité possède des statistiques propres
         */



        int rand = new Random().nextInt(1,41);
        Bouclier bouclier;
        if (rand<5){
            bouclier = new Bouclier("Ecu", 5, 100);
        } else if (rand >= 5 && rand < 10) {
            bouclier = new Bouclier("Pavois",10,500);
        }else if (rand >= 10 && rand < 15) {
        bouclier = new Bouclier("Targe",8,550);}
        else if (rand >= 15 && rand < 20) {
            bouclier = new Bouclier("Rondache",11,520);}
        else if (rand >= 20 && rand < 25) {
            bouclier = new Bouclier("Scutum",9,560);}
        else {
            bouclier = new Bouclier("Mains nue",0 , 0);
        }
        return bouclier;

    }
}
