package be.bxl.formation.models;

import be.bxl.formation.enumerations.Sexe;

import java.time.LocalDate;

public class Chien extends Animal {

    private double PROBA_DECES = 1;

    //region Champs
    private String race;
    private String couleurCollier;
    private boolean dresse;
    //endregion

    //region Getters
    public String getRace() {
        return race;
    }

    public String getCouleurCollier() {
        return couleurCollier;
    }

    public boolean isDresse() {
        return dresse;
    }

    @Override
    protected double getProbaDeces() {
        return PROBA_DECES;
    }
    //endregion

    //region Setters
    public void setRace(String race) {
        this.race = race;
    }

    public void setCouleurCollier(String couleurCollier) {
        this.couleurCollier = couleurCollier;
    }

    public void setDresse(boolean dresse) {
        this.dresse = dresse;
    }
    //endregion

    //region Constructeur
    public Chien(String nom, double poids, double taille, Sexe sexe, int age, LocalDate dateArrive, String race, String couleurCollier, boolean dresse) {
        super(nom, poids, taille, sexe, age, dateArrive);
        this.race = race;
        this.couleurCollier = couleurCollier;
        this.dresse = dresse;
    }
    //endregion

    //region Méthode
    @Override
    public String crier() {
        return "Whoof";
    }
    //endregion
}
