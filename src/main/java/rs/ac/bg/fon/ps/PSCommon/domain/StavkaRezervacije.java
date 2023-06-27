/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


/**
 * Klasa StavkaRezervacije koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja stavke rezervacije za datu rezervaciju 
 * moze u stavci rezervaciji da se oznaci za koju predstavu se pravi rezervacija, koji broj sedista zeli za tu predstavu
 * da li je vec gledao korisnik tu predstavu i koji popust moze da ostvari
 * @author andelalausevic
 */
public class StavkaRezervacije implements GenericEntity{
      /**
     * Predstavlja jedinstveni identifikator stavke
     */
    private Integer stavkaId;
    /**
     * Predstavlja broj koji oznacava popust od 0 do 100 moze imati vrednosti koji klijent moze da ima na osnovu statusa njegovog
     */
    private int popust;
    /**
     * Predstavlja broj sedista za predstavu za koju klijent zeli da napravi rezervaciju
     */
    private int brojSedista;
    /**
     * Predstavlja da li je klijnet vec gledao predstavu
     */
    private boolean gledato;
    /**
     * Predstavlja rezervaciju za koju je vezana stavka
     */
    private Rezervacija rezervacijaId;
    /**
     * Predstavlja predstavu za koje klijent zeli da napravi rezervaciju
     */
    private Predstava predstavaId;
     /**
     * Neparametrizovan konstruktor klase StavkaRezervacije
     */
    public StavkaRezervacije() {
    }
    /**
     * Parametrizovan konstruktor koji setuje vrednosti za id, popust, brojSedista,gledato,rezervaciuu,predstavu
     * @param stavkaId id stavke koji se setuje 
     * @param popust  popust za predstavu koju ostvaruje klijent koji se setuje
     * @param brojSedista broj sedista za predstavu koju klijent zeli da gleda koji se setuje
     * @param rezervacijaId rezervacija koja je vezana za kartu
     * @param predstavaId predstava koja je vezana za stavku
     * @param gledato da li je gledao korisnik predstavu true ako jeste false ako nije
     */
    public StavkaRezervacije(Integer stavkaId, int popust, int brojSedista, boolean gledato, Rezervacija rezervacijaId, Predstava predstavaId) {
        this.stavkaId = stavkaId;
        this.popust = popust;
        this.brojSedista = brojSedista;
        this.gledato = gledato;
        this.rezervacijaId = rezervacijaId;
        this.predstavaId = predstavaId;
    }
/**
 * Metoda koja vraca id stavke
 * @return stavkaId u integer formatu
 */
    public Integer getStavkaId() {
        return stavkaId;
    }
/**
 * Metoda koja vraca popust predstave koja se nalazi u stavki
 * @return popust u integer formatu
 */
    public int getPopust() {
        return popust;
    }
/**
 * Metoda koja vraca broj sedista predstave koja se nalazi u stavki
 * @return brojSedista u integer formatu
 */
    public int getBrojSedista() {
        return brojSedista;
    }
/**
 * Metoda koja vraca da li je korisnik gledao predstavu koja se nalazi u stavki
 * @return gledato je true ako jeste false ako nije gledao
 */
    public boolean isGledato() {
        return gledato;
    }
/**
 * Metoda koja vraca  rezervaciju u kojoj se nalazi  stavka
 * @return rezervacijaId za koju je vezana stavka
 */
    public Rezervacija getRezervacijaId() {
        return rezervacijaId;
    }
/**
 * Metoda koja vraca predstavu koja se nalazi u stavki
 * @return predstavaId za koju se pravi stavka 
 */
    public Predstava getPredstavaId() {
        return predstavaId;
    }
/**
 * Metoda koja postavlja id stavke na prosledjeni parametar
 * @param stavkaId koja se setuje za stavka id
 * @throws IllegalArgumentException ako je id manji od 0
 */
    public void setStavkaId(Integer stavkaId) {
        if(stavkaId<0){
            throw new IllegalArgumentException("Id stavke ne moze biti manji od 0");
        }
        this.stavkaId = stavkaId;
    }
/**
 * Metoda koja postavlja popust na prosledjeni parametar za predstavu koju ostvaruje klijent 
 * @param popust koja se setuje za popust predstave u stavki
 * @throws IllegalArgumentException ako je popust manji od 0 ili veci od 100
 */
    public void setPopust(int popust) {
         if(popust<0 || popust>100){
            throw new IllegalArgumentException("Popust stavke ne moze biti manji od 0 ili veci od 100");
        }
        this.popust = popust;
    }
/**
 * Metoda koja postavlja broj sedista na prosledjeni parametar za predstavu koju gleda klijent 
 * @param brojSedista koja se setuje za broj rezervisanih sedista predstave u stavki
 *  @throws IllegalArgumentException ako je brojSedista manji od 1
 */
    public void setBrojSedista(int brojSedista) {
         if(brojSedista<1){
            throw new IllegalArgumentException("broj sedista ne moze biti manji od 0");
        }
        this.brojSedista = brojSedista;
    }
/**
 * Metoda koja postavlja da li je klijent vec gledao predstavu na prosledjeni parametar 
 * @param gledato true ako je korisnik vec gledao false ako nije
 */
    public void setGledato(boolean gledato) {
        this.gledato = gledato;
    }
/**
 * Metoda koja postavlja rezervaciju za koju je vezana stavka
 * @param rezervacijaId koja predstavlja rezervaciju za koju je vezana stavka
 * @throws NullPointerException ako je rezervacija null
 */
    public void setRezervacijaId(Rezervacija rezervacijaId) {
        if(rezervacijaId==null){
            throw new NullPointerException("Ne moze rezervacija da ne postoji");
        }
        this.rezervacijaId = rezervacijaId;
    }
/**
 * Metoda koja postavlja predstavu za koju je vezana stavka
 * @param predstavaId koji predstavlja predstavu za koju se pravi stavka rezervacije
 * @throws NullPointerException ako je predstava null
 */
    public void setPredstavaId(Predstava predstavaId) {
         if(predstavaId==null){
            throw new NullPointerException("Ne moze predstava da ne postoji");
        }
        this.predstavaId = predstavaId;
    }
/**
 * Metoda za hash code koji inicijalno ima vrednost 3
 * zatim se setuje za atribute stavke kao sto su id,popust,brojSedista,gledato,rezervacija i predstava
 * @return hash odnosno vrednost hash koda
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.stavkaId);
        hash = 37 * hash + this.popust;
        hash = 37 * hash + this.brojSedista;
        hash = 37 * hash + (this.gledato ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.rezervacijaId);
        hash = 37 * hash + Objects.hashCode(this.predstavaId);
        return hash;
    }
/**
 * Metoda za proveru da li je prosledjeni objekat jednak postojecoj stavki
 * proverava da li je objekat null ako jeste vraca false
 * proverava da li su iste klase ako nisu vraca false
 * ako im id, brojsedista,gledato,popust,rzervacija ili predstava nisu iste vraca false
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
        final StavkaRezervacije other = (StavkaRezervacije) obj;
        if (this.popust != other.popust) {
            return false;
        }
        if (this.brojSedista != other.brojSedista) {
            return false;
        }
        if (this.gledato != other.gledato) {
            return false;
        }
        if (!Objects.equals(this.stavkaId, other.stavkaId)) {
            return false;
        }
        if (!Objects.equals(this.rezervacijaId, other.rezervacijaId)) {
            return false;
        }
        return Objects.equals(this.predstavaId, other.predstavaId);
    }
/**
 * Metoda za vracanja u string formatu vrednosti atributa objekta stavki, svi atributi su ukljuceni
 * id,popust,brojSedista,gledato,rezervacijaId,predstavaId
 * @return string u kom su svi atributi stavke rezervacije
 */
    @Override
    public String toString() {
        return "StavkaRezervacije{" + "stavkaId=" + stavkaId + ", popust=" + popust + ", brojSedista=" + brojSedista + ", gledato=" + gledato + ", rezervacijaId=" + rezervacijaId + ", predstavaId=" + predstavaId + '}';
    }

    @Override
    public String getTableName() {
        return "stavkarezervacije";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "popust,brojSedista,gledato,rezervacijaId,predstavaId";
    }

    @Override
    public String getInsertValues() {
          StringBuilder sb = new StringBuilder();
        sb.append(popust).append(",")
                .append(brojSedista).append(",")
                .append(gledato).append(",").append(rezervacijaId.getRezervacijaId()).append(",").append(predstavaId.getPredstavaId());
        return sb.toString();
    }

  

    @Override
    public String getWhereCondition(Object object) {
        return "s.stavkaId="+((StavkaRezervacije)object).getStavkaId() + " AND s.rezervacijaId="+((StavkaRezervacije)object).getRezervacijaId().getRezervacijaId();

    }

    @Override
    public String getSelectValues() {
        return "SELECT s.stavkaId,s.popust,s.brojSedista,s.gledato,s.rezervacijaId,s.predstavaId,r.brojPredstave,r.klijentId,k.ime,k.prezime,k.status,k.email,p.naziv,p.mesto,p.vreme,p.kapacitet FROM stavkarezervacije AS s INNER JOIN rezervacija AS r ON s.rezervacijaId=r.rezervacijaId INNER JOIN predstava AS p ON s.predstavaId=p.predstavaId INNER JOIN klijent k ON r.klijentId = k.klijentId";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "stavkaId="+((StavkaRezervacije)object).getStavkaId() + " AND rezervacijaId="+((StavkaRezervacije)object).getRezervacijaId().getRezervacijaId();

    }

    @Override
    public String getUpdateSetValues(Object object) {
        StavkaRezervacije st = (StavkaRezervacije)object;
        return "popust="+st.getPopust()+", brojSedista="+st.getBrojSedista()+", predstavaId="+st.getPredstavaId().getPredstavaId();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(stavkaId).append(",")
                .append(rezervacijaId.getRezervacijaId());
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "stavkaId,rezervacijaId";
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
        kl.setEmail(rs.getString("email"));
        kl.setStatus(rs.getString("status"));
        
        Rezervacija r = new Rezervacija();
        r.setRezervacijaId(rs.getInt("rezervacijaId"));
        r.setKlijentId(kl);
        StavkaRezervacije st=new StavkaRezervacije(rs.getInt("stavkaId"),rs.getInt("popust") , rs.getInt("brojSedista"), rs.getBoolean("gledato"), r, p);
        return st;
    }

    @Override
    public void setId(Integer id) {
        this.stavkaId=id;
    }

   
    
    
}
