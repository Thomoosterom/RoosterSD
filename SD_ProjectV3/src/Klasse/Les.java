package Klasse;

import java.time.LocalDate;

public class Les {
    private LocalDate lesDatum, afwezigDatumBegin, afwezigDatumEinde;
    private String naam;
//    private Kamer geboekteKamer;

    protected Les(LocalDate ld, LocalDate bg, LocalDate ae, String nm) {
        naam = nm;
        lesDatum = ld;
        afwezigDatumBegin = bg;
        afwezigDatumEinde = ae;
    }
    public String getNaamLes() {
        return naam;
    }

    public LocalDate getlesDatum() {
        return lesDatum;
    }

    public LocalDate getAfwezigDatumBegin() {
        return afwezigDatumBegin;
    }

    public LocalDate getAfwezigDatumEinde() {
        return afwezigDatumEinde;
    }

    public boolean equals(Object obj) {
        boolean gelijk = obj instanceof Les;
        gelijk = gelijk && ((Les) obj).naam.equals(naam);
        gelijk = gelijk && ((Les) obj).lesDatum.isEqual(lesDatum);
        gelijk = gelijk && ((Les) obj).afwezigDatumBegin.isEqual(afwezigDatumBegin);
        gelijk = gelijk && ((Les) obj).afwezigDatumEinde.isEqual(afwezigDatumEinde);

        return gelijk;
    }
}
