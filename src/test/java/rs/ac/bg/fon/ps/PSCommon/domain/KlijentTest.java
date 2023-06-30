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
public class KlijentTest {
    
    Klijent klijent;

    @BeforeEach
    void setUp() throws Exception {
        klijent = new Klijent();
    }

    @AfterEach
    void tearDown() throws Exception {
        klijent = null;
    }

    @Test
    public void testSetKlijentIdOK() {
        // Testiranje kada je klijentId veći od 0
        klijent.setKlijentId(5);
        assertEquals(5, klijent.getKlijentId());
    }
    
    @Test
    public void testSetKlijentIdManjeOd0(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            klijent.setKlijentId(-1);
        });
    }

    @Test
    public void testSetImeNull() {
        // Testiranje kada je ime null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            klijent.setIme(null);
        });
    }
    
    @Test
    public void testSetImePrazanString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            klijent.setIme("");
        });
    }
    
    @Test
    public void testSetImeOK(){
        klijent.setIme("John");
        assertEquals("John", klijent.getIme());
    }
        @Test
    public void testSetPrezimeNULL() {
        // Testiranje kada je ime null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            klijent.setPrezime(null);
        });
    }
    
    @Test
    public void testSetPrezimePrazanString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            klijent.setPrezime("");
        });
    }
    
    @Test
    public void testSetPrezimeOK(){
        klijent.setPrezime("Johnes");
        assertEquals("Johnes", klijent.getPrezime());
    }
            @Test
    public void testSetMejlNULL() {
        // Testiranje kada je ime null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            klijent.setEmail(null);
        });
    }
    
    @Test
    public void testSetMejlPrazanString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            klijent.setEmail("");
        });
    }
    
    @Test
    public void testSetMejlOK(){
        klijent.setEmail("aa@gg.com");
        assertEquals("aa@gg.com", klijent.getEmail());
    }
                @Test
    public void testSetStatusNULL() {
        // Testiranje kada je ime null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            klijent.setStatus(null);
        });
    }
    
    @Test
    public void testSetStatusPrazanString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            klijent.setStatus("");
        });
    }
    
    @Test
    public void testSetStatusOK(){
        klijent.setStatus("redovan");
        assertEquals("redovan", klijent.getStatus());
    }
    @Test
    @DisplayName ("Test za proveru toString metode Klijent")
    void testToString() {
                klijent.setId(1);
                klijent.setIme("Andjela");
                klijent.setPrezime("Lausevic");
                klijent.setEmail("an@gmail.com");
                klijent.setStatus("student");
                
		String str = klijent.toString();

		assertTrue( str.contains("1") );
		assertTrue( str.contains("Andjela") );
		assertTrue( str.contains("Lausevic") );
		assertTrue( str.contains("an@gmail.com") );
		assertTrue( str.contains("student") );
	
	}
    
    @ParameterizedTest
    @CsvSource ({
		"1,1,majk,majk,laus,laus,aa@gg.g,aa@gg.g,redovan,redovan,true",
		"1,1,majk,majk,laus,laus,aa@gg.g,aa@gg.g,redovan,student,true",
                "1,1,majk,majk,laus,laus,aa@gg.g,aa@tt.g,redovan,redovan,false",
                "1,1,majk,majk,laus,jones,aa@gg.g,aa@gg.g,redovan,redovan,false",
                "1,1,majk,riki,laus,laus,aa@gg.g,aa@gg.g,redovan,redovan,false",
                "1,2,majk,majk,laus,laus,aa@gg.g,aa@gg.g,redovan,redovan,false",
                "1,2,majk,riki,laus,maus,aa@g.g,aa@gg.g,student,redovan,false",
	})
    void testEquals(Integer id1,Integer id2,String ime,String ime2,String prezime1,String prezime2,String email,String email2,String status,String status2, boolean isti) {
    
		klijent.setKlijentId(id1);
		klijent.setIme(ime);
                klijent.setPrezime(prezime1);
                klijent.setStatus(status);
                klijent.setEmail(email);
                
		Klijent k2 = new Klijent();
		k2.setKlijentId(id2);
                k2.setIme(ime2);
                k2.setPrezime(prezime2);
                k2.setStatus(status2);
                k2.setEmail(email2);
		assertEquals(isti, klijent.equals(k2));
    }	
    @Test
    void testEqualsDruga_Klasa() {
        
     assertFalse(klijent.equals(new Exception()));
    }
	
    @Test
    public void testEquals_Isti() {
     
       
        assertTrue(klijent.equals(klijent));
    }

    @Test
    public void testEquals_Null() {
        
       
        assertFalse(klijent.equals(null));
    }
    
   
}
