package be.bxl.formation.models;

import be.bxl.formation.enumerations.HabitationOiseau;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.helpers.RandomManager;

import java.time.LocalDate;

public class Oiseau extends Animal {

    private final double PROBA_DECES = 3;

    //region Champs
    private String couleur;
    private HabitationOiseau habitat;
    //endregion

    //region Getters
    public String getCouleur() {
        return couleur;
    }

    public HabitationOiseau getHabitat() {
        return habitat;
    }

    @Override
    protected double getProbaDeces() {
        // Exemple d'une proba influencé par l'age
        return PROBA_DECES + (getAge() * 0.5);
    }
    //endregion

    //region Setters
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setHabitat(HabitationOiseau habitat) {
        this.habitat = habitat;
    }
    //endregion


    //region Constructeur
    public Oiseau(String nom, double poids, double taille, Sexe sexe, int age, LocalDate dateArrive, String couleur, HabitationOiseau habitat) {
        super(nom, poids, taille, sexe, age, dateArrive);
        this.couleur = couleur;
        this.habitat = habitat;
    }
    //endregion

    //region Méthode
    @Override
    public String crier() {
        int nb = RandomManager.obtenirEntier(1, 5);

        StringBuilder sb = new StringBuilder();
        sb.append("Cui Cui !");
        for (int i = 1; i < nb; i++) {
            sb.append("\t Cui Cui !");
        }
        return sb.toString();
    }

    @Override
    public String sePresenter() {
        String zone = (getHabitat() == HabitationOiseau.PETITE_CAGE) ? "une petite cage" : "une volliere";

        return "[Oiseau] " + super.sePresenter() + String.format(", de couleur %s, vie dans %s", getCouleur(), zone);
    }

    //endregion
}
