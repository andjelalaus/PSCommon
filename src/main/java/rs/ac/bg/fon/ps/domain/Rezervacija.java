/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class Rezervacija implements GenericEntity{
    private Integer rezervacijaId;
    private Integer brojPredstave;
    private Klijent klijentId;

    private ArrayList<StavkaRezervacije> stavke;
    
    public Rezervacija() {
        this.stavke = new ArrayList<>();
    }

    public Rezervacija(Integer rezervacijaId, Integer brojPredstave, Klijent klijentId) {
        this.rezervacijaId = rezervacijaId;
        this.brojPredstave = brojPredstave;
        this.klijentId = klijentId;
        this.stavke = new ArrayList<>();
    }
    

    public void setRezervacijaId(Integer rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public void setBrojPredstave(Integer brojPredstave) {
        this.brojPredstave = brojPredstave;
    }

    public void setKlijentId(Klijent klijentId) {
        this.klijentId = klijentId;
    }

    public Integer getRezervacijaId() {
        return rezervacijaId;
    }

    public Integer getBrojPredstave() {
        return brojPredstave;
    }

    public Klijent getKlijentId() {
        return klijentId;
    }

    public ArrayList<StavkaRezervacije> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaRezervacije> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "rezervacijaId=" + rezervacijaId + ", brojPredstave=" + brojPredstave + ", klijentId=" + klijentId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.rezervacijaId);
        hash = 59 * hash + Objects.hashCode(this.brojPredstave);
        hash = 59 * hash + Objects.hashCode(this.klijentId);
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
