/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class PlanGledanja implements GenericEntity{
    
    private Predstava predstavaId;
    private Klijent klijentId;
    private Boolean gledao;
    private Integer ocena;

    public PlanGledanja() {
    }

    public PlanGledanja(Predstava predstavaId, Klijent klijentId, Boolean gledao, Integer ocena) {
        this.predstavaId = predstavaId;
        this.klijentId = klijentId;
        this.gledao = gledao;
        this.ocena = ocena;
    }

    public Predstava getPredstavaId() {
        return predstavaId;
    }

    public Klijent getKlijentId() {
        return klijentId;
    }

    public Boolean getGledao() {
        return gledao;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setPredstavaId(Predstava predstavaId) {
        this.predstavaId = predstavaId;
    }

    public void setKlijentId(Klijent klijentId) {
        this.klijentId = klijentId;
    }

    public void setGledao(Boolean gledao) {
        this.gledao = gledao;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.predstavaId);
        hash = 89 * hash + Objects.hashCode(this.klijentId);
        hash = 89 * hash + Objects.hashCode(this.gledao);
        hash = 89 * hash + Objects.hashCode(this.ocena);
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
