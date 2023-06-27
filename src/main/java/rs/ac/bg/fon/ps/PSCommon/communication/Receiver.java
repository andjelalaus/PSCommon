/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.PSCommon.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Klasa Receiver koja funkcionise kao prihvatac
 * prima preko soketa objekte
 * @author Andjy
 */
public class Receiver {
    /**
     * instanca klase Socket koja se definise za komunikaciju izmedju servera i klijenta
     */
    private Socket socket;

    /**
     * Konstruktor klase Receiver
     * postavlja vrednost socket-a na prosledjenu vrednost
     * @param socket koji se postavlja za vrednost socket-a
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    /**
     * Metoda koja prihvata objekat putem ObjectInputStream i soketa
     * @return vraca procitani objekat koji je poslat preko soketa
     * @throws Exception ukoliko nije uspela da primi objekat
     */
    public Object receive() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
    }
}
