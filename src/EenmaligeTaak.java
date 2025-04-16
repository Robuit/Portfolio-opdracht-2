public class EenmaligeTaak extends Taak {
    public EenmaligeTaak(String naam, String beschrijving, int punten) {
        super(naam, beschrijving, punten);
    }

    @Override
    public void voerTaakUit() {
        markeerAlsVoltooid();
    }
}