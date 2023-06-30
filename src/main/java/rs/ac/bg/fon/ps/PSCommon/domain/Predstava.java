/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Klasa Predstava koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja predstavu za koju se moze praviti rezervacija i za koju se moze kupiti karta ili napraviti plan gledanja
 * svaka predstava mora da ima naziv,mesto na kom se desava,vreme kada se desava,kapacitet mesta koji moze da primi
 * @author andelalausevic
 */
public class Predstava implements GenericEntity{
    /**
     * Predstavlja jedinstveni identifikator predstave
     */
    private Integer predstavaId;
    /**
     * Predstaclja naziv predstave
     */
    private String naziv;
      /**
     * Predstaclja naziv mesta gde se odrzava predstava
     */
    private String mesto;
    /**
     * Predstavlja vreme u kom se desava predstava moze biti samo buduce vreme i u obliku datuma i vremena
     */
    private LocalDateTime vreme;
    /**
     * Predstavlja kapacitet tj broj ljudi koji moze da bude na predstavi
     */
    private Integer kapacitet;
   /**
     * Parametrizovan konstruktor koji setuje vrednosti za id, naziv, mesto,vreme i kapacitet
     * @param predstavaId je id predstave 
     * @param naziv  je naziv predstave koja se pravi
     * @param mesto predstavlja nazziv mesta gde se odrzava predstava
     * @param vreme predstavlja vreme predstave kada i ukoliko stai
     * @param kapacitet predstavlja broj ljudi koji moze maksimalno da se primi na predstavu
     */
    public Predstava(Integer predstavaId, String naziv, String mesto, LocalDateTime vreme, Integer kapacitet) {
        this.predstavaId = predstavaId;
        this.naziv = naziv;
        this.mesto = mesto;
        this.vreme = vreme;
        this.kapacitet = kapacitet;
    }
    /**
     * Neparametrizovan konstruktor klase Predstava
     */
    public Predstava() {
    }
/**
 * Metoda koja vraca id predstave
 * @return predstavaId u integer formatu
 */
    public Integer getPredstavaId() {
        return predstavaId;
    }
/**
 * Metoda koja vraca naziv predstave
 * @return naziv u string formatu
 */
    public String getNaziv() {
        return naziv;
    }
/**
 * Metoda koja vraca naziv mesta predstave
 * @return mesto u string formatu
 */
    public String getMesto() {
        return mesto;
    }
/**
 * Metoda koja vraca naziv vreme predstave
 * @return vreme u LocalFateTime formatu
 */
    public LocalDateTime getVreme() {
        return vreme;
    }
/**
 * Metoda koja vraca kapacitet mesta predstave
 * @return kapacitet u integer formatu
 */
    public Integer getKapacitet() {
        return kapacitet;
    }
/**
 * Metoda koja postavlja id predstave na prosledjeni parametar
 * @param predstavaId koja se setuje za predstava id
 * @throws IllegalArgumentException id ne moze biti manji od 0
 */
    public void setPredstavaId(Integer predstavaId) {
        if(predstavaId<0){
            throw new IllegalArgumentException("Ne moze id biti manji od 0");
        }
        this.predstavaId = predstavaId;
    }
/**
 * Metoda koja postavlja naziv predstave na prosledjeni parametar
 * @param naziv koja se setuje za predstavin naziv
 * @throws IllegalArgumentException naziv ne moze biti prazan
 * @throws NullPointerException naziv ne moze biti null
 */
    public void setNaziv(String naziv) {
         if(naziv==null){
            throw new NullPointerException("Ne moze naziv biti null");
        }    
         if(naziv.isEmpty()){
            throw new IllegalArgumentException("Ne moze naziv biti prazan");
        }
        this.naziv = naziv;
    }
/**
 * Metoda koja postavlja naziv mesta predstave na prosledjeni parametar
 * @param mesto koja se setuje za predstavin naziv mesta
 * @throws IllegalArgumentException naziv mesta ne moze biti prazan
 * @throws NullPointerException naziv mesta ne moze biti null
 */
    public void setMesto(String mesto) {
           if(mesto==null){
            throw new NullPointerException("Ne moze naziv mesta biti null");
        }    
         if(mesto.isEmpty()){
            throw new IllegalArgumentException("Ne moze naziv mesta biti prazan");
        }
        this.mesto = mesto;
    }
/**
 * Metoda koja postavlja vreme predstave na prosledjeni parametar
 * @param vreme koja se setuje za datum i vreme predstave
 * @throws NullPointerException ako je vreme null
 */
    public void setVreme(LocalDateTime vreme) {
        if(vreme==null){
            throw new NullPointerException("Vreme mora da postoji");
        }
        this.vreme = vreme;
    }
/**
 * Metoda koja postavlja kapacitet predstave na prosledjeni parametar
 * @param kapacitet koja se setuje za predstavin kapacitet mesta
 * @throws IllegalArgumentException ako je kapacitet manji od 0
 */
    public void setKapacitet(Integer kapacitet) {
        if(kapacitet<0){
            throw new IllegalArgumentException("Kapacitet ne sme biti manji od 0");
        }
        this.kapacitet = kapacitet;
    }
/**
 * Metoda za hash code koji inicijalno ima vrednost 3
 * zatim se setuje za atribute predstave kao sto su id naziv,mesto,vreme
 * @return hash odnosno vrednost hash koda
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.predstavaId);
        hash = 83 * hash + Objects.hashCode(this.naziv);
        hash = 83 * hash + Objects.hashCode(this.mesto);
        hash = 83 * hash + Objects.hashCode(this.vreme);
        return hash;
    }
/**
 * Metoda za proveru da li je prosledjeni objekat jednak postojecoj predstavi
 * proverava da li je objekat null ako jeste vraca false
 * proverava da li su iste klase ako nisu vraca false
 * ako im id, naziv,mesto ili vreme nisu iste vraca false
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
        final Predstava other = (Predstava) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.mesto, other.mesto)) {
            return false;
        }
        if (!Objects.equals(this.predstavaId, other.predstavaId)) {
            return false;
        }
        return Objects.equals(this.vreme, other.vreme);
    }
/**
 * Metoda za vracanja u string formatu vrednosti atributa objekta predstave, svi atributi su ukljuceni
 * id,naziv,mesto,vreme
 * @return string u kom su svi atributi predstave
 */
    @Override
    public String toString() {
        return "Predstava{" + "predstavaId=" + predstavaId + ", naziv=" + naziv + ", mesto=" + mesto + ", vreme=" + vreme + ", kapacitet=" + kapacitet + '}';
    }

    @Override
    public String getTableName() {
         return "predstava";
    }

    @Override
    public String getColumnNamesForInsert() {
         return "naziv,mesto,vreme,kapacitet";
    }

    @Override
    public String getInsertValues() {
         StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("',")
                .append("'").append(mesto).append("',")
                .append("'").append(vreme.toString()).append("',").append(kapacitet);
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        this.predstavaId=id;
     }

    @Override
    public String getWhereCondition(Object object) {
         return "predstavaId="+((Predstava)object).getPredstavaId();
    }

    @Override
    public String getSelectValues() {
         return "SELECT * FROM predstava";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return getWhereCondition(object);
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Predstava predstava = (Predstava)object;
        return "naziv="+"'"+predstava.getNaziv()+"'"+", mesto="+"'"+predstava.getMesto()+"'"+", vreme="+"'"+predstava.getVreme().toString()+"'"+", kapacitet="+predstava.getKapacitet();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(predstavaId);
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "predstavaId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Predstava t = new Predstava();
        t.setPredstavaId(rs.getInt("predstavaId"));
        t.setNaziv(rs.getString("naziv"));
        t.setKapacitet(rs.getInt("kapacitet"));
        t.setMesto(rs.getString("mesto"));
        t.setVreme(rs.getTimestamp("vreme").toLocalDateTime());
        
        return t;
    }
    


 


    
    
    
    
    
}
