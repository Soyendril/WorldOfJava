package actions;

import world.ICombattants;

public class Sleep {
    /**
     * Permet à un combattant de Dormir, ce qui lui rend des PV
     *
     * @param combattants personnage effetuant l'action de dormir
     */
    public static void heal(ICombattants combattants){
        combattants.setPointDeVie(combattants.getPointDeVieMax());
    }
}

