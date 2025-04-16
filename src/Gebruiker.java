public class Gebruiker {
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