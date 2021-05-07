package be.bxl.formation.models;

import be.bxl.formation.enumerations.LongeurPoil;
import be.bxl.formation.enumerations.Sexe;

import java.time.LocalDate;

public class Chat extends Animal {

    private final double PROBA_DECES = 0.5;
    private final int GRIFFE_MIN = 0;
    private final int GRIFFE_MAX = 5;

    //region Champs
    private String caractere;
    private LongeurPoil poil;
    private int griffe;
    //endregion

    //region Getters
    public String getCaractere() {
        return caractere;
    }

    public LongeurPoil getPoil() {
        return poil;
    }

    public boolean isGriffeCoupe() {
        return griffe < GRIFFE_MAX;
    }

    @Override
    protected double getProbaDeces() {
        return PROBA_DECES;
    }

    //endregion

    //region Setters
    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    public void setPoil(LongeurPoil poil) {
        this.poil = poil;
    }

    private void setGriffe(int griffe) {
        if(griffe < GRIFFE_MIN) {
            throw  new IllegalArgumentException("Taille minimum de " + GRIFFE_MIN);
        }
        this.griffe = griffe;
    }
    //endregion

    //region Constructeur
    public Chat(String nom, double poids, double taille, Sexe sexe, int age, LocalDate dateArrive,
                String caractere, LongeurPoil poil) {
        super(nom, poids, taille, sexe, age, dateArrive);
        setCaractere(caractere);
        setPoil(poil);
        couperGriffe();
    }
    //endregion

    //region Méthode
    public void couperGriffe() {
        setGriffe(GRIFFE_MIN);
    }

    private void fairePousserGriffe() {
        setGriffe(this.griffe + 1);
    }

    @Override
    public String crier() {
        return "Miaou !";
    }

    @Override
    public void debuterJour() {
        super.debuterJour();
        fairePousserGriffe();
    }

    @Override
    public String sePresenter() {
        String typePoil = (getPoil() == LongeurPoil.COURT) ? "à poil cout" : "à poil long";

        return "[Chat] " + super.sePresenter() + String.format(", %s, %s", getCaractere(), typePoil);
    }
    //endregion
}
