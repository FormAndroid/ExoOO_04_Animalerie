package be.bxl.formation.helpers;

/**
 * Classe helper pour gérer les valeurs aleatoire.
 */
public class RandomManager {

    /**
     * Cette méthode permet d'obtenir une valeur aleatoire entre 0 et 100, avec 2 décimal.
     * @return Une probabilité
     */
    public static double obtenirProbabilite() {
        return Math.round(Math.random() * 10000) / 100.0;
    }


    /**
     * Cette méthode permet d'obtenir une valeur aleatoire entre 2 entier
     * @param valeurMin La valeur minimum
     * @param valeurMax La valeur maximum
     * @return La valeur aleatoire
     */
    public static int obtenirEntier(int valeurMin, int valeurMax) {
        if(valeurMin > valeurMax) {
            throw new IllegalArgumentException("Les valeurs ne sont pas correct !");
        }

        return (int)Math.round(Math.random() * (valeurMax - valeurMin)) + valeurMin;
    }
}
