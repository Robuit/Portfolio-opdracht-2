public class HerhalendeTaak extends Taak {
    private int frequentie;

    public HerhalendeTaak(String naam, String beschrijving, int punten, int frequentie) {
        super(naam, beschrijving, punten);
        this.frequentie = frequentie;
    }

    @Override
    public void voerTaakUit() {
        System.out.println("Herhalende taak uitgevoerd: " + naam);
    }
}