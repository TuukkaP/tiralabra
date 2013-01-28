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
public class NodeDTest {
    
     private static NodeD solmu;
    private static NodeD solmu2;
    
    public NodeDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solmu = new NodeD(0,0,null);
        solmu2 = new NodeD(1,1,null);
        solmu.setMatka(1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class NodeD.
     */
    @Test
    public void testCompareTo() {
        assertTrue(solmu.compareTo(solmu2) < 0);
        assertTrue(solmu2.compareTo(solmu) > 0);
    }
}
