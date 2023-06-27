/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.PSCommon.communication;

import java.io.Serializable;

/**
 * Klasa Response koja ima ulogu da vraca odgovor servera na zahtev klijenta
 * 
 * @author Andjy
 */
public class Response  implements Serializable{
    /**
     * result je instanca klase Object jer server salje neki objekat korisniku
     */
    private Object result;
    /**
     * exception instanca klase Exception do kojeg moze doci pri slanju odgovora
     */
    private Exception exception;

    /**
     * Prazan konstruktor date klase
     */
    public Response() {
    }

    /**
     * Parametrizovan konstruktor koji setuje vrednosti objekta result i exception-a na prosledjene vrednosti
     * @param result predstavlja objekat koji se salje korisniku
     * @param exception predstavlja gresku do koje moze doci
     */
    public Response(Object result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    /**
     * Metoda koja vraca objekat koji se salje korisniku kao odgovor
     * @return result objekat koji se salje korisniku
     */
    public Object getResult() {
        return result;
    }

    /**
     * Metoda koja setuje objekat result na prosledjenu vrednost u metodi
     * @param result predstavlja objekat koji se salje kao odgovor korisniku
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * Metoda koja vraca exception
     * @return gresku do koje je doslo
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Postavlja vrednost greske na prosledjenu u metodi
     * @param exception koji je moguc prilikom slanja odgovora
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
}
