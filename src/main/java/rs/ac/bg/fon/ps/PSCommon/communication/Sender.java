/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.PSCommon.communication;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Klasa Sender koja sluzi za slanje objekata izmedju korisnika i servera
 * @author Andjy
 */
public class Sender {
    /**
     * objekat klase Socket
     */
    private Socket socket;

    /**
     * Parametrizovan konstruktor date klase, setuje vrednost socket-a
     * @param socket koji sluzi za komunikaciju korisnika i servera dobija vrednost
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    /**
     * Metoda send koja salje objekat korisniku ili serveru
     * preko ObjectOutputStream i socket-a
     * 
     * @param object koji se salje
     * @throws Exception koji moze da se desi pri salnju datog objekta
     */
    public void send(Object object) throws Exception{
        try {
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n"+ex.getMessage());
        }
    }
}
