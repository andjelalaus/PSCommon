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
 * Klasa koja predstavlja genericki entitet
 * Sluzi za definisanje osnovnih pojmova koji su potrebni za uspesnu komunikaciju sa bazom podataka
 * ima metode za vracnje imena tabele,kolona,unetih vrednosti,where uslova,selektovanih vrednosti,
 * uslova za brisanje i auzuriranje vrednosti, vrednosti za kreiranje,imena kolona za kreiranje, i novi objekat i setovanje id
 * @author Andjy
 */
public interface GenericEntity extends Serializable {

    /**
     * Metoda koja vraca ime tabele u bazi podataka datog objekta.
     * @return u string formatu ime
     */
    String getTableName();

    /**
     * Metoda koja vraca imena kolona tabele u bazi podataka datog objekta.
     * @return u string formatu imena kolona
     */
    String getColumnNamesForInsert();

    /**
     * Metoda koja vraca preko StringBuldiera vrednosti koje treba da se ubace u tabele u bazi podataka datog objekta.
     * @return u string formatu vrednsoti koje se ubacuju
     */
    String getInsertValues();
    /**
     * Metoda koja vraca uslov za WHERE koji mora biti ispunjen kod sql upita koje treba da se izvrsi pri manipulaciji tabela datog objekta u bazi podataka
     * @return u string formatu vraca where uslov
     * @param object za koji se izvrsava manipulacija
     */
    String getWhereCondition(Object object);

    /**
     * Metoda koja setuje id datog objekta
     * @param id koji se prosledjuje da se postavi za vrednost id-a
     */
    void setId(Integer id);
    
    /**
     * Metoda koja vraca ceo select upit koji treba da se izvrsi za vracanje podataka iz tabele u bazi podataka datog objekta.
     * @return u string formatu select upit
     */
    String getSelectValues();
    /**
     * Metoda koja vraca uslov za delete i update koji mora biti ispunjen kod sql upita koje treba da se izvrsi pri manipulaciji tabela datog objekta u bazi podataka
     * @return u string formatu vraca  uslov za brisanje ili auzuriranje objekta
     * @param object za koji se izvrsava manipulacija
     */
    String getDeleteAndUpdateCondition(Object object);
     /**
     * Metoda koja vraca vrednosti za koje se vrsi auzuriranje u tabeli datog objekta u bazi podataka
     * @return u string formatu vraca vrednsoti za koje se vrsi update
     * @param object za koji se izvrsava manipulacija
     */
    String getUpdateSetValues(Object object);
     /**
     * Metoda koja vraca vrednosti za koje se vrsi unbacivanje u tabeli datog objekta u bazi podataka
     * @return u string formatu vraca vrednosti za koje se vrsi insert
     */
    String getCreateInsertValues();
     /**
     * Metoda koja vraca imena kolona za kreiranje tabele datog objekta u bazi podataka
     * @return u string formatu vraca imena kolona za koje se vrsi kreiranje tabele
     */
    String getColumnNamesForCreate();
    /**
     * Vracanje novog objekta dobijenog izvrsavanjem sql upita nad tabelom datog objekta u bazi podataka
     * @param rs je objekat klase ResultSet
     * @return genericki entitet tj objekat cija klasa ima implementiran dati interfejs
     * @throws SQLException ukoliko je doslo do greske u sql upitu
     */
    GenericEntity getNewObject(ResultSet rs) throws SQLException;
    

}
