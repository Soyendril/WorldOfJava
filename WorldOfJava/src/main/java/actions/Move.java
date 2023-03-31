package actions;

import map.Map;
import world.ICombattants;
import world.Monstre;
import world.Personnage;

import java.util.Random;

public class Move {

    public enum directions{
        NORD,SUD,EST,OUEST
    }


    /**
     * Permet de choisir une direction au hasard entre (NORD, SUD, EST et OUEST)
     * Puis effectue un deplacement d'une case selon la direction choisie.
     * Mise a jour la Map pour afficher les positions des Combattants
     * @param combattant personnage effectuant l'action (Hero ou Monstre)
     * @param map carte sur laquelle l'action s'effectue
     */
    public static void deplacement(ICombattants combattant, Map map){
        directions[] direction = directions.values();
        int rand = new Random().nextInt(direction.length);
        directions directionChoisie = direction[rand];
        var position = combattant.getCoordonnes();
        map.resetPosition(position);
        switch (directionChoisie) {
            case EST:
                if (position.getY() == Map.MAX_Y){
                    System.out.println(combattant.getNom()+" tente de se déplacer à l'EST");
                    System.out.println("Limite EST de la carte atteinte! ");
                    break;
                }else {
                    position.setY(position.getY() + 1);
                    System.out.println(combattant.getNom()+" s'est deplacé d'une case vers l'EST' ! ");
                    break;
                }
            case OUEST:
                if (position.getY() == Map.MAX_Y){
                    System.out.println(combattant.getNom()+" tente de se déplacer à l'OUEST");
                    System.out.println("Limite OUEST de la carte atteinte! ");
                    break;
                }else {
                    position.setY(position.getY() - 1);
                    System.out.println(combattant.getNom()+" s'est deplacé d'une case vers l'OUEST' ! ");
                    break;
                }
            case SUD:
                if (position.getX() == Map.MAX_X){
                    System.out.println(combattant.getNom()+" tente de se déplacer au SUD");
                    System.out.println("Limite SUD de la carte atteinte! ");
                    break;
                }else {
                    position.setX(position.getX() + 1);
                    System.out.println(combattant.getNom()+" s'est deplacé d'une case vers le SUD ! ");
                    break;
                }

            case NORD:
                if (position.getX() == Map.MAX_X){
                    System.out.println(combattant.getNom()+" tente de se déplacer au NORD");
                    System.out.println("Limite NORD de la carte atteinte! ");
                    break;
                }else {
                    position.setX(position.getX() - 1);
                    System.out.println(combattant.getNom()+" s'est deplacé d'une case vers le NORD ! ");
                    break;
                }

        }
        if (combattant instanceof Monstre){
            map.updatePositionMonstre(position);}
        else if (combattant instanceof Personnage) {
            map.updatePositionHero(position);
        }

        map.afficherMap();
    }
}

