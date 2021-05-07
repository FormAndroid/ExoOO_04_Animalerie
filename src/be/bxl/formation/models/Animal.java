package be.bxl.formation.models;

import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.helpers.RandomManager;

import java.time.LocalDate;

public abstract class Animal {

    //region Champs
    private String nom;
    private double poids;
    private double taille;
    private Sexe sexe;
    private int age;
    private LocalDate dateArrive;

    private boolean vivant;
    //endregion

    //region Encapsulation - Getters
    public String getNom() {
        return nom;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateArrive() {
        return dateArrive;
    }

    public boolean isVivant() {
        return vivant;
    }

    protected abstract double getProbaDeces();
    //endregion

    //region Encapsulation - Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateArrive(LocalDate dateArrive) {
        this.dateArrive = dateArrive;
    }
    //endregion

    //region Constructeur
    public Animal(String nom, double poids, double taille, Sexe sexe, int age, LocalDate dateArrive) {
        this.setNom(nom);
        this.setPoids(poids);
        this.setTaille(taille);
        this.setSexe(sexe);
        this.setAge(age);
        this.setDateArrive(dateArrive);
        this.vivant = true;
    }
    //endregion

    //region Méthode
    public abstract String crier();

    protected void mourir() {
        this.vivant = false;
    }

    public void debuterJour() {

    }

    public void debuterNuit() {
        double proba = RandomManager.obtenirProbabilite();

        if (proba <= getProbaDeces()) {
            mourir();
        }
    }

    @Override
    public String toString() {
        return getNom() + " (" + getSexe() + ")";
    }

    public String sePresenter() {
        return String.format("%s - Age %s ans, Taille %s cm, Poids %s Kg, Date d'arrive %s",
                this.toString(), getAge(), getTaille(), getPoids(), getDateArrive());
    }
    //endregion
}
