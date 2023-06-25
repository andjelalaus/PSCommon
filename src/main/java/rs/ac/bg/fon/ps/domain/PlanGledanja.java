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
 * Klasa PLanGledanja koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja plan gledanja klijenta za neku predstavu,ocenu koju je dao toj predstavi i da li ju je stvarno gledao
 * @author andelalausevic
 */
public class PlanGledanja implements GenericEntity{
     /**
     * Predstavlja predstavu koja je vezana za plan gledanja
     */
    private Predstava predstavaId;
     /**
     * Predstavlja klijenta koji je vezan za plan gledanja
     */
    private Klijent klijentId;
    /**
     * Predstavlja da li je klijent gledao true ako jeste false ako nije
     */
    private Boolean gledao;
    /**
     * Predstavlja ocenu za predstavu za koju klijent postavlja plan gledanja
     */
    private Integer ocena;
/**
 * Prazan konstruktor klase PlanGledanja
 */
    public PlanGledanja() {
    }
  /**
     * Parametrizovan konstruktor koji setuje vrednosti za predstavu,klijenta,gledao i ocenu
     * @param predstavaId predstava koja se setuje za dati plan
     * @param klijentId  klijent koji pravi plan 
     * @param gledao da li je gledao
     * @param ocena ocena koju je klijent dao
     */
    public PlanGledanja(Predstava predstavaId, Klijent klijentId, Boolean gledao, Integer ocena) {
        this.predstavaId = predstavaId;
        this.klijentId = klijentId;
        this.gledao = gledao;
        this.ocena = ocena;
    }
/**
 * Metoda koja vraca objekat klase predstava koja je setovana za plan gledanja
 * @return predstavaId predstavu za dati plan gledanja
 */
    public Predstava getPredstavaId() {
        return predstavaId;
    }
/**
 * Metoda koja vraca objekat klase klijent koji je setovan za plan gledanja
 * @return klijentId klijenta za dati plan gledanja
 */
    public Klijent getKlijentId() {
        return klijentId;
    }
/**
 * Metoda koja vraca da li je klijent gledao datu predstavu za koju daje plan
 * @return gledao true ako jeste false ako nije gledao predstavu
 */
    public Boolean getGledao() {
        return gledao;
    }
/**
 * Metoda koja vraca ocenu koju je klijent dao za predstavu
 * @return ocena u brojnom formatu
 */
    public Integer getOcena() {
        return ocena;
    }
/**
 * Metoda koja postavlja predstavu na prosledjeni parametar
 * @param predstavaId koja se setuje za predstavu za koju se pise plan gledanja
 */
    public void setPredstavaId(Predstava predstavaId) {
        this.predstavaId = predstavaId;
    }
/**
 * Metoda koja postavlja klijenta na prosledjeni parametar
 * @param klijentId koja se setuje za klijenta za koju se pise plan gledanja
 */
    public void setKlijentId(Klijent klijentId) {
        this.klijentId = klijentId;
    }
/**
 * Metoda koja postavlja da li je gledao klijent predstavu na prosledjeni parametar
 * @param gledao koja se setuje za gledao true ako jeste false ako nije
 */
    public void setGledao(Boolean gledao) {
        this.gledao = gledao;
    }
/**
 * Metoda koja postavlja ocenu na prosledjeni parametar
 * @param ocena koja se setuje za ocenu predstave za koju se pise plan gledanja
 */
    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }
/**
 * Metoda za hash code koji inicijalno ima vrednost 3
 * zatim se setuje za atribute plana kao sto su predstava klijent gledao i ocena
 * @return hash odnosno vrednost hash koda
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.predstavaId);
        hash = 89 * hash + Objects.hashCode(this.klijentId);
        hash = 89 * hash + Objects.hashCode(this.gledao);
        hash = 89 * hash + Objects.hashCode(this.ocena);
        return hash;
    }
/**
 * Metoda za proveru da li je prosledjeni objekat jednak postojecom planu gledanja
 * proveravada li je objekat null ako jeste vraca false
 * proverava da li su iste klase ako nisu vraca false
 * ako im predstava, klijent,gledao, ocena nisu iste vraca false
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
        final PlanGledanja other = (PlanGledanja) obj;
        if (!Objects.equals(this.predstavaId, other.predstavaId)) {
            return false;
        }
        if (!Objects.equals(this.klijentId, other.klijentId)) {
            return false;
        }
        if (!Objects.equals(this.gledao, other.gledao)) {
            return false;
        }
        return Objects.equals(this.ocena, other.ocena);
    }
/**
 * Metoda za vracanja u string formatu vrednosti atributa objekta plan gledanja, svi atributi su ukljuceni
 * predstava,klijent,gledao,ocena
 * @return string u kom su svi atributi plana gledanja
 */
    @Override
    public String toString() {
        return "PlanGledanja{" + "predstavaId=" + predstavaId + ", klijentId=" + klijentId + ", gledao=" + gledao + ", ocena=" + ocena + '}';
    }

    @Override
    public String getTableName() {
        return "plangledanja";
    }

    @Override
    public String getColumnNamesForInsert() {
         return "predstavaId,klijentId,gledao,ocena";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(predstavaId.getPredstavaId()).append(",")
                .append(klijentId.getKlijentId()).append(",")
                .append(gledao).append(",").append(ocena);
        return sb.toString();
    }

  

    @Override
    public String getWhereCondition(Object object) {
        return "pg.predstavaId="+((PlanGledanja)object).getPredstavaId().getPredstavaId() + " AND pg.klijentId="+((PlanGledanja)object).getKlijentId().getKlijentId();
    }

    @Override
    public String getSelectValues() {
        return "SELECT pg.predstavaId,pg.klijentId,pg.gledao,pg.ocena,p.naziv,p.mesto,p.vreme,p.kapacitet,k.ime,k.prezime,k.email,k.status FROM plangledanja AS pg INNER JOIN predstava AS p ON pg.predstavaId=p.predstavaId INNER JOIN klijent AS k ON pg.klijentId=k.klijentId";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "predstavaId="+((PlanGledanja)object).getPredstavaId().getPredstavaId() + " AND klijentId="+((PlanGledanja)object).getKlijentId().getKlijentId();

    }

    @Override
    public String getUpdateSetValues(Object object) {
         PlanGledanja pt = (PlanGledanja)object;
        return "ocena="+pt.getOcena();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(predstavaId.getPredstavaId()).append(",")
                .append(klijentId.getKlijentId());
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "predstavaId,klijentId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Predstava p = new Predstava(rs.getInt("predstavaId"),rs.getString("naziv"),rs.getString("mesto"),rs.getTimestamp("vreme").toLocalDateTime(),rs.getInt("kapacitet"));
        Klijent test = new Klijent();
        test.setId(rs.getInt("klijentId"));
        test.setIme(rs.getString("ime"));
        test.setPrezime(rs.getString("prezime"));
        test.setStatus(rs.getString("status"));
        test.setEmail(rs.getString("email"));
        
        return new PlanGledanja(p,test,rs.getBoolean("gledao"),rs.getInt("ocena"));
    }

    @Override
    public void setId(Integer id) {
        
    }

  
    
}
