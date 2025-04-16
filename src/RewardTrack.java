public class RewardTrack {
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