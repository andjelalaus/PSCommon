/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Klasa Klijent koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja klijenta koji moze da napravi rezervaciju ili ostavi utisak o predstavi u planu gledanja
 * atributi su mu id,ime,prezime,email i status
 * @author andelalausevic
 */
public class Klijent implements GenericEntity{
    /**
     * Jedinstveni identifikacioni kljuc klijenta
     */
    private Integer klijentId;
    /**
     * Predstavlja ime klijenta u string formatu koji mora biti samo od slova
     */
    private String ime;
    /**
     * Predstavlja prezime klijenta u string formatu koji mora biti samo od slova
     */
    private String prezime;
    /**
     * Predstavlja email klijenta u string formatu koji mora biti u formi mejla
     */
    private String email;
    /**
     * Predstavlja da li je klijent student,penzioner,nezaposlen ili nesto trece zbog cega bi ostvario popust
     */
    private String status;
/**
 * Prazan konstruktor Klijent klase
 */
    public Klijent() {
    }

    /**
     * Parametrizovan konstruktor u kojem se postavljaju svi atributi klijenta
     * @param klijentId prosledjena vrednost koja se postavlja za klijentov id
     * @param ime prosledjena vrednost koja se postavlja za klijentovo ime
     * @param prezime prosledjena vrednost koja se postavlja za klijenovo prezime
     * @param email prosledjena vrednost koja se postavlja za klijentov mejl
     * @param status prosledjena vrednost koja se postavlja za klijentov status
     */
    public Klijent(Integer klijentId, String ime, String prezime, String email, String status) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.status = status;
    }
/**
 * Metoda koja vraca id klijenta
 * @return klijentId u integer formatu
 */
    public Integer getKlijentId() {
        return klijentId;
    }
/**
 * Metoda koja vraca ime klijenta
 * @return ime u string formatu
 */
    public String getIme() {
        return ime;
    }
/**
 * Metoda koja vraca prezime klijenta
 * @return prezime u string formatu
 */
    public String getPrezime() {
        return prezime;
    }
/**
 * Metoda koja vraca imejl klijenta
 * @return imejl u string formatu
 */
    public String getEmail() {
        return email;
    }
/**
 * Metoda koja vraca status klijenta
 * @return status u string formatu
 */
    public String getStatus() {
        return status;
    }
/**
 * Metoda koja postavlja id klijenta na prosledjeni parametar
 * @param klijentId u integer formatu koja se setuje za klijent id
 */
    public void setKlijentId(Integer klijentId) {
        this.klijentId = klijentId;
    }
/**
 * Metoda koja postavlja ime klijenta na prosledjeni parametar
 * @param ime u string formatu koja se setuje za klijentovo ime
 */
    public void setIme(String ime) {
        this.ime = ime;
    }
/**
 * Metoda koja postavlja prezime klijenta na prosledjeni parametar
 * @param prezime u string formatu koja se setuje za klijentovo prezime
 */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
/**
 * Metoda koja postavlja email klijenta na prosledjeni parametar
 * @param email u string formatu koja se setuje za klijentov email
 */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * Metoda koja postavlja status klijenta na prosledjeni parametar
 * @param status u string formatu koja se setuje za klijentov status
 */
    public void setStatus(String status) {
        this.status = status;
    }
/**
 * Metoda za hash code koji inicijalno ima vrednost 3
 * zatim se setuje za atribute klijenta kao sto su id ime prezime email
 * @return hash odnosno vrednost hash koda
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.klijentId);
        hash = 67 * hash + Objects.hashCode(this.ime);
        hash = 67 * hash + Objects.hashCode(this.prezime);
        hash = 67 * hash + Objects.hashCode(this.email);
        return hash;
    }
/**
 * Metoda za proveru da li je prosledjeni objekat jednak postojecom klijentu
 * proveravada li je objekat null ako jeste vraca false
 * proverava da li su iste klase ako nisu vraca false
 * ako im id, ime,prezime ili email nisu iste vraca false
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
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.klijentId, other.klijentId);
    }
/**
 * Metoda za vracanja u string formatu vrednosti atributa objekta klijent, svi atributi su ukljuceni
 * id,ime,prezime,email,status
 * @return string u kom su svi atributi klijenta
 */
    @Override
    public String toString() {
        return "Klijent{" + "klijentId=" + klijentId + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", status=" + status + '}';
    }

    @Override
    public String getTableName() {
        return "klijent";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime,prezime,email,status";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("',")
                .append("'").append(prezime).append("',")
                .append("'").append(email).append("',")
                .append("'").append(status).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        this.klijentId=id;
    }

    @Override
    public String getWhereCondition(Object object) {
         return "klijentId="+((Klijent)object).getKlijentId();
    }

    @Override
    public String getSelectValues() {
        return "SELECT klijentId,ime,prezime,email,status FROM klijent";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return getWhereCondition(object);
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Klijent klijent = (Klijent)object;
        return "ime="+ "'"+klijent.getIme()+"'"+", prezime="+"'"+klijent.getPrezime()+"'"+", email="+"'"+klijent.getEmail()+"'"+", status="+"'"+klijent.getStatus()+"'";
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(klijentId);
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "klijentId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
         return new Klijent(rs.getInt("klijentId"),rs.getString("ime"),rs.getString("prezime"),rs.getString("email"),rs.getString("status"));
    }

   

    
  

    
     
}
