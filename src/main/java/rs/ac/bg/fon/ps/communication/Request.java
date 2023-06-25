/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.Serializable;

/**
 * Klasa Request koja implementira interfejs Serializable
 * sluzi za primanje zahteva od klijenta
 * @author Andjy
 */
public class Request implements Serializable{
    /**
     * objekat klase Operation koji moze da ima vrenosti definisanih enum u datoj klasi
     */
    private Operation operation;
    /**
     * argument klase Object koji se prosledjuje za manipulaciju
     */
    private Object argument;

    /**
     * Prazan konstruktor date klase
     */
    public Request() {
    }

    /**
     * Parametarski konstruktor date klase koji setuje vrednosti za operaciju i argument
     * @param operation koji se setuje na prosledjenu vrednost
     * @param argument koji se setuje na prosledjenu vrednost
     */
    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    /**
     * Metoda koja vraca setovani objekat operation
     * @return operation koji ima vrednost operacije koju korisnik zeli da izvrsi
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * Metoda koja setuje objekat operation
     * @param operation  koji se setuje na prosledjenu vrednost operacije koju korisnik zeli da izvrsi
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Metoda koja vraca argument objekat
     * @return argument u vidu objekta kojim korisnik zeli da manipulise
     */
    public Object getArgument() {
        return argument;
    }

    /**
     * Metoda koja setuje vrednost objekta argument na prosledjenu vrednost
     * @param argument je objekat kojim korisnik zeli da manipulise
     */
    public void setArgument(Object argument) {
        this.argument = argument;
    }
    
    
}
