package world;

import factory.ArmeFactory;
import factory.BouclierFactory;
import factory.NourritureFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Equipe implements Iterable<ICombattants> {
    private List<ICombattants> tab;
    public Equipe(){
        this.tab = new ArrayList<>();
    }

    // Permet d'ajouter un combattant a une équipe
    public void addFighter(ICombattants pCombattants ){
        tab.add(pCombattants);
    }

    // Permet d'ajouter une arme a un combattant en parcourant l'équipe
    public void addArmes(){
        for (ICombattants e: tab) {
            e.setArmes(ArmeFactory.build());
        }
    }

    // Permet d'ajouter un bouclier a un combattant en parcourant l'équipe
    public void addBouclier(){
        for (ICombattants e: tab) {
            e.setBouclier(BouclierFactory.build());
        }
    }

    // Permet de recupere le 1er commbattant de l'équipe , celui a l'index 0
    public ICombattants chooseFighter(){
        if (tab.size() == 0){
            throw new RuntimeException("L'équipe est vide !");
        }else{
            int rand = new Random().nextInt(tab.size());
            return tab.get(rand);
        }

    }

    // Permet d'ajouter de la nourriture dans l'inventaire des équipe de combattant
    public void addNourritures(int numberNourriture){
        int rand = new Random().nextInt(numberNourriture);
        for(int i = 0; i < rand; i++) {
            for (ICombattants e : tab) {
                e.getSac().addItems(NourritureFactory.buildNourriture());
            }
        }
    }

    public ICombattants get(int index){
        return tab.get(index);
    }
    public int size(){
        return tab.size();
    }

    @Override
    public Iterator<ICombattants> iterator() {
        return tab.iterator();
    }

    /**
     * L'itérateur parcoure la liste de Heros/Monstres afin de savoir s'ils sont mort
     * @return si Mort ou Non
     */
    public boolean isDead(){
        boolean resulat = true;
        Iterator<ICombattants> iter = iterator();
        while(iter.hasNext()){
            ICombattants e = iter.next();
            if(e.getPointDeVie() > 0) {
                resulat = false ;
            } else {
                iter.remove();
                System.out.println(e.getNom()+" est mort !");
            }
        }
        return resulat;
    }
}

