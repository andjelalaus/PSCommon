/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;

import java.io.Serializable;
import java.util.Objects;

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
 * @throws IllegalArgumentException ako je username prazan string
 * @throws NullPointerException ako je username null
 */
    public void setUsername(String username) {
        if(username==null){
            throw new NullPointerException("ne moze da bude null username");
        }
        
        if(username.isEmpty()){
            throw new IllegalArgumentException("ne moze da bude prazan username");
        }
        
        this.username = username;
    }

/**
 * Metoda koja postavlja password korisnika  na prosledjeni parametar
 * @param password koja se setuje za korisnikov password
 * @throws IllegalArgumentException ako je password prazan string
 * @throws NullPointerException ako je password null
 */
    public void setPassword(String password) {
        if(password==null){
            throw new NullPointerException("ne moze da bude null password");
        }
        if(password.isEmpty()){
            throw new IllegalArgumentException("ne moze da bude prazan password");
        }
       
        this.password = password;
    }
/**
 * Metoda za ispis usera u string formatu
 * ne sadrzi password usera
 * @return string sa imenom korisnika odnosno username-om
 */
    @Override
    public String toString() {
        return "User{" + "username=" + username + '}';
    }
/**
 * Hashcode metoda koja vraca hash kljuc
 * @return hash koji ima vrednost 3
 */
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
/**
 * Metoda koja gleda da li su dva usera isti useri
 * Proverava username i password da li su im isti
 * ukoliko jedan od ta dva atributa nisu isti onda ispisuje false
 * ako nisu iste klase ili je poslati objekat za proveru null ispisuje false
 * @param obj koji treba da se proveri da li je isti user
 * @return true ukoliko su isti false ukoliko su razliciti
 */
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }
    
    
}
