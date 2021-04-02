package Klasse;
import java.util.ArrayList;
import java.util.List;

public class Klas {
    private static Klas deKlas;
    private String naam;
    private List<Docent> alleDocenten;
    private List<Student> alleStudenten;
    private Student student;
    private Docent docent;
    private Les les;


    public static void setKlas(Klas klas) {
        deKlas = klas;
    }

    public static Klas getKlas() {
        return deKlas;
    }

    public Klas(String nm) {
        naam = nm;
        alleStudenten = new ArrayList<>();
        alleDocenten = new ArrayList<>();
    }

    public void setStudent(Student s) {
        student = s;
    }
    public void setDocent(Docent d) {
        docent = d;

    }
    public Les getLes() {
        return les;
    }

    public List<Docent> getDocenten() {
        return alleDocenten;
    }

    public Student getStudent() {
        return student;
    }

    public Docent getDocent() {
        return docent;
    }

    public List<Student> getStudenten() {
        return alleStudenten;

    }

    public void voegStudentToe(Student st) throws Exception {
        if (st == null) {
                throw new Exception("Email of naam is niet volledig");

        }

        alleStudenten.add(st);
    }

    public void voegDocentToe(Docent doc) throws Exception {
        if (doc == null) {
            throw new Exception("Email of naam is niet volledig");
            }
        alleDocenten.add(doc);


    }
    public String toString() {
        return "String van school";
    }
}



