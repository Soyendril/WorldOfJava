package actions;

import world.ICombattants;
import world.Personnage;

import java.util.Random;

public class Combat {

    public static ICombattants dernierAttaquant;

    /**
     * Methode permettant de lancer un combat
     * va tirer au sort qui va jouer en 1er
     * puis tire au sort entre lancer une attaque attaque ou bien se nourrir
     * si les points de vies du Héro sont inférieurs à 15, un tirage au sort se fera pour savoir s'il peut manger ou non
     * si les points de vies du Monstre sont inférieurs à 10, un tirage au sort se fera pour savoir s'il peut manger.
     * @param hero Héro choisi pour le combat
     * @param monster Monstre choisi pour le combat
     */
    public static void combat(ICombattants hero, ICombattants monster) {
        dernierAttaquant = null;
        while(hero.getPointDeVie() > 0 && monster.getPointDeVie() > 0) {
            int rand = new Random().nextInt(0,2);
            boolean turn = new Random().nextBoolean();
            // Si tour c'est le tour du Héro
            if (turn) {//Si le Héro à moins de 15 PV il tente de manger
                if (hero.getPointDeVie() < 15 && rand == 0) {
                    hero.manger();
                    gagnant(hero, monster);
                } else { // Sinon le Héro attaque
                    attaque(hero,monster);
                }
                // Si tour c'est le tour du Monstre
            } else {//Si le Monstre à moins de 10 PV il tente de manger
                if (monster.getPointDeVie() < 10 && rand == 0) {
                    monster.manger();
                    gagnant(hero, monster);
                } else { // Sinon le Monstre attaque
                    attaque(monster,hero);
                }
            }
        }
    }

    /**
     * Retourne un message afin de savoir qui a gagné le combat
     * @param hero Héro du combat
     * @param monster Monstre du combat
     */
    private static void gagnant(ICombattants hero, ICombattants monster) {
        //Si le Hero à plus de 0 PV et le Monstre à moins ou 0 PV le Héro gagne
        if (hero.getPointDeVie() > 0 && monster.getPointDeVie() <= 0) {
            System.out.println("Le vainqueur est " + hero.getNom());
        }
        //Si le Monstre à plus de 0 PV et le Hero à moins ou 0 PV le Monstre gagne
        else if (hero.getPointDeVie() <= 0 && monster.getPointDeVie() > 0){
            System.out.println("Le vainqueur est " + monster.getNom());
        }
        //Sinon le combat continue
//        else {
//            System.out.println("Le combat continue");
//        }
    }

    /**
     * Methode qui permet au Héro/Monstre d'attaquer
     * Mets a jour l'endurance perdue chez les 2 équipes
     * Verifie qui est la dernier attaquant pour eviter la répétitions des attaques par le même Personnage
     * @param attaquant personnage qui lance l'attaque
     * @param defenseur personnage qui subit l'attaque
     */
    private static void attaque(ICombattants attaquant, ICombattants defenseur){
        if(dernierAttaquant != attaquant){
            dernierAttaquant = attaquant;
            attaquant.attaquer(defenseur);
            if (defenseur.getPointDeVie() <= 0) {
                defenseur.setPointDeVie(0);
                System.out.println(attaquant.getNom() + " inflige " + attaquant.getArmes().getDegat() + " points de dégats à " + defenseur.getNom()+" avec son "+ attaquant.getArmes().getNom());
                System.out.println("Il lui reste " + defenseur.getPointDeVie() + " points de vie");
                perdreEndurance(attaquant, defenseur);
            }
            return;
        } else if (dernierAttaquant == attaquant){
            System.out.println(attaquant.getNom()+" à deja attaqué pour ce tour!");
            return;
        }

        gagnant(attaquant, defenseur);
    }

    /**
     * Fait perdre de l'endurance au combattant
     * @param combattants1 premier combattant de l'equipe
     * @param combattants2 second combattant de l'equipe
     *
     */
    public static void perdreEndurance(ICombattants combattants1, ICombattants combattants2){
        combattants1.setEndurance(combattants1.getEndurance() - ((combattants1.getArmes().getLongueur()*combattants1.getArmes().getPoids())/(1000*combattants1.getForce())));
        combattants2.setEndurance(combattants2.getEndurance() - (combattants2.getArmes().getPoids()/(100*combattants2.getForce())));
    }
}
