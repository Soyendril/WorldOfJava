package factory;

import objects.Nourriture;

public class NourritureFactory {
    /**
     * Factory de Nourriture pour generer une ration
     *
     */
    public static Nourriture buildNourriture() {
        return new Nourriture("Ration",2,20);
    }
}