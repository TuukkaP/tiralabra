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
public class MinKekoTest {

    private static Kuva kuva;
    private static Node[] taulu;
    private static MinKeko keko;

    public MinKekoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kuva = new Kuva("testiKuva.png");
        taulu = new Node[6];
        keko = new MinKeko(taulu);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class MinKeko.
     */
    @Test
    public void testIsEmpty() {
        Node[] taulu2 = new Node[6];
        MinKeko keko2 = new MinKeko(taulu2);
        assertEquals(0, keko2.getKeonKoko());
        keko2.add(new Node(1, 1, null));
        assertEquals(1, keko2.getKeonKoko());
        keko2.poll();
        assertEquals(0, keko2.getKeonKoko());
    }

    /**
     * Test of add method, of class MinKeko.
     */
    @Test
    public void testAdd() {
        Node maaliSolmu = new Node(2, 2, null);
        Node testiSolmu = new Node(0, 0, maaliSolmu);
        Node testiSolmu2 = new Node(1, 1, maaliSolmu);
        Node testiSolmu3 = new Node(2, 1, maaliSolmu);
        testiSolmu.setMatka(4);
        testiSolmu2.setMatka(3);
        testiSolmu3.setMatka(1);
        keko.add(testiSolmu3);
        keko.add(testiSolmu);
        keko.add(testiSolmu2);
        assertEquals(testiSolmu3, keko.poll());
        assertEquals(testiSolmu2, keko.poll());
        assertEquals(testiSolmu, keko.poll());
        assertEquals(null, keko.poll());
        keko.add(null);
        assertEquals(0, keko.getKeonKoko());
    }

    /**
     * Test of poll method, of class MinKeko.
     */
    @Test
    public void testPoll() {
        assertEquals(null, keko.poll());
        Node maaliSolmu = new Node(2, 2, null);
        Node testiSolmu = new Node(0, 0, maaliSolmu);
        Node testiSolmu2 = new Node(1, 1, maaliSolmu);
        Node testiSolmu3 = new Node(2, 1, maaliSolmu);
        testiSolmu.setMatka(4);
        testiSolmu2.setMatka(3);
        testiSolmu3.setMatka(1);
        keko.add(testiSolmu);
        keko.add(testiSolmu3);
        keko.add(testiSolmu2);
        assertEquals(testiSolmu3, keko.poll());
        assertEquals(testiSolmu2, keko.poll());
        assertEquals(testiSolmu, keko.poll());
    }

    /**
     * Test of toString method, of class MinKeko.
     */
    @Test
    public void testToString() {
        Node maaliSolmu = new Node(2, 2, null);
        Node testiSolmu = new Node(0, 0, maaliSolmu);
        Node testiSolmu2 = new Node(1, 1, maaliSolmu);
        testiSolmu.setMatka(4);
        testiSolmu2.setMatka(3);
        keko.add(testiSolmu);
        keko.add(testiSolmu2);
        String vastaus = testiSolmu2.toString() + ", "+testiSolmu2.getMatka()+"\n" + testiSolmu.toString() + ", "+testiSolmu.getMatka()+"\n" + keko.getKeonKoko() + "";
        String vastaus2 = keko.toString();
        assertTrue(vastaus2.equalsIgnoreCase(vastaus));
    }

    /**
     * Test of getKeonKoko method, of class MinKeko.
     */
    @Test
    public void testGetKeonKoko() {
        Node maaliSolmu = new Node(2, 2, null);
        assertEquals(0, keko.getKeonKoko());
        keko.add(new Node(1, 1, maaliSolmu));
        assertEquals(1, keko.getKeonKoko());
        keko.add(new Node(2, 2, maaliSolmu));
        assertEquals(2, keko.getKeonKoko());
        keko.poll();
        keko.poll();
        assertEquals(0, keko.getKeonKoko());
        keko.poll();
        assertEquals(0, keko.getKeonKoko());
    }
}
