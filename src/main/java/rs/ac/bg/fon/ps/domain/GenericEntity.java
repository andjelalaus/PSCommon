/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cartman
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();
    
    String getWhereCondition(Object object);

    void setId(Integer id);
    
    String getSelectValues();
    
    String getDeleteAndUpdateCondition(Object object);
    
    String getUpdateSetValues(Object object);
    
    String getCreateInsertValues();
    
    String getColumnNamesForCreate();
    
    GenericEntity getNewObject(ResultSet rs) throws SQLException;
    

}
