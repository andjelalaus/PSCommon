/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;

/**
 * Klasa User koja implementira interfejs Genericki entitet i njegove metode
 * Predstavlja korisnika biletarnickog sistema koji je u ovoj verziji koda admin samo
 * Ima svoj username i password
 * @author andjelalaus
 */
public class User implements Serializable{
    /**
     * Predstavlja jedinstveni username odnosno korisnicko ime admina
     */
    private String username;
     /**
     * Predstavlja jedinstveni password odnosno lozinku admina
     */
    private String password;
    /**
     * Neparametrizovan konstruktor usera
     */
    public User()  {
    }

      /**
     * Parametrizovan konstruktor koji setuje vrednosti za username, password
     * @param username korisnicko ime koje se ubacuje
     * @param password  lozinka korisnika koja se ubacuje
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

/**
 * Metoda koja vraca username korisnika
 * @return username u string formatu
 */
    public String getUsername() {
        return username;
    }
/**
 * Metoda koja vraca password korisnika
 * @return password u string formatu
 */
    public String getPassword() {
        return password;
    }
/**
 * Metoda koja postavlja username korisnika  na prosledjeni parametar
 * @param username koja se setuje za korisnikov username
 */
    public void setUsername(String username) {
        this.username = username;
    }

/**
 * Metoda koja postavlja password korisnika  na prosledjeni parametar
 * @param password koja se setuje za korisnikov password
 */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
