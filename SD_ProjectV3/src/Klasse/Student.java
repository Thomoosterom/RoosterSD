package Klasse;


import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    private static Student deStudent;
    public static void setDeStudent(Student student){ deStudent = student;}
    public static Student getDeStudent(){ return deStudent;}
    
    private String naam;
    private String email;
    private String status;
    private String reden;
    private LocalDate ziekDatum, afwezigDatumBegin, afwezigDatumEinde;

    public Student(String st, LocalDate zd, LocalDate adb, LocalDate ade) {
        status = st;
        ziekDatum=zd;
        afwezigDatumBegin = adb;
        afwezigDatumEinde = ade;
    }

    public Student(String nm, String em, String st) {
        naam = nm;
        email = em;
        status = st;
    }

    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getReden() {return reden;}

    public void setStatus(String s) {
        if (s.equals("aanwezig")|| s.equals("afwezig")) {
            status = s;
        }
    }

    public void setReden(String r){
        reden = r;
    }

    @Override
    public boolean equals(Object object) {
        boolean gelijk = object instanceof Student;

        gelijk = gelijk && ((Student) object).naam.equals(naam);
        gelijk = gelijk && ((Student) object).email.equals(email);

        return gelijk;
    }

    public String toString() {
        return email;
    }
    }
