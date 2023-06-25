/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class StavkaRezervacije implements GenericEntity{
    private Integer stavkaId;
    private int popust;
    private int brojSedista;
    private boolean gledato;
    private Rezervacija rezervacijaId;
    private Predstava predstavaId;

    public StavkaRezervacije() {
    }

    public StavkaRezervacije(Integer stavkaId, int popust, int brojSedista, boolean gledato, Rezervacija rezervacijaId, Predstava predstavaId) {
        this.stavkaId = stavkaId;
        this.popust = popust;
        this.brojSedista = brojSedista;
        this.gledato = gledato;
        this.rezervacijaId = rezervacijaId;
        this.predstavaId = predstavaId;
    }

    public Integer getStavkaId() {
        return stavkaId;
    }

    public int getPopust() {
        return popust;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public boolean isGledato() {
        return gledato;
    }

    public Rezervacija getRezervacijaId() {
        return rezervacijaId;
    }

    public Predstava getPredstavaId() {
        return predstavaId;
    }

    public void setStavkaId(Integer stavkaId) {
        this.stavkaId = stavkaId;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    public void setGledato(boolean gledato) {
        this.gledato = gledato;
    }

    public void setRezervacijaId(Rezervacija rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public void setPredstavaId(Predstava predstavaId) {
        this.predstavaId = predstavaId;
    }

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
