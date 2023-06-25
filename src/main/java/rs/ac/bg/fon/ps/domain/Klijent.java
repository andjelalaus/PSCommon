/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class Klijent implements GenericEntity{
    
    private Integer klijentId;
    private String ime;
    private String prezime;
    private String email;
    private String status;

    public Klijent() {
    }

    
    public Klijent(Integer klijentId, String ime, String prezime, String email, String status) {
        this.klijentId = klijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.status = status;
    }

    public Integer getKlijentId() {
        return klijentId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public void setKlijentId(Integer klijentId) {
        this.klijentId = klijentId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.klijentId);
        hash = 67 * hash + Objects.hashCode(this.ime);
        hash = 67 * hash + Objects.hashCode(this.prezime);
        hash = 67 * hash + Objects.hashCode(this.email);
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
