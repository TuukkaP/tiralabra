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
public class NodeTest {

    private static Node solmu1;
    private static Node solmu2;
    private static Node solmu3;
    private static Node maali;

    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        maali = new Node(4, 0, null);
        solmu1 = new Node(0, 0, maali);
        solmu2 = new Node(1, 0, maali);
        solmu3 = new Node(2, 0, maali);
        maali.setMaali(true);
        solmu1.setMatka(0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setMaali method, of class Node.
     */
    @Test
    public void testSetMaali() {
        assertTrue(maali.isMaali());
        assertFalse(solmu1.isMaali());
    }

    /**
     * Test of setMaaliSolmu method, of class Node.
     */
    @Test
    public void testSetMaaliSolmu() {
        assertEquals(solmu1.getMaaliSolmu(), maali);
        solmu1.setMaaliSolmu(solmu2);
        assertEquals(solmu1.getMaaliSolmu(), solmu2);

    }

    /**
     * Test of getMaaliSolmu method, of class Node.
     */
    @Test
    public void testGetMaaliSolmu() {
        assertEquals(solmu1.getMaaliSolmu(), maali);
        solmu1.setMaaliSolmu(solmu2);
        assertEquals(solmu1.getMaaliSolmu(), solmu2);

    }

    /**
     * Test of getEdellinen method, of class Node.
     */
    @Test
    public void testGetEdellinen() {
        assertEquals(solmu2.getEdellinen(), null);
    }

    /**
     * Test of getPaino method, of class Node.
     */
    @Test
    public void testGetPaino() {
        assertEquals(solmu2.getPaino(), 2);
    }

    /**
     * Test of getX method, of class Node.
     */
    @Test
    public void testGetX() {
        assertEquals(solmu2.getX(), 1);
    }

    /**
     * Test of getY method, of class Node.
     */
    @Test
    public void testGetY() {
        assertEquals(solmu2.getX(), 1);
    }

    /**
     * Test of isKayty method, of class Node.
     */
    @Test
    public void testIsKayty() {
        assertFalse(solmu1.isKayty());
    }

    /**
     * Test of setEdellinen method, of class Node.
     */
    @Test
    public void testSetEdellinen() {
        solmu2.setEdellinen(solmu1);
        assertEquals(solmu2.getEdellinen(), solmu1);
    }

    /**
     * Test of setKayty method, of class Node.
     */
    @Test
    public void testSetKayty() {
        solmu1.setKayty(true);
        assertTrue(solmu1.isKayty());
    }

    /**
     * Test of setPaino method, of class Node.
     */
    @Test
    public void testSetPaino() {
        solmu2.setPaino(5);
        assertEquals(solmu2.getPaino(), 5);
    }

    /**
     * Test of setX method, of class Node.
     */
    @Test
    public void testSetX() {
        solmu1.setX(6);
        assertEquals(solmu1.getX(), 6);
    }

    /**
     * Test of setY method, of class Node.
     */
    @Test
    public void testSetY() {
        solmu1.setY(6);
        assertEquals(solmu1.getY(), 6);
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        String vastaus = "Solmu X:[" + solmu1.getX() + "] Y:[" + solmu1.getY() + "]";
        assertTrue(vastaus.equalsIgnoreCase(solmu1.toString()));
    }

    /**
     * Test of compareTo method, of class Node.
     */
    @Test
    public void testCompareTo() {
        solmu1.setMatka(0);
        solmu1.setPaino(0);
        solmu2.setMatka(0);
        solmu2.setPaino(0);
        assertEquals(1, solmu1.compareTo(solmu2));
    }

    /**
     * Test of heuristiikka method, of class Node.
     */
    @Test
    public void testHeuristiikka() {
        int deltaX = solmu1.getX() - maali.getX();
        int deltaY = solmu1.getY() - maali.getY();
        assertEquals(Math.hypot(deltaX, deltaY), solmu1.heuristiikka(maali),0);
    }

    /**
     * Test of isMaali method, of class Node.
     */
    @Test
    public void testIsMaali() {
        assertTrue(maali.isMaali());
        assertFalse(solmu1.isMaali());
    }

    /**
     * Test of getMatka method, of class Node.
     */
    @Test
    public void testGetMatka() {
        assertEquals(0, solmu1.getMatka());
        assertEquals(Integer.MAX_VALUE, solmu3.getMatka());
    }

    /**
     * Test of setMatka method, of class Node.
     */
    @Test
    public void testSetMatka() {
        solmu3.setMatka(0);
        assertEquals(0, solmu3.getMatka());
    }
}
