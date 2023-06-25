/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Predstava implements GenericEntity{
    private Integer predstavaId;
    private String naziv;
    private String mesto;
    private LocalDateTime vreme;
    private Integer kapacitet;

    public Predstava(Integer predstavaId, String naziv, String mesto, LocalDateTime vreme, Integer kapacitet) {
        this.predstavaId = predstavaId;
        this.naziv = naziv;
        this.mesto = mesto;
        this.vreme = vreme;
        this.kapacitet = kapacitet;
    }

    public Predstava() {
    }

    public Integer getPredstavaId() {
        return predstavaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public LocalDateTime getVreme() {
        return vreme;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setPredstavaId(Integer predstavaId) {
        this.predstavaId = predstavaId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setVreme(LocalDateTime vreme) {
        this.vreme = vreme;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.predstavaId);
        hash = 83 * hash + Objects.hashCode(this.naziv);
        hash = 83 * hash + Objects.hashCode(this.mesto);
        hash = 83 * hash + Objects.hashCode(this.vreme);
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
