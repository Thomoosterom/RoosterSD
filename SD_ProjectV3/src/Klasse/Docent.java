package Klasse;
import java.util.Objects;

public class Docent {
    private String naam;
    private String mailadres;
    private Klas klas;
    private String wachtwoord;

    public Docent(String ww,String nm, String em) {
        wachtwoord = ww;
        naam = nm;
        mailadres = em;
    }
    public void setWachtwoord(String ww) {
        wachtwoord = ww;
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
    public Docent(String em) {
        mailadres = em;
    }

    public String getNaam() {
        return naam;
    }

    public String getMailadres() {
        return mailadres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docent docent = (Docent) o;
        return Objects.equals(naam, docent.naam) && Objects.equals(mailadres, docent.mailadres);
    }
    public String toString() {
        return mailadres;
    }
}    
