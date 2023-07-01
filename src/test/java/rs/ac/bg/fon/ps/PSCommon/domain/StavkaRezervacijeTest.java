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
public class StavkaRezervacijeTest {
    
   StavkaRezervacije st;
    
    @BeforeEach
    public void setUp() {
       st=new StavkaRezervacije();
    }
    
    @AfterEach
    public void tearDown() {
        st=null;
    }
     @Test
    void testSetIDSveOk() {
         st.setId(2);
	 assertEquals(2,st.getStavkaId());
    }
    @Test
    void testSetIDManjiOdNule() {
	  assertThrows(IllegalArgumentException.class,
				() -> st.setStavkaId(-1));
    }
    @Test
    void testSetPopustOK() {
            st.setPopust(0);
		
	  assertEquals(0,st.getPopust());
    }
    @Test
    void testSetPopustManjaOd0() {
	    assertThrows(IllegalArgumentException.class, ()->st.setPopust(-1));
    }
     @Test
    void testSetPopustVecaOd100() {
	    assertThrows(IllegalArgumentException.class, ()->st.setPopust(102));
    }
      @Test
    void testSetSedistaOK() {
            st.setBrojSedista(1);
		
	  assertEquals(1,st.getBrojSedista());
    }
    @Test
    void testSetSedistaManjaOd1() {
	    assertThrows(IllegalArgumentException.class, ()->st.setBrojSedista(-1));
    }
       @Test
    public void testSetPredstavaOk() {
        Predstava p=new Predstava();
        p.setPredstavaId(1);
        p.setMesto("Velika scena");
        p.setNaziv("Bajadera");
        p.setKapacitet(190);
        p.setVreme(LocalDateTime.MIN);
        
        st.setPredstavaId(p);
        assertEquals(p,st.getPredstavaId());
    }
      @Test
    public void testSetPredstavaNULL(){
       assertThrows(NullPointerException.class, () -> {
            st.setPredstavaId(null);
        });
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
        
        st.setRezervacijaId(r);
		
	assertEquals(r,st.getRezervacijaId());
    }
    @Test
    void testSetRezervacijaNULL() {
       assertThrows(NullPointerException.class,
				() -> st.setRezervacijaId(null));
    }
    @Test
    @DisplayName ("Test za proveru toString metode StavkaRezervacije")
    void testToString() {
              
              LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
              
              Predstava p=new Predstava();
              p.setId(1);
              p.setKapacitet(100);
              p.setVreme(ld);
              p.setNaziv("Tataratira");
              p.setMesto("Here");
              
              Klijent k=new Klijent();
              k.setIme("Pera");
              k.setPrezime("Peric");
              k.setEmail("aa@aa.g");
              k.setStatus("student");
              k.setId(4);
              
              Rezervacija r=new Rezervacija();
              r.setBrojPredstave(2);
              r.setId(3);
              r.setKlijentId(k);
              
	      st.setRezervacijaId(r);
              st.setPredstavaId(p);
              st.setBrojSedista(8);
              st.setGledato(true);
              st.setPopust(20);
              st.setStavkaId(12);
                
	      String str = st.toString();

		assertTrue( str.contains("100") );
		assertTrue( str.contains("Pera") );
		assertTrue( str.contains("Peric") );
		assertTrue( str.contains("aa@aa.g") );
		assertTrue( str.contains("student") );
		assertTrue( str.contains("Tataratira") );
                assertTrue( str.contains("Here") );
                assertTrue( str.contains("true") );
                assertTrue( str.contains("1") );
                assertTrue( str.contains("2") );
                assertTrue( str.contains("2023") );
                assertTrue( str.contains("20") );
                assertTrue( str.contains("11") );
                assertTrue( str.contains("0") );
                assertTrue( str.contains("10") );
                assertTrue( str.contains("3") );
                assertTrue( str.contains("4") );
                assertTrue( str.contains("12") );
                assertTrue( str.contains("8") );
	}
       @ParameterizedTest
    @CsvSource ({
		"1,1,10,10,2,2,true,true,true",
		"1,1,10,10,2,2,false,true,false",
                "1,2,10,10,2,2,false,false,false",
                "1,1,10,9,2,2,false,false,false",
                "1,1,10,10,2,3,false,false,false",
                "2,1,10,9,2,3,true,false,false",
	})
    void testEqualsOcena_Gledao(Integer id,Integer id2,int popust,int popust2,int br1,int br2,boolean gl,boolean gl2, boolean isti) {
              LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
              Predstava p=new Predstava();
              p.setId(1);
              p.setKapacitet(100);
              p.setVreme(ld);
              p.setNaziv("Tataratira");
              p.setMesto("Here");
              
              Klijent k=new Klijent();
              k.setIme("Pera");
              k.setPrezime("Peric");
              k.setEmail("aa@aa.g");
              k.setStatus("student");
              k.setId(4);
              
              Rezervacija r=new Rezervacija();
              r.setBrojPredstave(2);
              r.setId(3);
              r.setKlijentId(k);
              
	      st.setRezervacijaId(r);
              st.setPredstavaId(p);
	      st.setBrojSedista(br1);
              st.setPopust(popust);
              st.setGledato(gl);
              st.setStavkaId(id);
                
	      StavkaRezervacije st2=new StavkaRezervacije();
              st2.setRezervacijaId(r);
              st2.setPredstavaId(p);
	      st2.setBrojSedista(br2);
              st2.setPopust(popust2);
              st2.setGledato(gl2);
              st2.setStavkaId(id2);
		
              assertEquals(isti, st.equals(st2));
    }	
      @Test
    void testEqualsDruga_Klasa() {
        
     assertFalse(st.equals(new Exception()));
    }
	
    @Test
    public void testEquals_Isti() {
     
        assertTrue(st.equals(st));
    }

    @Test
    public void testEquals_Null() {
        
        assertFalse(st.equals(null));
    }
    
    @Test
    public void testEquals_DifferentPredstava() {
              LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
              Predstava p=new Predstava();
              p.setId(1);
              p.setKapacitet(100);
              p.setVreme(ld);
              p.setNaziv("Tataratira");
              p.setMesto("Here");
              
              LocalDateTime ld2=LocalDateTime.of(2023, Month.SEPTEMBER, 20, 10, 0);
              Predstava p2=new Predstava();
              p2.setId(2);
              p2.setKapacitet(100);
              p2.setVreme(ld2);
              p2.setNaziv("Tataratira");
              p2.setMesto("Here");
              
              Klijent k=new Klijent();
              k.setIme("Pera");
              k.setPrezime("Peric");
              k.setEmail("aa@aa.g");
              k.setStatus("student");
              k.setId(4);
              
              Rezervacija r=new Rezervacija();
              r.setBrojPredstave(2);
              r.setId(3);
              r.setKlijentId(k);
              
	      st.setRezervacijaId(r);
              st.setPredstavaId(p);
	      st.setBrojSedista(2);
              st.setPopust(10);
              st.setGledato(true);
              st.setStavkaId(1);
              
              
              StavkaRezervacije st2=new StavkaRezervacije();
              st2.setRezervacijaId(r);
              st2.setPredstavaId(p2);
	      st2.setBrojSedista(2);
              st2.setPopust(10);
              st2.setGledato(true);
              st2.setStavkaId(1);
               
              boolean result = st.equals(st2);
              assertFalse(result);
    }
     @Test
    public void testEquals_DifferentRezervacijaId_ReturnsFalse() {
        
        LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
              Predstava p=new Predstava();
              p.setId(1);
              p.setKapacitet(100);
              p.setVreme(ld);
              p.setNaziv("Tataratira");
              p.setMesto("Here");
              
              Klijent k=new Klijent();
              k.setIme("Pera");
              k.setPrezime("Peric");
              k.setEmail("aa@aa.g");
              k.setStatus("student");
              k.setId(4);
              
              Rezervacija r=new Rezervacija();
              r.setBrojPredstave(2);
              r.setId(3);
              r.setKlijentId(k);
              
              Rezervacija r2=new Rezervacija();
              r2.setBrojPredstave(3);
              r2.setId(4);
              r2.setKlijentId(k);
              
	      st.setRezervacijaId(r);
              st.setPredstavaId(p);
	      st.setBrojSedista(2);
              st.setPopust(10);
              st.setGledato(true);
              st.setStavkaId(1);
              
              
              StavkaRezervacije st2=new StavkaRezervacije();
              st2.setRezervacijaId(r2);
              st2.setPredstavaId(p);
	      st2.setBrojSedista(2);
              st2.setPopust(10);
              st2.setGledato(true);
              st2.setStavkaId(1);
              
              boolean result = st.equals(st2);
              assertFalse(result);
    }
}
