/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 *
 * @author andelalausevic
 */
public class KartaTest {
    Karta k;
    
    @BeforeEach
    void setUp() throws Exception{
        k=new Karta();
    }
    
    @AfterEach
     void tearDown() throws Exception {
        k=null;
    }
    
    @Test
    void testSetIDSveOk() {
         k.setId(2);
	 assertEquals(2,k.getKartaId());
    }
    @Test
    void testSetIDManjiOdNule() {
	  assertThrows(IllegalArgumentException.class,
				() -> k.setKartaId(-1));
    }
    @Test
    void testSetCenaOK() {
            k.setCena(100);
		
	  assertEquals(100,k.getCena());
    }
    @Test
    void testSetCenaManjaOd0() {
	    assertThrows(IllegalArgumentException.class, ()->k.setCena(-1));
    }
    @Test
    void testSetRezervacijaOK() {
        Rezervacija r=new Rezervacija(1,2, new Klijent(1, "Pera", "Peric", "aa@aa.g", "student"));
        k.setRezervacijaId(r);
		
	assertEquals(r,k.getRezervacijaId());
    }
    @Test
    void testSetRezervacijaNULL() {
       assertThrows(NullPointerException.class,
				() -> k.setRezervacijaId(null));
    }
    @Test
    void testSetStavkaOK() {
        Rezervacija r=new Rezervacija(1,2, new Klijent(1, "Pera", "Peric", "aa@aa.g", "student"));
       StavkaRezervacije s=new StavkaRezervacije(1, 10, 1, true, r, new Predstava(2, "Tataratira", "Here", LocalDateTime.MIN,3));
       k.setStavkaId(s);
		
	assertEquals(s,k.getStavkaId());
    }
    @Test
    void testSetStavkaNULL() {
       assertThrows(NullPointerException.class,
				() -> k.setStavkaId(null));
    }
    @Test
    @DisplayName ("Test za proveru toString metode Karte")
    void testToString() {
                k.setCena(200);
                k.setKartaId(2);
		
		Rezervacija r=new Rezervacija(1,2, new Klijent(4, "Pera", "Peric", "aa@aa.g", "student"));
                StavkaRezervacije s=new StavkaRezervacije(3, 10, 5, true, r, new Predstava(6, "Tataratira", "Here", LocalDateTime.MIN,3));
		k.setRezervacijaId(r);
                k.setStavkaId(s);
                
		String str = k.toString();

		assertTrue( str.contains("200") );
		assertTrue( str.contains("Pera") );
		assertTrue( str.contains("Peric") );
		assertTrue( str.contains("aa@aa.g") );
		assertTrue( str.contains("student") );
		assertTrue( str.contains("Tataratira") );
                assertTrue( str.contains("Here") );
                assertTrue( str.contains("true") );
                assertTrue( str.contains("1") );
                assertTrue( str.contains("10") );
                 assertTrue( str.contains("2") );
                 assertTrue( str.contains("3") );
                 assertTrue( str.contains("4") );
                 assertTrue( str.contains("5") );
                 assertTrue( str.contains("6") );
	}
    
    @ParameterizedTest
    @CsvSource ({
		"1,1,10,10,true",
		"1,1,10,12,false",
                "1,2,10,10,false",
                "2,1,10,12,false",
	})
    void testEqualsCena_ID(Integer id1,Integer id2,int cena,int cena2, boolean isti) {
    
                Rezervacija r=new Rezervacija(1,2, new Klijent(4, "Pera", "Peric", "aa@aa.g", "student"));
                StavkaRezervacije s=new StavkaRezervacije(3, 10, 5, true, r, new Predstava(6, "Tataratira", "Here", LocalDateTime.MIN,3));
		k.setId(id1);
		k.setCena(cena);
		Karta k2 = new Karta();
		k2.setId(id2);
                k2.setCena(cena2);
		k.setRezervacijaId(r);
                k2.setRezervacijaId(r);
                k.setStavkaId(s);
                k2.setStavkaId(s);
		assertEquals(isti, k.equals(k2));
    }	
    @Test
    void testEqualsDruga_Klasa() {
        
     assertFalse(k.equals(new Exception()));
    }
	
    @Test
    public void testEquals_Isti() {
     
       k=new Karta();
        assertTrue(k.equals(k));
    }

    @Test
    public void testEquals_Null() {
        
        k=new Karta();
        assertFalse(k.equals(null));
    }
    
    @Test
    public void testEquals_DifferentRezervacijaId_ReturnsFalse() {
        k=new Karta();
        Rezervacija r=new Rezervacija(1,2, new Klijent(4, "Pera", "Peric", "aa@aa.g", "student"));
        Rezervacija r2=new Rezervacija(2,2, new Klijent(3, "Mare", "Peric", "bb@aa.g", "student"));
        k.setRezervacijaId(r);
        k.setCena(0);
        k.setId(0);
        StavkaRezervacije s=new StavkaRezervacije(3, 10, 5, true, r, new Predstava(6, "Tataratira", "Here", LocalDateTime.MIN,3));
        k.setStavkaId(s);
        Karta karta2 = new Karta();
        karta2.setRezervacijaId(r2);
        karta2.setCena(0);
        karta2.setId(0);
        karta2.setStavkaId(s);
        boolean result = k.equals(karta2);
        assertFalse(result);
    }

    @Test
    public void testEquals_DifferentStavkaId_ReturnsFalse() {
        k=new Karta();
        Rezervacija r=new Rezervacija(1,2, new Klijent(4, "Pera", "Peric", "aa@aa.g", "student"));
        StavkaRezervacije s=new StavkaRezervacije(3, 10, 5, true, r, new Predstava(6, "Tataratira", "Here", LocalDateTime.MIN,3));
        k.setStavkaId(s);
        k.setRezervacijaId(r);
        k.setId(1);
        k.setCena(0);
        Karta karta2 = new Karta();
        StavkaRezervacije s2=new StavkaRezervacije(4, 1, 2, false, r, new Predstava(7, "Blabla", "Here", LocalDateTime.MIN,2));
        karta2.setStavkaId(s2);
        karta2.setRezervacijaId(r);
        karta2.setId(1);
        karta2.setCena(0);
        boolean result = k.equals(karta2);
        assertFalse(result);
    }


}
