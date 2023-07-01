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
public class PredstavaTest {
    
   
    Predstava p;
    @BeforeEach
    public void setUp() {
        p=new Predstava();
        
    }
    
    @AfterEach
    public void tearDown() {
        p=null;
    }

    @Test
    void testSetIDSveOk() {
         p.setPredstavaId(2);
	 assertEquals(2,p.getPredstavaId());
    }
    @Test
    void testSetIDManjiOdNule() {
	  assertThrows(IllegalArgumentException.class,
				() -> p.setPredstavaId(-1));
    }
    @Test
    void testSetKapcitetOk() {
            p.setKapacitet(100);
		
	  assertEquals(100,p.getKapacitet());
    }
    @Test
    void testSetKapacitetManjaOd0() {
	    assertThrows(IllegalArgumentException.class, ()->p.setKapacitet(-1));
    }
     @Test
    public void testSetImeNull() {
        assertThrows(NullPointerException.class, () -> {
            p.setNaziv(null);
        });
    }
    
    @Test
    public void testSetImePrazanString(){
       assertThrows(IllegalArgumentException.class, ()->{
            p.setNaziv("");
        });
    }
    
    @Test
    public void testSetImeOK(){
        p.setNaziv("Dama sa kamelijama");
        assertEquals("Dama sa kamelijama", p.getNaziv());
    }
         @Test
    public void testSetMestoNull() {
        // Testiranje kada je ime null
       assertThrows(NullPointerException.class, () -> {
            p.setMesto(null);
        });
    }
    
    @Test
    public void testSetMestoPrazanString(){
       assertThrows(IllegalArgumentException.class, ()->{
            p.setMesto("");
        });
    }
    
    @Test
    public void testSetMestoOK(){
        p.setMesto("Narodno pozoriste");
        assertEquals("Narodno pozoriste", p.getMesto());
    }
        @Test
    public void testSetVremeOK(){
        LocalDateTime ld=LocalDateTime.of(2023, Month.MARCH, 10, 20, 0);
        
        p.setVreme(ld);
        assertEquals(ld,p.getVreme());
    }
         @Test
    public void testSetVremeNull() {
        // Testiranje kada je ime null
      assertThrows(NullPointerException.class, () -> {
            p.setVreme(null);
        });
    }
    @Test
    @DisplayName ("Test za proveru toString metode Predstava")
    void testToString() {
                LocalDateTime ld=LocalDateTime.of(2023, Month.MARCH, 10, 20, 0);

                p.setId(1);
                p.setKapacitet(200);
                p.setMesto("Here");
                p.setNaziv("Tataratira");
                p.setVreme(ld);
		String str = p.toString();

		assertTrue( str.contains("200"));
		assertTrue( str.contains("Tataratira") );
                assertTrue( str.contains("Here") );
                assertTrue( str.contains("1") );
                assertTrue( str.contains("10") );
                assertTrue( str.contains("20") );
                assertTrue( str.contains("3") );
                assertTrue( str.contains("2023") );
                assertTrue( str.contains("0") );
	}
    @ParameterizedTest
    @CsvSource ({
		"1,1,kihot,kihot,BG,BG,100,100,2023-03-10T20:00,2023-03-10T20:00,true",
		"1,1,kihot,kihot,BG,BG,100,100,2023-03-10T20:00,2023-03-10T20:10,false",
                "1,1,kihot,kihot,BG,BG,100,200,2023-03-10T20:00,2023-03-10T20:00,true",
                "1,1,kihot,kihot,BG,CG,100,100,2023-03-10T20:00,2023-03-10T20:00,false",
                "1,1,kihot,faust,BG,BG,100,100,2023-03-10T20:00,2023-03-10T20:00,false",
                "1,2,kihot,kihot,BG,BG,100,100,2023-03-10T20:00,2023-03-10T20:00,false",
                "1,2,kihot,faust,BG,CG,100,200,2023-03-10T20:00,2023-03-10T21:00,false",
	})
    void testEquals(Integer id1,Integer id2,String naziv,String naziv2,String mesto,String mesto2,int kapacitet,int kapacitet2,LocalDateTime vreme,LocalDateTime vreme2, boolean isti) {
    
		p.setId(id1);
                p.setNaziv(naziv);
                p.setMesto(mesto);
                p.setVreme(vreme);
                p.setKapacitet(kapacitet);
                
		Predstava p2=new Predstava();
		p2.setId(id2);
                p2.setNaziv(naziv2);
                p2.setMesto(mesto2);
                p2.setVreme(vreme2);
                p2.setKapacitet(kapacitet2);
                
		assertEquals(isti, p.equals(p2));
    }	
}
