/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuukka
 */
public class VerkkoTest {
    
    public VerkkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Verkko.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Verkko instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKorkeus method, of class Verkko.
     */
    @Test
    public void testGetKorkeus() {
        System.out.println("getKorkeus");
        Verkko instance = null;
        int expResult = 0;
        int result = instance.getKorkeus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeveys method, of class Verkko.
     */
    @Test
    public void testGetLeveys() {
        System.out.println("getLeveys");
        Verkko instance = null;
        int expResult = 0;
        int result = instance.getLeveys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSolmu method, of class Verkko.
     */
    @Test
    public void testGetSolmu() {
        System.out.println("getSolmu");
        int y = 0;
        int x = 0;
        Verkko instance = null;
        Node expResult = null;
        Node result = instance.getSolmu(y, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlku method, of class Verkko.
     */
    @Test
    public void testGetAlku() {
        System.out.println("getAlku");
        Verkko instance = null;
        Node expResult = null;
        Node result = instance.getAlku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaali method, of class Verkko.
     */
    @Test
    public void testGetMaali() {
        System.out.println("getMaali");
        Verkko instance = null;
        Node expResult = null;
        Node result = instance.getMaali();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of piirraTulos method, of class Verkko.
     */
    @Test
    public void testPiirraTulos() {
        System.out.println("piirraTulos");
        Verkko instance = null;
        instance.piirraTulos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
