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
        Predstava p=new Predstava(1, "Taratira", "Beograd", LocalDateTime.MIN,100);
        st.setPredstavaId(p);
        assertEquals(p,st.getPredstavaId());
    }
      @Test
    public void testSetPredstavaNULL(){
       NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            st.setPredstavaId(null);
        });
    }
      @Test
    void testSetRezervacijaOK() {
        Rezervacija r=new Rezervacija(1,2, new Klijent(1, "Pera", "Peric", "aa@aa.g", "student"));
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
              st.setBrojSedista(8);
              st.setGledato(true);
              st.setPopust(20);
              st.setStavkaId(12);
              LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
              Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
              Rezervacija r=new Rezervacija(1,2, new Klijent(1, "Pera", "Peric", "aa@aa.g", "student"));
		st.setRezervacijaId(r);
                st.setPredstavaId(p);
                
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
                assertTrue( str.contains("10") );
                assertTrue( str.contains("0") );
                assertTrue( str.contains("12") );
                 assertTrue( str.contains("8") );
	}
       @ParameterizedTest
    @CsvSource ({
		"1,1,10,10,2,2,true,true,true",
		"1,1,10,10,2,2,false,true,false",
                "1,2,10,10,2,2,false,false,false",
                "1,2,10,9,2,2,false,false,false",
                "1,2,10,10,2,3,false,false,false",
                "2,1,10,9,2,3,true,false,false",
	})
    void testEqualsOcena_Gledao(Integer id,Integer id2,int popust,int popust2,int br1,int br2,boolean gl,boolean gl2, boolean isti) {
         LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
        Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
         Rezervacija r=new Rezervacija(1,2, new Klijent(1, "Pera", "Peric", "aa@aa.g", "student"));
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
        Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
         LocalDateTime ld2=LocalDateTime.of(2023, Month.SEPTEMBER, 20, 10, 0);
        Predstava p2=new Predstava(2, "Tataratira", "Here",ld2,100);
          Rezervacija r=new Rezervacija(1,2, new Klijent(1, "Pera", "Peric", "aa@aa.g", "student"));
		st.setRezervacijaId(r);
                st.setPredstavaId(p);
		st.setBrojSedista(2);
                st.setPopust(10);
                st.setGledato(true);
                st.setStavkaId(1);
         StavkaRezervacije st2=new StavkaRezervacije(1,2,10,true, r, p2);
               
        boolean result = st.equals(st2);
        assertFalse(result);
    }
     @Test
    public void testEquals_DifferentRezervacijaId_ReturnsFalse() {
        
        Rezervacija r=new Rezervacija(1,2, new Klijent(4, "Pera", "Peric", "aa@aa.g", "student"));
        Rezervacija r2=new Rezervacija(2,2, new Klijent(3, "Mare", "Peric", "bb@aa.g", "student"));
        st.setRezervacijaId(r);
         LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
        Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
                st.setPredstavaId(p);
		st.setBrojSedista(2);
                st.setPopust(10);
                st.setGledato(true);
                st.setStavkaId(1);
         StavkaRezervacije st2=new StavkaRezervacije(1,2,10,true, r2, p);
        boolean result = st.equals(st2);
        assertFalse(result);
    }
}
