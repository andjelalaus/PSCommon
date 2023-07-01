/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;

import java.time.LocalDateTime;
import java.time.Month;
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
        Klijent klij=new Klijent();
        klij.setKlijentId(1);
        klij.setIme("Nadja");
        klij.setEmail("nadja@jezd.com");
        klij.setPrezime("Jezdimirovic");
        klij.setStatus("nezaposlena");
        
        Rezervacija r=new Rezervacija();
        r.setRezervacijaId(1);
        r.setKlijentId(klij);
        r.setBrojPredstave(1);
        
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
        
        Klijent klij=new Klijent();
        klij.setKlijentId(1);
        klij.setIme("Nadja");
        klij.setEmail("nadja@jezd.com");
        klij.setPrezime("Jezdimirovic");
        klij.setStatus("nezaposlena");
        
        Rezervacija r=new Rezervacija();
        r.setRezervacijaId(1);
        r.setKlijentId(klij);
        r.setBrojPredstave(1);
        
        Predstava p=new Predstava();
        p.setPredstavaId(1);
        p.setMesto("Velika scena");
        p.setNaziv("Bajadera");
        p.setKapacitet(190);
        p.setVreme(LocalDateTime.MIN);
        
        StavkaRezervacije st=new StavkaRezervacije();
        st.setBrojSedista(10);
        st.setRezervacijaId(r);
        st.setPredstavaId(p);
        st.setGledato(true);
        st.setPopust(10);
        st.setStavkaId(1);
        
        k.setStavkaId(st);
		
	assertEquals(st,k.getStavkaId());
    }
    @Test
    void testSetStavkaNULL() {
       assertThrows(NullPointerException.class,
				() -> k.setStavkaId(null));
    }
    @Test
    @DisplayName ("Test za proveru toString metode Karte")
    void testToString() {
        
		    Klijent klij=new Klijent();
                    klij.setKlijentId(1);
                    klij.setIme("Nadja");
                    klij.setEmail("nadja@jezd.com");
                    klij.setPrezime("Jezdimirovic");
                    klij.setStatus("nezaposlena");

                    Rezervacija r=new Rezervacija();
                    r.setRezervacijaId(4);
                    r.setKlijentId(klij);
                    r.setBrojPredstave(3);

                    Predstava p=new Predstava();
                    p.setPredstavaId(2);
                    p.setMesto("Velika scena");
                    p.setNaziv("Esmeralda");
                    p.setKapacitet(190);
                    LocalDateTime ld=LocalDateTime.of(2023, Month.AUGUST, 9, 20, 0);
                    p.setVreme(ld);

                    StavkaRezervacije st=new StavkaRezervacije();
                    st.setBrojSedista(7);
                    st.setRezervacijaId(r);
                    st.setPredstavaId(p);
                    st.setGledato(true);
                    st.setPopust(10);
                    st.setStavkaId(5);
                    
                    k.setCena(200);
                    k.setKartaId(6);
                    k.setRezervacijaId(r);
                    k.setStavkaId(st);
                
                    String str = k.toString();

                    assertTrue( str.contains("190") );
                    assertTrue( str.contains("200") );
                    assertTrue( str.contains("Nadja") );
                    assertTrue( str.contains("Jezdimirovic") );
                    assertTrue( str.contains("nadja@jezd.com") );
                    assertTrue( str.contains("nezaposlena") );
                    assertTrue( str.contains("Esmeralda") );
                    assertTrue( str.contains("Velika scena") );
                    assertTrue( str.contains("true") );
                    assertTrue( str.contains("1") );
                    assertTrue( str.contains("10") );
                    assertTrue( str.contains("2") );
                    assertTrue( str.contains("3") );
                    assertTrue( str.contains("4") );
                    assertTrue( str.contains("5") );
                    assertTrue( str.contains("6") );
                    assertTrue( str.contains("7") );
                    assertTrue( str.contains("9") );
                    assertTrue( str.contains("2023") );
                    assertTrue( str.contains("20") );
                    assertTrue( str.contains("8") );
                    assertTrue( str.contains("0") );
	}
    
    @ParameterizedTest
    @CsvSource ({
		"1,1,10,10,true",
		"1,1,10,12,false",
                "1,2,10,10,false",
                "2,1,10,12,false",
	})
    void testEqualsCena_ID(Integer id1,Integer id2,int cena,int cena2, boolean isti) {
    
                Klijent klij=new Klijent();
                klij.setKlijentId(1);
                klij.setIme("Nadja");
                klij.setEmail("nadja@jezd.com");
                klij.setPrezime("Jezdimirovic");
                klij.setStatus("nezaposlena");

                Rezervacija r=new Rezervacija();
                r.setRezervacijaId(4);
                r.setKlijentId(klij);
                r.setBrojPredstave(3);

                Predstava p=new Predstava();
                p.setPredstavaId(2);
                p.setMesto("Velika scena");
                p.setNaziv("Esmeralda");
                p.setKapacitet(190);
                p.setVreme(LocalDateTime.MIN);
		
                StavkaRezervacije st=new StavkaRezervacije();
                st.setBrojSedista(10);
                st.setRezervacijaId(r);
                st.setPredstavaId(p);
                st.setGledato(true);
                st.setPopust(10);
                st.setStavkaId(1);
                
                k.setId(id1);
		k.setCena(cena);
                
		Karta k2 = new Karta();
		k2.setId(id2);
                k2.setCena(cena2);
                
		k.setRezervacijaId(r);
                k2.setRezervacijaId(r);
                k.setStavkaId(st);
                k2.setStavkaId(st);
                
		assertEquals(isti, k.equals(k2));
    }	
    @Test
    void testEqualsDruga_Klasa() {
        
     assertFalse(k.equals(new Exception()));
    }
	
    @Test
    public void testEquals_Isti() {
     
       
        assertTrue(k.equals(k));
    }

    @Test
    public void testEquals_Null() {
        
        
        assertFalse(k.equals(null));
    }
    
    @Test
    public void testEquals_DifferentRezervacijaId_ReturnsFalse() {
        
                Klijent klij=new Klijent();
                klij.setKlijentId(1);
                klij.setIme("Nadja");
                klij.setEmail("nadja@jezd.com");
                klij.setPrezime("Jezdimirovic");
                klij.setStatus("nezaposlena");

                Rezervacija r=new Rezervacija();
                r.setRezervacijaId(4);
                r.setKlijentId(klij);
                r.setBrojPredstave(3);
                
                Rezervacija r2=new Rezervacija();
                r2.setRezervacijaId(5);
                r2.setKlijentId(klij);
                r2.setBrojPredstave(2);

                Predstava p=new Predstava();
                p.setPredstavaId(2);
                p.setMesto("Velika scena");
                p.setNaziv("Esmeralda");
                p.setKapacitet(190);
                p.setVreme(LocalDateTime.MIN);
		
                StavkaRezervacije st=new StavkaRezervacije();
                st.setBrojSedista(10);
                st.setRezervacijaId(r);
                st.setPredstavaId(p);
                st.setGledato(true);
                st.setPopust(10);
                st.setStavkaId(1);             
        
                k.setRezervacijaId(r);
                k.setCena(0);
                k.setId(1);
                k.setStavkaId(st);
                
                Karta karta2 = new Karta();
                karta2.setRezervacijaId(r2);
                karta2.setCena(0);
                karta2.setId(1);
                karta2.setStavkaId(st);
                
                boolean result = k.equals(karta2);
                assertFalse(result);
    }

    @Test
    public void testEquals_DifferentStavkaId_ReturnsFalse() {
        
                Klijent klij=new Klijent();
                klij.setKlijentId(1);
                klij.setIme("Nadja");
                klij.setEmail("nadja@jezd.com");
                klij.setPrezime("Jezdimirovic");
                klij.setStatus("nezaposlena");

                Rezervacija r=new Rezervacija();
                r.setRezervacijaId(4);
                r.setKlijentId(klij);
                r.setBrojPredstave(3);
                
                Rezervacija r2=new Rezervacija();
                r2.setRezervacijaId(5);
                r2.setKlijentId(klij);
                r2.setBrojPredstave(2);

                Predstava p=new Predstava();
                p.setPredstavaId(2);
                p.setMesto("Velika scena");
                p.setNaziv("Esmeralda");
                p.setKapacitet(190);
                p.setVreme(LocalDateTime.MIN);
		
                StavkaRezervacije st=new StavkaRezervacije();
                st.setBrojSedista(10);
                st.setRezervacijaId(r);
                st.setPredstavaId(p);
                st.setGledato(true);
                st.setPopust(10);
                st.setStavkaId(1);
                
                StavkaRezervacije st2=new StavkaRezervacije();
                st2.setBrojSedista(1);
                st2.setRezervacijaId(r2);
                st2.setPredstavaId(p);
                st2.setGledato(false);
                st2.setPopust(5);
                st2.setStavkaId(2);
                
                k.setStavkaId(st);
                k.setRezervacijaId(r);
                k.setId(1);
                k.setCena(0);
                
                Karta karta2 = new Karta();
                karta2.setStavkaId(st2);
                karta2.setRezervacijaId(r);
                karta2.setId(1);
                karta2.setCena(0);
                
        boolean result = k.equals(karta2);
        assertFalse(result);
    }


}
