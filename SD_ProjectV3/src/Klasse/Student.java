package Klasse;


import java.time.LocalDate;

public class Student {
    private static Student deStudent;
    public static void setDeStudent(Student student){ deStudent = student;}
    public static Student getDeStudent(){ return deStudent;}
    
    private String naam;
    private String email;
    private String status;
    private String reden;
    private String wachtwoord;
    private LocalDate ziekDatum, afwezigDatumBegin, afwezigDatumEinde;

    public Student(String ww, String st, LocalDate zd, LocalDate adb, LocalDate ade) {
        status = st;
        ziekDatum=zd;
        afwezigDatumBegin = adb;
        afwezigDatumEinde = ade;
        wachtwoord = ww;
    }

    public Student(String ww,String nm, String em, String st) {
        wachtwoord = ww;
        naam = nm;
        email = em;
        status = st;
    }

    public LocalDate getAfwezigDatumBegin(){ return afwezigDatumBegin;}

    public LocalDate getAfwezigDatumEinde(){ return afwezigDatumEinde;}

    public LocalDate getZiekDatum(){ return ziekDatum;}

    public String getNaam() {
        return naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
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

    public void setWachtwoord(String ww) {
        wachtwoord = ww;
    }

    public void setAfwezigDatumBegin(LocalDate afwezigDatumBegin) {
        this.afwezigDatumBegin = afwezigDatumBegin;
        ziekDatum = LocalDate.of(2030,01,01);
    }

    public void setAfwezigDatumEinde(LocalDate afwezigDatumEinde) {
        this.afwezigDatumEinde = afwezigDatumEinde;
        ziekDatum = LocalDate.of(2030,01,01);
    }

    public void setZiekDatum(LocalDate ziekDatum) {
        this.ziekDatum = ziekDatum;
        afwezigDatumBegin = LocalDate.of(2000,01,01);
        afwezigDatumEinde = LocalDate.of(2000,01,01);
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
