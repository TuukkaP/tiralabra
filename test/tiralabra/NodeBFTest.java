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
public class NodeBFTest {
    
    private static NodeBF solmu;
    private static NodeBF solmu2;
    
    public NodeBFTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solmu = new NodeBF(0,0,null);
        solmu2 = new NodeBF(1,1,null);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class NodeBF.
     */
    @Test
    public void testCompareTo() {
        assertEquals(1, solmu.compareTo(solmu));
    }
}
