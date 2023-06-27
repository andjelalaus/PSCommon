/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.PSCommon.communication;

import java.io.Serializable;

/**
 * Definisanja enum vrednosti koju mogu imati operacije koje klijent zeli da izvrsi
 * Implementira interfejs Seriazable
 * 
 * @author Andjy
 */
public enum Operation  implements Serializable{
    
    
    
    /**
     * operacija logovanja
     */
    LOGIN,
    /**
     * operacija vracanja svih manufactures koja se ne koristi
     */
    GET_ALL_MANUFACTURERS,
    /**
     * operacija vracanja svih predstavi iz baze
     */
    GET_ALL_PREDSTAVE,
    /**
     * operacija brisanja stavki rezervacija iz baze
     */
    DELETE_STAVKA,
    /**
     * operacija dodavanja novog klijenta
     */
    ADD_KLIJENT,
    /**
     * operacija auzuriranja proizvoda
     */
    EDIT_PRODUCT,
    /**
     * operacija za brisanje predstave
     */
    DELETE_PREDSTAVA,
    /**
     * operacija za dodavanje racuna
     */
    ADD_INVOICE, 
    /**
     * operacija za dodavanje nove predstave
     */
    ADD_PREDSTAVA, 
    /**
     * operacija za dodavanje nove rezervacije
     */
    ADD_REZERVACIJA, 
    /**
     * operacija za vracanje svih postojecih klijenata
     */
    GET_ALL_CLIENTS, 
    /**
     * operacija za dodavanje nove karte
     */
    ADD_KARTA, 
    /**
     * operacija za vracanje svih predstavi
     */
    GET_ALL_SHOWS, 
    /**
     * operacija za vracanje svih rezervacija
     */
    GET_ALL_RESERVATIONS, 
    /**
     * operacija za vracanje svih stavki rezervacije
     */
    GET_ALL_ITEMS_RESERVATIONS, 
    /**
     * operacija za auzuriranja vrednosti rezervacije
     */
    UPDATE_REZERVACIJA,
    /**
     * operacija za brisanje predstave
     */
    DELETE_REZERVACIJA, 
    /**
     * operacija za vracanje svih karti
     */
    GET_ALL_TICKETS, 
    /**
     * operacija za brisanje karte
     */
    DELETE_KARTA, 
    /**
     * operacija za dodavanje plana gledanja
     */
    ADD_PLAN, 
    /**
     * operacija za dodavanje nove stavke rezervacije
     */
    ADD_STAVKA, 
    /**
     * operacija za auzuriranje stavki rezervacija
     */
    UPDATE_STAVKA, 
    /**
     * operacija za vracanje planova gledanja
     */
    GET_ALL_PLAN, 
    /**
     * operacija za brisanje plana gledanja
     */
    DELETE_PLAN,
}
