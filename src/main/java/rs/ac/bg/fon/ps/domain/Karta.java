/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author andelalausevic
 */
public class Karta implements GenericEntity {
    private Integer kartaId;
    private int cena;
    private Rezervacija rezervacijaId;
    private StavkaRezervacije stavkaId;

    public Karta() {
    }

    public Karta(Integer kartaId, int cena, Rezervacija rezervacijaId, StavkaRezervacije stavkaId) {
        this.kartaId = kartaId;
        this.cena = cena;
        this.rezervacijaId = rezervacijaId;
        this.stavkaId = stavkaId;
    }

    public Integer getKartaId() {
        return kartaId;
    }

    public int getCena() {
        return cena;
    }

    public Rezervacija getRezervacijaId() {
        return rezervacijaId;
    }

    public StavkaRezervacije getStavkaId() {
        return stavkaId;
    }

    public void setKartaId(Integer kartaId) {
        this.kartaId = kartaId;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setRezervacijaId(Rezervacija rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public void setStavkaId(StavkaRezervacije stavkaId) {
        this.stavkaId = stavkaId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.kartaId);
        hash = 83 * hash + this.cena;
        hash = 83 * hash + Objects.hashCode(this.rezervacijaId);
        hash = 83 * hash + Objects.hashCode(this.stavkaId);
        return hash;
    }

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
