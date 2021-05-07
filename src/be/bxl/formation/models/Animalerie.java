package be.bxl.formation.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animalerie {

    //region Champs
    private String nom;
    private ArrayList<Animal> animaux;
    private int nbChat;
    private int nbChien;
    private int nbOiseau;
    //endregion


    //region Getters
    public String getNom() {
        return nom;
    }

    public List<Animal> getAnimaux() {
        return Collections.unmodifiableList(animaux);
    }

    public int getNbChat() {
        return nbChat;
    }

    public int getNbChien() {
        return nbChien;
    }

    public int getNbOiseau() {
        return nbOiseau;
    }
    //endregion


    //region Setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    //endregion


    //region Constructeur
    public Animalerie(String nom) {
        this.setNom(nom);
        this.nbChat = 0;
        this.nbChien = 0;
        this.nbOiseau = 0;
        this.animaux = new ArrayList<>();
    }
    //endregion


    //region Méthode
    private void updateNombreAnimaux(Animal animal, int modificateur) {
        if(animal instanceof Chat)
            nbChat += modificateur;
        else if (animal instanceof Chien)
            nbChien += modificateur;
        else if (animal instanceof Oiseau)
            nbOiseau += modificateur;
        else
            throw new RuntimeException("Type d'animal non supporté !!!");
    }

    public void ajouterAnimal(Animal animal) {
        if(animal == null || !animal.isVivant())
            throw new IllegalArgumentException("Parametre Animal non valide!");

        // Ajout dans la liste
        this.animaux.add(animal);

        // Mise a jours du compteur
        updateNombreAnimaux(animal, 1);
    }

    public void retirerAnimal(Animal animal) {
        if(animal == null)
            throw new IllegalArgumentException("Parametre Animal non valide!");


        // Suppression dans la liste
        boolean ok = this.animaux.remove(animal);

        if(ok) {
            // Mise a jours du compteur
            updateNombreAnimaux(animal, -1);
        }
    }

    public void retirerAnimauxdecede() {
        int indexMax = this.animaux.size() - 1;

        for (int i = indexMax; i >= 0; i--) {
            Animal a = this.animaux.get(i);

            if(!a.isVivant()) {
                retirerAnimal(a);
            }
        }
    }

    /**
     * Permet de simuler une journée complete dans l'animalerie
     * @return Le résumé des evenements
     */
    public String simulationJournee() {
        StringBuilder resume = new StringBuilder();

        resume.append(" - Journée \n");
        for (Animal a: this.animaux) {
            a.debuterJour();

            if(a instanceof Chat c && !c.isGriffeCoupe()) {
                resume.append(c.getNom()).append(" a griffé le veto !\n");
                c.couperGriffe();
            }

            if(a instanceof Oiseau o) {
                resume.append(o.getNom()).append(" fait ").append(o.crier()).append("\n");
            }
        }
        resume.append("\n");

        resume.append(" - Nuit \n");
        boolean deces = false;
        for (Animal a : this.animaux) {
            a.debuterNuit();

            if(a.isVivant() && a instanceof  Chien c) {
                resume.append(c.getNom()).append(" fait ").append(c.crier()).append("\n");
            }

            if(!a.isVivant()) {
                deces = true;
            }
        }

        if(deces) {
            resume.append("Le veto constate le décés d'un animal \n");
            retirerAnimauxdecede();
        }

        return resume.toString();
    }
    //endregion
}
