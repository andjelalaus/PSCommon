/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import rs.ac.bg.fon.ps.PSCommon.domain.GenericEntity;

/**
 * Klasa Karta koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja ulaznicu za datu predstavu koja je rezervisana putem stavke rezervacije i klijenta koji je naprvio tu rezervaciju
 * Ima i svoj atribut cenu
 * @author andelalausevic
 */
public class Karta implements GenericEntity {
    /**
     * Predstavlja jedinstveni identifikator karte
     */
    private Integer kartaId;
    /**
     * Predstavlja cenu karte
     */
    private int cena;
    /**
     * Predstavlja rezervaciju koja je vezana za kartu
     */
    private Rezervacija rezervacijaId;
    /**
     * Predstavlja stavke rezervacije vezane za kartu
     */
    private StavkaRezervacije stavkaId;

    /**
     * Neparametrizovan konstruktor
     */
    public Karta() {
    }

    /**
     * Parametrizovan konstruktor koji setuje vrednosti za id, cenu, rezervaciju i stavku
     * @param kartaId id karte koji se setuje 
     * @param cena  cena karte koji se setuje
     * @param rezervacijaId rezervacija koja je vezana za kartu
     * @param stavkaId stavka koja je vezana za rezervaciju
     */
    public Karta(Integer kartaId, int cena, Rezervacija rezervacijaId, StavkaRezervacije stavkaId) {
        this.kartaId = kartaId;
        this.cena = cena;
        this.rezervacijaId = rezervacijaId;
        this.stavkaId = stavkaId;
    }
/**
 * Metoda koja vraca id karte
 * @return kartaId u integer formatu
 */
    public Integer getKartaId() {
        return kartaId;
    }
/**
 * Metoda koja vraca cenu karte
 * @return cena u obliku broja int
 */
    public int getCena() {
        return cena;
    }
/**
 * Metoda koja vraca objekat rezervacija koji je vezan za kartu
 * @return rezervacijaId odnosno rezervacija karte
 */
    public Rezervacija getRezervacijaId() {
        return rezervacijaId;
    }
/**
 * Metoda koja vraca stavkurezervacije koja je vezana za kartu
 * @return stavkaId kao objekat stavke
 */
    public StavkaRezervacije getStavkaId() {
        return stavkaId;
    }
/**
 * Metoda koja postavlja id karte na prosledjeni parametar
 * @param kartaId koja se setuje za karta id
 * @throws IllegalArgumentException ako je id manji od 0
 */
    public void setKartaId(Integer kartaId) {
        if(kartaId<0){
            throw new IllegalArgumentException("Ne moze id karte biti manji od 0");
        }
        this.kartaId = kartaId;
    }
/**
 * Metoda koja postavlja cenu karte
 * @param cena koju atribut cena trebba da dobije
 * @throws IllegalArgumentException ako je cena manja od 0
 */
    public void setCena(int cena) {
          if(cena<0){
            throw new IllegalArgumentException("Ne moze cena karte biti manja od 0");
        }
        this.cena = cena;
    }
/**
 * Metoda za postavljanje rezervacije na prosledjenu vrednost
 * @param rezervacijaId koji se stavlja kao vrednost atributa rezervacije prosledjuje se objekat rezervacije 
 * @throws NullPointerException ako je rezervacija null
 * 
 */
    public void setRezervacijaId(Rezervacija rezervacijaId) {
        if(rezervacijaId==null){
            throw new NullPointerException("Rezervacija mora da postoji za kartu");
        }
        this.rezervacijaId = rezervacijaId;
    }
/**
 * Metoda za postavljanje stavke na prosledjenu vrednost
 * @param stavkaId koji se stavlja kao vrednost atributa stavke prosledjuje se objekat stavke 
 * @throws NullPointerException ako je stavka null ona mora da postoji
 */
    public void setStavkaId(StavkaRezervacije stavkaId) {
           if(stavkaId==null){
            throw new NullPointerException("Stavka mora da postoji za kartu");
        }
        this.stavkaId = stavkaId;
    }
/**
 * Metoda za hash code koji inicijalno ima vrednost 3
 * zatim se setuje za atribute karte kao sto su id rezervacija i stavka
 * @return hash odnosno vrednost hash koda
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.kartaId);
        hash = 83 * hash + this.cena;
        hash = 83 * hash + Objects.hashCode(this.rezervacijaId);
        hash = 83 * hash + Objects.hashCode(this.stavkaId);
        return hash;
    }
/**
 * Metoda za proveru da li je prosledjeni objekat jednak postojecoj karti
 * proveravada li je objekat null ako jeste vraca false
 * proverava da li su iste klase ako nisu vraca false
 * ako im id, rezervacija ili stavka nisu iste vraca false
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
        final Karta other = (Karta) obj;
        if (this.cena != other.cena) {
            return false;
        }
        if (!Objects.equals(this.kartaId, other.kartaId)) {
            return false;
        }
        if (!Objects.equals(this.rezervacijaId, other.rezervacijaId)) {
            return false;
        }
        return Objects.equals(this.stavkaId, other.stavkaId);
    }
/**
 * Metoda za vracanja u string formatu vrednosti atributa objekta karte, svi atributi su ukljuceni
 * id,cena,rzervacija,stavka
 * @return string u kom su svi atributi kaarte
 */
    @Override
    public String toString() {
        return "Karta{" + "kartaId=" + kartaId + ", cena=" + cena + ", rezervacijaId=" + rezervacijaId + ", stavkaId=" + stavkaId + '}';
    }

    @Override
    public String getTableName() {
        return "karta";
    }

    @Override
    public String getColumnNamesForInsert() {
         return "cena,rezervacijaId,stavkaId";
    }

    @Override
    public String getInsertValues() {
         StringBuilder sb = new StringBuilder();
        sb.append(cena).append(",")
                .append(rezervacijaId.getRezervacijaId()).append(",")
                .append(stavkaId.getStavkaId());
        System.out.println(sb.toString());
        return sb.toString();
    }



    @Override
    public String getWhereCondition(Object object) {
        return "k.kartaId="+((Karta)object).getKartaId() + " AND k.rezervacijaId="+((Karta)object).getRezervacijaId().getRezervacijaId() + " AND k.stavkaId="+((Karta)object).getStavkaId().getStavkaId();
    }

    @Override
    public String getSelectValues() {
         return "SELECT k.kartaId,k.cena,k.rezervacijaId,k.stavkaId,r.brojPredstave,r.klijentId,kl.ime,kl.prezime,kl.email,kl.status,s.popust,s.brojSedista,s.gledato,s.predstavaId,p.naziv,p.mesto,p.vreme,p.kapacitet  FROM karta AS k INNER JOIN rezervacija AS r ON r.rezervacijaId=k.rezervacijaId INNER JOIN stavkarezervacije AS s ON r.rezervacijaId=s.rezervacijaId INNER JOIN predstava p ON p.predstavaId = s.predstavaId INNER JOIN klijent kl ON kl.KlijentId = r.klijentId";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "kartaId="+((Karta)object).getKartaId() + " AND rezervacijaId="+((Karta)object).getRezervacijaId().getRezervacijaId() + " AND stavkaId="+((Karta)object).getStavkaId().getStavkaId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Karta karta = (Karta)object;
        return "cena="+karta.getCena();
    }

    @Override
    public String getCreateInsertValues() {
        //pitati ovo
        StringBuilder sb = new StringBuilder();
        sb.append(kartaId).append(",")
                .append(stavkaId.getStavkaId()).append(",")
                .append(rezervacijaId.getRezervacijaId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        
       //i ovo
        return "kartaId,stavkaId,rezervacijaId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        
        
        
        Predstava p = new Predstava();
        p.setPredstavaId(rs.getInt("predstavaId"));
        p.setNaziv(rs.getString("naziv"));
        p.setMesto(rs.getString("mesto"));
        p.setVreme(rs.getTimestamp("vreme").toLocalDateTime());
        p.setKapacitet(rs.getInt("kapacitet"));

        
        Klijent kl = new Klijent();
        kl.setIme(rs.getString("ime"));
        kl.setPrezime(rs.getString("prezime"));
        kl.setKlijentId(rs.getInt("klijentId"));
        kl.setStatus(rs.getString("status"));
        kl.setEmail(rs.getString("email"));
        
        Rezervacija r = new Rezervacija();
        r.setRezervacijaId(rs.getInt("rezervacijaId"));
        r.setBrojPredstave(rs.getInt("brojPredstave"));
        r.setKlijentId(kl);
        
        StavkaRezervacije st=new StavkaRezervacije();
        st.setStavkaId(rs.getInt("stavkaId"));
        st.setPredstavaId(p);
        st.setBrojSedista(rs.getInt("brojSedista"));
        st.setGledato(rs.getBoolean("gledato"));
        st.setRezervacijaId(r);
        st.setPopust(rs.getInt("popust"));
        
       
              
        
        return new Karta(rs.getInt("kartaId"),rs.getInt("cena") , r, st);
    }

    @Override
    public void setId(Integer id) {
        this.kartaId = id;
    }
    
    
}
