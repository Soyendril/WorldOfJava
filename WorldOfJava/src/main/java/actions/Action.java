package actions;

import map.Map;
import objects.Nourriture;
import world.ICombattants;
import world.Monde;

import java.util.Random;

public class Action {

    /**
     * Réalisation d'une action choisi au hasard lors de chaque chaque tour du personnage combattant
     * 4 choix possible: Dormir, Bouger, Rien ou Manger.
     * @param combattants le combattant qui réalisera l'action
     * @param map la carte sur laquelle se déroule le jeu
     */
    public  static void executeAction(ICombattants combattants, Map map) {
        Monde.Choix[] choix = Monde.Choix.values();
        int rand = new Random().nextInt(choix.length);
        Monde.Choix choixEffectuer = choix[rand];
        if (combattants.getPointDeVie() != 0) {
            switch (choixEffectuer) {
                case SLEEP:
                    Sleep.heal(combattants);
                    System.out.println(combattants.getNom() + " decide de dormir !");
                    break;
                case MOVE:
                    Move.deplacement(combattants, map);
                    break;
                case NOTHING:
                    System.out.println(combattants.getNom() + " ne fait rien");
                    break;
                case EAT:
                    combattants.manger();
                    System.out.println(combattants.getNom() + " mange");

            }
        }
    }
}