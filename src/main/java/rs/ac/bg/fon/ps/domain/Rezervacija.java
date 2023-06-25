/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa Rezervacija koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja rezervaciju za datog klijenta 
 * moze u rezervaciji da se oznaci koliko predstavi klijent zeli da rezervise
 * rezervacija ima stavke rezervacije koje se odnosi na podatke o predstavama koje klijent zeli da gleda
 * @author andelalausevic
 */
public class Rezervacija implements GenericEntity{
     /**
     * Predstavlja jedinstveni identifikator rezervacije
     */
    private Integer rezervacijaId;
    /**
     * Predstavlja broj predstavi za koje klijent zeli da napravi rezervaciju
     */
    private Integer brojPredstave;
    /**
     * Predstavlja klijenta za kojeg se pravi rezervacija
     */
    private Klijent klijentId;

      /**
     * Predstavlja listu stvaki koje se nalaze u rezervaciji
     */
    private ArrayList<StavkaRezervacije> stavke;
      /**
     * Neparametrizovan konstruktor klase Rezervacija
     * u kojom se inicijalizuje lista stavki
     */
    public Rezervacija() {
        this.stavke = new ArrayList<>();
    }
    /**
     * Parametrizovan konstruktor koji setuje vrednosti za id, brojPredstavi, klijenta,stavke
     * stavke se inicijalizuju na praznu listu
     * @param rezervacijaId id rezervacije koji se setuje 
     * @param brojPredstave  broj predstavi za koje klijent pravi rezervaciju
     * @param klijentId predstavlja klijenta za kog se pravi rezervaciju
     */
    public Rezervacija(Integer rezervacijaId, Integer brojPredstave, Klijent klijentId) {
        this.rezervacijaId = rezervacijaId;
        this.brojPredstave = brojPredstave;
        this.klijentId = klijentId;
        this.stavke = new ArrayList<>();
    }
    
/**
 * Metoda koja postavlja id rezervacije na prosledjeni parametar
 * @param rezervacijaId koja se setuje za rezervaciju id
 */
    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }
/**
 * Metoda koja postavlja broj predstavi za koju se pravi rezervacije na prosledjeni parametar
 * @param brojPredstave koja se setuje za broj predstavi koji ce biti u rezervaciji
 */
    public void setBrojPredstave(Integer brojPredstave) {
        this.brojPredstave = brojPredstave;
    }
/**
 * Metoda koja postavlja klijenta za koju se pravi rezervacije na prosledjeni parametar
 * @param klijentId koja se setuje za klijenta koji ce biti u rezervaciji
 */
    public void setKlijentId(Klijent klijentId) {
        this.klijentId = klijentId;
    }
/**
 * Metoda koja vraca id rezervacije
 * @return rezervacijaId u integer formatu
 */
    public Integer getRezervacijaId() {
        return rezervacijaId;
    }
/**
 * Metoda koja vraca broj predstavi za koju je napravljena rezervacija
 * @return brojPredstave u integer formatu
 */
    public Integer getBrojPredstave() {
        return brojPredstave;
    }
/**
 * Metoda koja vraca klijenta za kog je napravljena rezervacija
 * @return klijentId koji predstavlja klijenta
 */
    public Klijent getKlijentId() {
        return klijentId;
    }

/**
 * Metoda koja vraca stavke koje se nalaze u  rezervaciji
 * @return stavke koje predstavljaju listu stavki koje sadrzi rezervacija 
 */
    public ArrayList<StavkaRezervacije> getStavke() {
        return stavke;
    }
/**
 * Metoda koja postavlja stavke koje se nalaze u rezervacije na prosledjeni parametar
 * @param stavke koja se setuje za stavke koje ce biti u rezervaciji
 */
    public void setStavke(ArrayList<StavkaRezervacije> stavke) {
        this.stavke = stavke;
    }
/**
 * Metoda za vracanja u string formatu vrednosti atributa objekta rezervacije, svi atributi su ukljuceni
 * id,brojPredstavi,klijentId
 * @return string u kom su svi atributi rezervacije
 */
    @Override
    public String toString() {
        return "Rezervacija{" + "rezervacijaId=" + rezervacijaId + ", brojPredstave=" + brojPredstave + ", klijentId=" + klijentId + '}';
    }
/**
 * Metoda za hash code koji inicijalno ima vrednost 3
 * zatim se setuje za atribute stavke kao sto su id,brojPredstave,klijent
 * @return hash odnosno vrednost hash koda
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.rezervacijaId);
        hash = 59 * hash + Objects.hashCode(this.brojPredstave);
        hash = 59 * hash + Objects.hashCode(this.klijentId);
        return hash;
    }
/**
 * Metoda za proveru da li je prosledjeni objekat jednak postojecoj rezervaciji
 * proverava da li je objekat null ako jeste vraca false
 * proverava da li su iste klase ako nisu vraca false
 * ako im id, brojpredstavi ili klijent nisu iste vraca false
 * u suprotnom vraca true
 * @param obj koji treba da se proveri da li je isti kao postojeci
 * @return false ako nisu isti ili true ako su isti
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rezervacija other = (Rezervacija) obj;
        if (!Objects.equals(this.rezervacijaId, other.rezervacijaId)) {
            return false;
        }
        if (!Objects.equals(this.brojPredstave, other.brojPredstave)) {
            return false;
        }
        return Objects.equals(this.klijentId, other.klijentId);
    }
 

   
    
    
   @Override
    public String getTableName() {
        return "rezervacija";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "brojPredstave,klijentId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(brojPredstave).append(",")
                .append(klijentId.getKlijentId());
        return sb.toString();
    }

  

    @Override
    public String getWhereCondition(Object object) {
         return "rezervacijaId="+((Rezervacija)object).getRezervacijaId();
    }

    @Override
    public String getSelectValues() {
        return "SELECT r.rezervacijaId,r.brojPredstave,r.klijentId,k.ime,k.prezime,k.status,k.email FROM rezervacija AS r INNER JOIN klijent AS k ON r.klijentId = k.klijentId";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "rezervacijaId="+((Rezervacija)object).getRezervacijaId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Rezervacija reserve = (Rezervacija)object;
        return "brojPredstave="+reserve.getBrojPredstave()+", klijentId="+reserve.getKlijentId().getKlijentId();
    }

    @Override
    public String getCreateInsertValues() {
         StringBuilder sb = new StringBuilder();
        sb.append(rezervacijaId);
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "rezervacijaId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        
        Klijent test = new Klijent();
        test.setId(rs.getInt("klijentId"));
        test.setIme(rs.getString("ime"));
        test.setPrezime(rs.getString("prezime"));
        test.setStatus(rs.getString("status"));
        test.setEmail(rs.getString("email"));   
        Rezervacija reserve = new Rezervacija(rs.getInt("rezervacijaId"),rs.getInt("brojPredstave"),test);
        
        return reserve;
    }

    @Override
    public void setId(Integer id) {
        this.rezervacijaId=id;
    }
    
    
}
