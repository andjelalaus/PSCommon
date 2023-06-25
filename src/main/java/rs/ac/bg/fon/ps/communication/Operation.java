/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public enum Operation  implements Serializable{
    
    //validacija na strani servera i moze kod klijenta
    
    
    LOGIN,
    GET_ALL_MANUFACTURERS,
    GET_ALL_PREDSTAVE,
    DELETE_STAVKA,
    ADD_KLIJENT,
    EDIT_PRODUCT,
    DELETE_PREDSTAVA,
    ADD_INVOICE, ADD_PREDSTAVA, ADD_REZERVACIJA, GET_ALL_CLIENTS, ADD_KARTA, GET_ALL_SHOWS, GET_ALL_RESERVATIONS, GET_ALL_ITEMS_RESERVATIONS, UPDATE_REZERVACIJA, DELETE_REZERVACIJA, GET_ALL_TICKETS, DELETE_KARTA, ADD_PLAN, ADD_STAVKA, UPDATE_STAVKA, GET_ALL_PLAN, DELETE_PLAN,
}
