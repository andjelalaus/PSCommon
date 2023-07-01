/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;


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
public class RezervacijaTest {
    
    Rezervacija r;
    
    @BeforeEach
    public void setUp() {
        r=new Rezervacija();
    }
    
    @AfterEach
    public void tearDown() {
        r=null;
    }

   @Test
    void testSetIDSveOk() {
         r.setId(2);
	 assertEquals(2,r.getRezervacijaId());
    }
    @Test
    void testSetIDManjiOdNule() {
	  assertThrows(IllegalArgumentException.class,
				() -> r.setRezervacijaId(-1));
    }
    @Test
    void testSetBrPredstaviOK() {
            r.setBrojPredstave(100);
		
	  assertEquals(100,r.getBrojPredstave());
    }
    @Test
    void testSetBrPredstaviManjaOd0() {
	    assertThrows(IllegalArgumentException.class, ()->r.setBrojPredstave(-1));
    }
     @Test
    public void testSetKlijentOK() {
        Klijent k=new Klijent();
        k.setKlijentId(1);
        k.setIme("Nikola");
        k.setEmail("micko@gmail.com");
        k.setPrezime("Micic");
        k.setStatus("student");
        
        r.setKlijentId(k);
        assertEquals(k,r.getKlijentId());
    }
    
    @Test
    public void testSetKlijentNULL(){
       assertThrows(NullPointerException.class, () -> {
            r.setKlijentId(null);
        });
    }
    @Test
    @DisplayName ("Test za proveru toString metode Rezervacije")
    void testToString() {
              
              
              Klijent k=new Klijent();
              k.setEmail("aa@aa.g");
              k.setIme("Pera");
              k.setPrezime("Peric");
              k.setStatus("student");
              k.setKlijentId(2);
              
              r.setKlijentId(k);
              r.setBrojPredstave(100);
              r.setRezervacijaId(9);
              
                
	      String str = r.toString();

              assertTrue( str.contains("100") );
	      assertTrue( str.contains("Pera") );
	      assertTrue( str.contains("Peric") );
	      assertTrue( str.contains("aa@aa.g") );
	      assertTrue( str.contains("student") );
		
              assertTrue( str.contains("9") );
              assertTrue( str.contains("2") );
                
	}
     @ParameterizedTest
    @CsvSource ({
		"1,1,10,10,true",
		"1,1,10,12,false",
                "1,2,10,10,false",
                "2,1,10,12,false",
	})
    void testEqualsCena_ID(Integer id1,Integer id2,int brP,int brP2, boolean isti) {
    
		r.setRezervacijaId(id1);
		r.setBrojPredstave(brP);
                
		Rezervacija r2=new Rezervacija();
		r2.setRezervacijaId(id2);
                r2.setBrojPredstave(brP2);
                
                Klijent k=new Klijent();
                k.setKlijentId(1);
                k.setIme("Nikola");
                k.setEmail("micko@gmail.com");
                k.setPrezime("Micic");
                k.setStatus("student");
              
                r.setKlijentId(k);
                r2.setKlijentId(k);
                
		assertEquals(isti, r.equals(r2));
    }	
    @Test
    void testEqualsDruga_Klasa() {
        
     assertFalse(r.equals(new Exception()));
    }
	
    @Test
    public void testEquals_Isti() {
     
     
        assertTrue(r.equals(r));
    }

    @Test
    public void testEquals_Null() {
        
       
        assertFalse(r.equals(null));
    }
    
    @Test
    public void testEquals_DifferentKlijent() {
                Klijent k=new Klijent();
                k.setKlijentId(1);
                k.setIme("Nikola");
                k.setEmail("micko@gmail.com");
                k.setPrezime("Micic");
                k.setStatus("student");
                
                Klijent k2=new Klijent();
                k2.setKlijentId(2);
                k2.setIme("Darko");
                k2.setEmail("darko@gmail.com");
                k2.setPrezime("Mandic");
                k2.setStatus("student");
                
                r.setBrojPredstave(100);
                r.setKlijentId(k);
                r.setRezervacijaId(2);
        
                Rezervacija r2=new Rezervacija();
                r2.setBrojPredstave(100);
                r2.setKlijentId(k2);
                r2.setRezervacijaId(2);
       
                
                boolean result = r.equals(r2);
                assertFalse(result);
    }
}
