/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ps.PSCommon.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author andelalausevic
 */
public class UserTest {
    
    User u;
    
    @BeforeEach
    public void setUp() {
        u=new User();
    }
    
    @AfterEach
    public void tearDown() {
        u=null;
    }

     @Test
    public void testSetImeNull() {
        // Testiranje kada je ime null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            u.setUsername(null);
        });
    }
    
    @Test
    public void testSetImePrazanString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            u.setUsername("");
        });
    }
    
    @Test
    public void testSetImeOK(){
        u.setUsername("alaus");
        assertEquals("alaus",u.getUsername());
    }
         @Test
    public void testSetPassNull() {
        // Testiranje kada je ime null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            u.setPassword(null);
        });
    }
    
    @Test
    public void testSetPassPrazanString(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            u.setPassword("");
        });
    }
    
    @Test
    public void testSetPassOK(){
        u.setPassword("alaus");
        assertEquals("alaus",u.getPassword());
    }
    @Test
    @DisplayName ("Test za proveru toString metode Usera")
    void testToString() {
                
                u.setUsername("admin");
		String str = u.toString();

		assertTrue( str.contains("admin") );
		
	
	}
    
    @ParameterizedTest
    @CsvSource ({
		"ala,ala,majk,majk,true",
		"ala,lala,majk,majk,false",
                "ala,ala,majk,tajk,false",
                "ala,lala,majk,tajk,false",
                
	})
    void testEquals(String ime,String ime2,String pass,String pass2,boolean isti) {
    
		u.setUsername(ime);
                u.setPassword(pass);
		User u2=new User(ime2, pass2);
		
		assertEquals(isti, u.equals(u2));
    }	
}
