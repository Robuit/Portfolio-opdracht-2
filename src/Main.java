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