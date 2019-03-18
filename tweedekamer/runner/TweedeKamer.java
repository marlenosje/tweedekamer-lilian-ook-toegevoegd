package runner;

import java.util.ArrayList;
import java.util.Scanner;

import personen.Interviewer;
import personen.Persoon;
import personen.TweedeKamerlid;
import data.Data;

public class TweedeKamer {
    private ArrayList<ArrayList<Persoon>> personen;

    public TweedeKamer() {
        System.out.println("Welkom in de Tweede Kamer.");
        System.out.println("Hieronder staande mogelijke activiteiten:");

        boolean loop = true;
        Scanner reader = new Scanner(System.in);
        while (loop) {
            toonKeuzeMenu();
            String input = reader.next();

            switch(input) {
                case "1": debateer();break;
                case "2": interview();break;
                case "3": toonMensenInHetGebouw();break;
                case "bye": System.out.println("Graag tot een volgende keer."); loop = false; break;
                default: System.out.println("Onbekende input"); toonKeuzeMenu();
            }

        }
        reader.close();
    }

    private void debateer() {
        int i = 0;
        TweedeKamerlid k;
        while (++i<20) {
            k = Data.getRandomPoliticus();
            System.out.print("(Lid " +k.getNaam()+"): ");
            System.out.println(k.reageer());
        }
    }

    private void interview() {
        Interviewer interviewer = Data.getRandomInterviewer();
        TweedeKamerlid politicus = Data.getRandomPoliticus();

        System.out.println("Goedemiddag, " +interviewer.getNaam()
            + " hier, voor de omroep " +interviewer.getOmroep());
        System.out.print("We spreken vandaag met " +politicus.getNaam());
        System.out.println("(geboren op " +politicus.getGeboortedatum() + ")");
        System.out.println("Die is lid van de tweede kamer voor " +politicus.getpartij());

        int i = 0;
        while (i++<20) {
            System.out.println(i);
            System.out.println("V: " +interviewer.StelMoeilijkeVraag());
            System.out.println("A: " +politicus.reageer());
        }
    }

    private void toonMensenInHetGebouw() {
        System.out.println("Momenteel bevinden zich de volgende personen in het gebouw:");
        String aanhef = "";

        // TEST: welke optimalisatie zien we in de loop hier beneden (hint: memory leak)?
        for (ArrayList<? extends Persoon> lijst: Data.getPersonen()){
            for (Persoon p: lijst) {
                aanhef = p.getGender()=='M' ? "De heer " : "Mevrouw ";
                System.out.print(aanhef+p.getNaam());
                System.out.println(", geboren " + p.getGeboortedatum());
            }
        }
    }

    private void toonKeuzeMenu() {
        System.out.println("\n\n  1. volg een debat.");
        System.out.println("  2. bekijk een interview.");
        System.out.println("  3. kijk wie er allemaal in het gebouw zijn.");
        System.out.println("Typ uw keuze:");
    }
}
