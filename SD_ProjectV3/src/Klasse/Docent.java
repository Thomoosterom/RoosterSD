package Klasse;
import java.util.Objects;

public class Docent {
    private String naam;
    private String mailadres;
    private Klas klas;

    public Docent(String nm, String em) {
        naam = nm;
        mailadres = em;
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
