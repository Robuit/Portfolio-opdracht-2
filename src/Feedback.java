import java.util.Date;

public class Feedback {
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