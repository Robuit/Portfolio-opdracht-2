import java.util.ArrayList;

public class Leaderboard {
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