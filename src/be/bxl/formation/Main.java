package be.bxl.formation;

import be.bxl.formation.enumerations.HabitationOiseau;
import be.bxl.formation.enumerations.LongeurPoil;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Animalerie animalerie = new Animalerie("Mon animalerie");

        //TODO Faire une interface utilisateur


        Animal a1 = new Chien("Robert", 2, 20, Sexe.M, 1, LocalDate.of(2021, 6, 13),
                "Chihuahua", "Rose bonbon", false);

        Animal a2 = new Chien("Rex", 30, 100, Sexe.M, 5, LocalDate.now(),
                "labrador", "Bleu", true);

        animalerie.ajouterAnimal(a1);
        animalerie.ajouterAnimal(a2);

        animalerie.ajouterAnimal(new Chat("Poupouse", 6, 50, Sexe.F, 7,
                LocalDate.of(2021, 6, 14), "Calin", LongeurPoil.LONG));

        animalerie.ajouterAnimal(new Oiseau("Titi", 0.01, 10, Sexe.F, 5,
                LocalDate.now(), "Jaune", HabitationOiseau.PETITE_CAGE));

        animalerie.ajouterAnimal(new Chat("Le chat", 3, 40, Sexe.M, 6,
                LocalDate.of(2021, 1, 14), "Joueur", LongeurPoil.COURT));


        System.out.println("Debut de simulation");
        System.out.println("###################");

        int jour = 1;

        while(!animalerie.getAnimaux().isEmpty()) {
            System.out.println("Jour " + jour + " :");

            System.out.printf(" - Liste des animaux (Chat %s, Chien %s, Oiseau %s)\n",
                    animalerie.getNbChat(), animalerie.getNbChien(), animalerie.getNbOiseau());

            for (Animal a : animalerie.getAnimaux()) {
                System.out.println("\t " + a);
            }
            System.out.println();

            String events = animalerie.simulationJournee();
            System.out.println(events);

            jour++;

            // Attente de la réaction de l'utilisation
            sc.nextLine();
        }



        sc.close();
    }

}
