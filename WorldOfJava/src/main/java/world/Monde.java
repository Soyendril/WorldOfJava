package world;

import actions.Action;
import actions.Combat;
import factory.MonstreFactory;
import factory.PersonnageFactory;
import map.Map;

public class Monde {

    //Création des équipes
    Equipe heros = new Equipe();
    Equipe monstres = new Equipe();
    Map map = new Map();

    /**
     * Affrontement d'un Personnage et d'un Monstre dans un combat à mort
     * Chacun des deux combattants attaque en tour par tour
     **/

    public enum Choix{
        MOVE,SLEEP,NOTHING,EAT
    }

    /**
     * Methode qui regroupe les différent objet
     * a instancier et a regroupe dans les
     * sac et & equipe respective
     */
    public void lancementJeu() {

        // Création des Heros & Monstres et ajout aux équipe spécifique
        heros.addFighter(PersonnageFactory.build());
        heros.addFighter(PersonnageFactory.build());
        monstres.addFighter(MonstreFactory.build());
        monstres.addFighter(MonstreFactory.build());

        // Ajout des armes aux Héros & Monstres
        heros.addArmes();
        monstres.addArmes();

        // Ajout des boucliers aux Héros & Monstres
        heros.addBouclier();
        monstres.addBouclier();

        // Ajout de la nourriture aux Sacs
        heros.addNourritures(5);
        monstres.addNourritures(5);

        // Creation du monde & placement des héros et monstres
        map.create();
        for (int i = 0; i < heros.size(); i++) {
            map.placerJoueur(heros.get(i));
        }
        for (int i = 0; i < monstres.size(); i++) {
            map.placerMonstre(monstres.get(i));
        }

    }

    /**
     * Methode qui boucle sur l'équipe des héros et des monstres pour execute les combat ou les action
     * @return un booleen pour savoir si l'équipe est en vie ou non
     */
    public boolean demarrer() {
        boolean etat = true;
        System.out.println("il y a "+heros.size()+" héros et "+monstres.size()+" monstres");
        try {
            if (heros.chooseFighter().getCoordonnes().equals(monstres.chooseFighter().getCoordonnes())){
                Combat.combat(heros.chooseFighter(), monstres.chooseFighter());
            }else {
                Action.executeAction(heros.chooseFighter(),map);
            }
            etat = heros.isDead();
            if (monstres.chooseFighter().getCoordonnes().equals(heros.chooseFighter().getCoordonnes())){
                Combat.combat(monstres.chooseFighter(), heros.chooseFighter());
            }else {
                Action.executeAction(monstres.chooseFighter(),map);
            }
            etat = monstres.isDead();
            return !etat;
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * Retourne quelle est l'équipe vainqueur
     * si aucune équipe ne gagne retourne un message
     *
     */
    public void teamWinner(){
        if (heros.size() == 0){
            System.out.println("Les Monstres ont gagné !");
        }else if (monstres.size() == 0) {
            System.out.println("Les Héros ont gagné !");
        }else{
            System.out.println("Aucune équipe ne gagne.");
        }
    }
}
