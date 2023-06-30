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
public class PlanGledanjaTest {
    
   
    PlanGledanja pl;
    @BeforeEach
    public void setUp() {
        pl=new PlanGledanja();
    }
    
    @AfterEach
    public void tearDown() {
        pl=null;
    }

     @Test
    public void testSetKlijentOK() {
        Klijent k=new Klijent(1,"andjela", "lausevic", "aa@gg.com", "redovan");
        pl.setKlijentId(k);
        assertEquals(k,pl.getKlijentId());
    }
    
    @Test
    public void testSetKlijentNULL(){
       NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            pl.setKlijentId(null);
        });
    }
    
     @Test
    public void testSetPredstavaOk() {
        Predstava p=new Predstava(1, "Taratira", "Beograd", LocalDateTime.MIN,100);
        pl.setPredstavaId(p);
        assertEquals(p,pl.getPredstavaId());
    }
      @Test
    public void testSetPredstavaNULL(){
       NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            pl.setPredstavaId(null);
        });
    }
    @Test
    void testSetOcenaOK() {
            pl.setOcena(2);
		
	  assertEquals(2,pl.getOcena());
    }
    @Test
    void testSetOcenaManjaOd0() {
	    assertThrows(IllegalArgumentException.class, ()->pl.setOcena(-1));
    }
     @Test
    void testSetOcenaVecaOd10() {
	    assertThrows(IllegalArgumentException.class, ()->pl.setOcena(11));
    }
     @Test
    @DisplayName ("Test za proveru toString metode PlanGledanja")
    void testToString() {
              pl.setOcena(9);
              pl.setGledao(true);
              LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
              Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
              Klijent k=new Klijent(2,"Pera", "Peric", "aa@aa.g", "student");
              
		pl.setKlijentId(k);
                pl.setPredstavaId(p);
                
		String str = pl.toString();

		assertTrue( str.contains("100") );
		assertTrue( str.contains("Pera") );
		assertTrue( str.contains("Peric") );
		assertTrue( str.contains("aa@aa.g") );
		assertTrue( str.contains("student") );
		assertTrue( str.contains("Tataratira") );
                assertTrue( str.contains("Here") );
                assertTrue( str.contains("true") );
                assertTrue( str.contains("1") );
                assertTrue( str.contains("9") );
                 assertTrue( str.contains("2") );
                 assertTrue( str.contains("2023") );
                 assertTrue( str.contains("20") );
                 assertTrue( str.contains("11") );
                assertTrue( str.contains("10") );
                assertTrue( str.contains("0") );
	}
    @ParameterizedTest
    @CsvSource ({
		"1,1,true,true,true",
		"1,1,false,true,false",
                "1,2,false,false,false",
                "2,1,true,false,false",
	})
    void testEqualsOcena_Gledao(int ocena,int ocena2,boolean gl,boolean gl2, boolean isti) {
         LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
        Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
              Klijent k=new Klijent(2,"Pera", "Peric", "aa@aa.g", "student");
		pl.setPredstavaId(p);
                pl.setKlijentId(k);
                pl.setOcena(ocena);
                pl.setGledao(gl);
		PlanGledanja pl2=new PlanGledanja();
		pl2.setPredstavaId(p);
                pl2.setKlijentId(k);
                pl2.setOcena(ocena2);
                pl2.setGledao(gl2);
		assertEquals(isti, pl.equals(pl2));
    }	
      @Test
    void testEqualsDruga_Klasa() {
        
     assertFalse(pl.equals(new Exception()));
    }
	
    @Test
    public void testEquals_Isti() {
     
        assertTrue(pl.equals(pl));
    }

    @Test
    public void testEquals_Null() {
        
        assertFalse(pl.equals(null));
    }
    
    @Test
    public void testEquals_DifferentPredstava() {
        LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
        Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
         LocalDateTime ld2=LocalDateTime.of(2023, Month.SEPTEMBER, 20, 10, 0);
        Predstava p2=new Predstava(2, "Tataratira", "Here",ld2,100);
          Klijent k=new Klijent(2,"Pera", "Peric", "aa@aa.g", "student");
          pl.setOcena(10);
          pl.setKlijentId(k);
          pl.setPredstavaId(p);
          pl.setGledao(true);
       PlanGledanja pl2=new PlanGledanja(p2, k, Boolean.TRUE,10);
               
        boolean result = pl.equals(pl2);
        assertFalse(result);
    }

    @Test
    public void testEquals_DifferentKlijent_ReturnsFalse() {
        LocalDateTime ld=LocalDateTime.of(2023, Month.NOVEMBER, 20, 10, 0);
        Predstava p=new Predstava(1, "Tataratira", "Here",ld,100);
       
          Klijent k=new Klijent(2,"Pera", "Peric", "aa@aa.g", "student");
          Klijent k2=new Klijent(3,"lule", "Lulic", "ll@aa.g", "student");
          pl.setOcena(10);
          pl.setKlijentId(k);
          pl.setPredstavaId(p);
          pl.setGledao(true);
       PlanGledanja pl2=new PlanGledanja(p, k2, Boolean.TRUE,10);
               
        boolean result = pl.equals(pl2);
        assertFalse(result);
    }

    
}
