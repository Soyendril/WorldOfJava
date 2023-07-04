package map;

import world.ICombattants;

public class Map {

    public static char VALEUR_CASE_VIDE = '*';
    public static char VALEUR_HERO = 'H';
    public static char VALEUR_MONSTRE = 'M';
    public final static int MAX_X = 10;
    public final static int MAX_Y = 10;
    private final char[][] map = new char[MAX_X][MAX_Y];

    /**
     * création de la map en la remplissant de cases vide par le symbole "*"
     */
    public void create(){

        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = VALEUR_CASE_VIDE;
            }
        }
    }

    /**
     * Affichage de  la carte et des personnages
     */
    public void afficherMap() {

        for (char[] chars : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    /**
     * Permet de placer un hero sur la map
     * les Héros sont représenté par le caractère "H" sur la map
     * @param hero Hero à placer sur la map
     */
    public void placerJoueur(ICombattants hero){
        var position = hero.getCoordonnes();
        map[position.getX()][position.getY()] = VALEUR_HERO;
    }
    /**
     * Permet de placer un Monstre sur la map
     * les Monstres sont repésenté par le caractère "M" sur la map
     * @param monstre Monstre à placer sur la Map
     */
    public void placerMonstre(ICombattants monstre){
        var position = monstre.getCoordonnes();
        map[position.getX()][position.getY()] = VALEUR_MONSTRE;
    }
    /**
     * Permet de remettre une case vide sur l'ancinne position d'un Personnage
     * @param coordonnes coordonnés à reset
     */
    public void resetPosition(Coordonnes coordonnes){
        map[coordonnes.getX()][coordonnes.getY()] = VALEUR_CASE_VIDE;
    }

    /**
     * Mise à jour de la position du Héro sur la map
     */
    public void updatePositionHero(Coordonnes coordonnes){
        map[coordonnes.getX()][coordonnes.getY()] = VALEUR_HERO;
    }


    /**
     * Mise à jour de la position du Monstre sur la map
     */

    public void updatePositionMonstre(Coordonnes coordonnes){
        map[coordonnes.getX()][coordonnes.getY()] = VALEUR_MONSTRE;
    }
}
