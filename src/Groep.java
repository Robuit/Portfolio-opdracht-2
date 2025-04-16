import java.util.ArrayList;

public class Groep {
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