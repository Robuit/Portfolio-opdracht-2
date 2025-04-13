import java.util.ArrayList;
import java.util.Date;

abstract class Taak {
    protected String naam;
    protected String beschrijving;
    protected boolean voltooid;
    protected Gebruiker toegewezenAan;
    protected int punten;

    public Taak(String naam, String beschrijving, int punten) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.punten = punten;
        this.voltooid = false;
    }

    public abstract void voerTaakUit();

    public void markeerAlsVoltooid() {
        this.voltooid = true;
    }

    public void overdragenAan(Gebruiker gebruiker) {
        this.toegewezenAan = gebruiker;
    }

    public String toonDetails() {
        return "Taak: " + naam + ", Beschrijving: " + beschrijving;
    }

    public int geefPunten() {
        return punten;
    }
}

class EenmaligeTaak extends Taak {
    public EenmaligeTaak(String naam, String beschrijving, int punten) {
        super(naam, beschrijving, punten);
    }

    @Override
    public void voerTaakUit() {
        markeerAlsVoltooid();
    }
}

class HerhalendeTaak extends Taak {
    private int frequentie; //

    public HerhalendeTaak(String naam, String beschrijving, int punten, int frequentie) {
        super(naam, beschrijving, punten);
        this.frequentie = frequentie;
    }

    @Override
    public void voerTaakUit() {
        System.out.println("Herhalende taak uitgevoerd: " + naam);
    }
}

class Gebruiker {
    private String naam;
    private int totaalPunten;

    public Gebruiker(String naam) {
        this.naam = naam;
        this.totaalPunten = 0;
    }

    public void ontvangPunten(int punten) {
        totaalPunten += punten;
    }

    public String getGebruikersnaam() {
        return naam;
    }

    public int getTotaalPunten() {
        return totaalPunten;
    }
}

class RewardTrack {
    private int huidigeProgressie;
    private int puntenVoorVolgendeCredit;
    private int credits;

    public RewardTrack(int puntenVoorVolgendeCredit) {
        this.puntenVoorVolgendeCredit = puntenVoorVolgendeCredit;
        this.huidigeProgressie = 0;
        this.credits = 0;
    }

    public void voegPuntenToe(int punten) {
        huidigeProgressie += punten;
        while (huidigeProgressie >= puntenVoorVolgendeCredit) {
            credits++;
            huidigeProgressie -= puntenVoorVolgendeCredit;
        }
    }

    public int getCredits() {
        return credits;
    }
}

class Feedback {
    private String bericht;
    private Date datum;
    private Gebruiker gebruiker;

    public Feedback(String bericht, Gebruiker gebruiker) {
        this.bericht = bericht;
        this.gebruiker = gebruiker;
        this.datum = new Date();
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public String getBericht() {
        return bericht;
    }
}

class Groep {
    private String naam;
    private ArrayList<Gebruiker> leden;
    private ArrayList<Taak> taken;

    public Groep(String naam) {
        this.naam = naam;
        this.leden = new ArrayList<>();
        this.taken = new ArrayList<>();
    }

    public void voegLidToe(Gebruiker gebruiker) {
        leden.add(gebruiker);
    }

    public void voegTaakToe(Taak taak) {
        taken.add(taak);
    }
}

// Hier had ik ChatGPT om hulp gevraagd
class Leaderboard {
    private ArrayList<Gebruiker> gebruikers;

    public Leaderboard() {
        gebruikers = new ArrayList<>();
    }

    public void voegGebruikerToe(Gebruiker gebruiker) {
        gebruikers.add(gebruiker);
    }

    public void toonTopSpelers() {
        gebruikers.sort((a, b) -> b.getTotaalPunten() - a.getTotaalPunten());
        for (Gebruiker g : gebruikers) {
            System.out.println(g.getGebruikersnaam() + ": " + g.getTotaalPunten() + " punten");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Gebruiker robin = new Gebruiker("Robin");
        Gebruiker hamza = new Gebruiker("Hamza");


        Groep schoonmaakTeam = new Groep("Schoonmaakteam");
        schoonmaakTeam.voegLidToe(robin);
        schoonmaakTeam.voegLidToe(hamza);

        EenmaligeTaak ramenWassen = new EenmaligeTaak("Ramen wassen", "Maak de ramen schoon", 20);
        HerhalendeTaak afwas = new HerhalendeTaak("Afwas", "Doe de afwas", 10, 1);

        schoonmaakTeam.voegTaakToe(ramenWassen);
        schoonmaakTeam.voegTaakToe(afwas);

        ramenWassen.overdragenAan(robin);
        afwas.overdragenAan(hamza);

        ramenWassen.voerTaakUit();
        afwas.voerTaakUit();

        robin.ontvangPunten(ramenWassen.geefPunten());
        hamza.ontvangPunten(afwas.geefPunten());

        RewardTrack rewardRobin = new RewardTrack(50);
        RewardTrack rewardHamza = new RewardTrack(50);

        rewardRobin.voegPuntenToe(ramenWassen.geefPunten());
        rewardHamza.voegPuntenToe(afwas.geefPunten());

        System.out.println("Robin heeft " + rewardRobin.getCredits() + " credit(s).");
        System.out.println("Hamza heeft " + rewardHamza.getCredits() + " credit(s).");

        Feedback feedbackRobin = new Feedback("Goed gedaan met het wassen van de ramen!", robin);
        Feedback feedbackHamza = new Feedback("Netjes gewerkt met de afwas!", hamza);

        System.out.println("Feedback van " + feedbackRobin.getGebruiker().getGebruikersnaam() + ": " + feedbackRobin.getBericht());
        System.out.println("Feedback van " + feedbackHamza.getGebruiker().getGebruikersnaam() + ": " + feedbackHamza.getBericht());

        //Hier ook hulp nodig
        Leaderboard board = new Leaderboard();
        board.voegGebruikerToe(robin);
        board.voegGebruikerToe(hamza);

        System.out.println("\n--- Leaderboard ---");
        board.toonTopSpelers();

        System.out.println("\nTaakdetails:");
        System.out.println(ramenWassen.toonDetails());
        System.out.println(afwas.toonDetails());
    }
}