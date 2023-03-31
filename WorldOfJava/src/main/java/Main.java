import world.Monde;

public class Main {
    public static void main(String... args) {

        /**
         * Lancement de Worlo of Java: Mists of IntellIJ
         * Création du monde
         * Instanciation des différents objet
         * Lancement de la boucle pour les tour de jeux
         */
        Monde m = new Monde();
        System.out.println("==========================================/World of Java: Mists of IntellIJ/==========================================");
        System.out.println("==========================================/       Création du monde        /==========================================");
        m.lancementJeu();
        System.out.println("==========================================/           Monde Crée           /==========================================");
        System.out.println("==========================================/     Lancement des combats      /==========================================");
        boolean condition = true;
        int index = 0;
        while(condition && index <= 50){

            System.out.println("==========================================/         Tour numéro "+ index+"          /==========================================");
            condition = m.demarrer();
            index++;
        }
        m.teamWinner();

    }

}
