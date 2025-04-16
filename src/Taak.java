public abstract class Taak {
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