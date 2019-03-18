package data;

import personen.Interviewer;
import personen.Persoon;
import personen.TweedeKamerlid;

import java.util.ArrayList;
import java.util.Random;


/* TODO optimalisatie (memory-management) */

public class Data {
    private static Random rnd = new Random();
    private static ArrayList<Interviewer> interviewers = new ArrayList<Interviewer>();
    private static ArrayList<TweedeKamerlid> kamerleden = new ArrayList<>();
    private static ArrayList<ArrayList<? extends Persoon>> personen = new ArrayList<>();
    
    public static ArrayList<TweedeKamerlid> getKamerleden() { 
        //LAZY LOADING
        if (kamerleden.size() > 0) return kamerleden;

        TweedeKamerlid lilian = new TweedeKamerlid();
        lilian.setGeboortedatum("11 juli 1985");
        lilian.setGender('V');
        lilian.setNaam("Lilian");
        lilian.setPartij("SP");

        TweedeKamerlid jesse = new TweedeKamerlid();
        jesse.setGeboortedatum("1 mei 1986");
        jesse.setGender('M');
        jesse.setNaam("Jesse");
        jesse.setPartij("GroenLinks");
        
        TweedeKamerlid thieme = new TweedeKamerlid();
        thieme.setGeboortedatum("6 maart 1972");
        thieme.setGender('V');
        thieme.setNaam("Thieme");
        thieme.setPartij("PvdD");
        
        TweedeKamerlid rutte = new TweedeKamerlid();
        rutte.setGeboortedatum("14 februari 1967");
        rutte.setGender('M');
        rutte.setNaam("Rutte");
        rutte.setPartij("VVD");
        
        TweedeKamerlid baudet = new TweedeKamerlid(); 
        baudet.setGeboortedatum("28 januari 1983");
        baudet.setGender('M');
        baudet.setNaam("Baudet");
        baudet.setPartij("FvD");
        
        TweedeKamerlid agema = new TweedeKamerlid();
        agema.setGeboortedatum("16 september 1976");
        agema.setGender('V');
        agema.setNaam("Agema");
        agema.setPartij("PVV");
        
        kamerleden.add(thieme);
        kamerleden.add(rutte);
        kamerleden.add(baudet);
        kamerleden.add(agema);
        
        personen.add(kamerleden);
        return kamerleden;
    }
    
    
    public static ArrayList<Interviewer> getPersmuskieten() { 
        // LAZY LOADING
        if (interviewers.size() > 0) return interviewers;
        
        Interviewer castricum = new Interviewer();
        castricum.setNaam("Rutger van Castricum");
        castricum.setGender('M');
        castricum.setGeboortedatum("29 mei 1979)");
        castricum.setOmroep("PowNeds");
        
        Interviewer plag = new Interviewer();
        plag.setNaam("Ghislaine Plag");
        plag.setGender('V');
        plag.setGeboortedatum("4 juni 1975");
        plag.setOmroep("NCRV");
        
        Interviewer berg = new Interviewer();
        berg.setNaam("Jurgen van den Berg");
        berg.setGender('M');
        berg.setGeboortedatum("8 december 1964");
        berg.setOmroep("NCRV");
        
        Interviewer veenhoven = new Interviewer();
        veenhoven.setNaam("Willemijn Veenhoven");
        veenhoven.setGender('V');
        veenhoven.setGeboortedatum("19 november 1974");
        veenhoven.setOmroep("BNN");
        
        interviewers.add(castricum);
        interviewers.add(plag);
        interviewers.add(berg);
        interviewers.add(veenhoven);      
        
        personen.add(interviewers);
        return interviewers;
    }
    
    public static Interviewer getRandomInterviewer() {
        int foo = rnd.nextInt(getPersmuskieten().size());
        return getPersmuskieten().get(foo);
    }
    
    public static TweedeKamerlid getRandomPoliticus() {
        int foo = rnd.nextInt(getKamerleden().size());
        return getKamerleden().get(foo);
    }
    
    public static ArrayList<ArrayList<? extends Persoon>> getPersonen() {
        return personen;
    }
}
