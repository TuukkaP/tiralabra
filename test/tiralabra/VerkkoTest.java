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

    private Djikstra djikstra;
    private MinKeko keko;
    private Kuva kuva;

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
        kuva = new Kuva("testiKuva.png");
        djikstra = new Djikstra("testiKuva.png");
        keko = new MinKeko(new Node[10]);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNaapurit method, of class Verkko.
     */
    @Test
    public void testGetNaapurit() {
        NodeD alkusolmu = new NodeD(5, 4, null);
        djikstra.getNaapurit(alkusolmu);
        assertEquals(8, djikstra.keko.getKeonKoko());
    }

    /**
     * Test of maaritaNaapuri method, of class Verkko.
     */
    @Test
    public void testMaaritaNaapuri() {
        Node naapuri = djikstra.maaritaNaapuri(5, 1, 5, 2);
        assertEquals(6, naapuri.getY());
        assertEquals(7, naapuri.getX());
    }

    /**
     * Test of relaxNaapurit method, of class Verkko.
     */
    @Test
    public void testRelaxNaapurit() {
        NodeD alkusolmu = new NodeD(5, 4, null);
        djikstra.getNaapurit(alkusolmu);
        //Mikäli solmut on relaksoitu oikein ja kulmittaiset solmut maksavat enemmän, järjestys tiedetään
        for (int i = 0; i < 4; i++) {
            Node solmu = djikstra.keko.poll();
            assertTrue((solmu.getX() == 5 && solmu.getY() == 3) || (solmu.getX() != 5 && solmu.getY() == 4) || (solmu.getX() == 5 && solmu.getY() == 5));
        }
        for (int i = 0; i < 4; i++) {
            Node solmu = djikstra.keko.poll();
            assertTrue((solmu.getX() != 5 && solmu.getY() == 3) || (solmu.getX() != 5 && solmu.getY() == 5));
        }
    }

    /**
     * Test of solmunLapikaynti method, of class Verkko.
     */
    @Test
    public void testSolmunLapikaynti() {
        NodeD alkusolmu = new NodeD(5, 4, null);
        assertFalse(djikstra.solmunLapikaynti(alkusolmu));
        alkusolmu.setMaali(true);
        assertTrue(djikstra.solmunLapikaynti(alkusolmu));
    }

    /**
     * Test of solmunLapikaynti method, of class Verkko.
     */
    @Test
    public void testkulkusuunnanKustannus() {
        NodeD alkusolmu = new NodeD(5, 4, null);
        djikstra.getNaapurit(alkusolmu);
        for (int i = 0; i < 4; i++) {
            Node solmu = djikstra.keko.poll();
            if ((solmu.getX() == 5 && solmu.getY() == 3) || (solmu.getX() != 5 && solmu.getY() == 4) || (solmu.getX() == 5 && solmu.getY() == 5)) {
                assertEquals(djikstra.sivuttain, solmu.getPaino());
            }
        }
        for (int i = 0; i < 4; i++) {
            Node solmu = djikstra.keko.poll();
            if ((solmu.getX() != 5 && solmu.getY() == 3) || (solmu.getX() != 5 && solmu.getY() == 5)) {
                assertEquals(djikstra.kulmittain, solmu.getPaino());
            }
        }

    }
}
