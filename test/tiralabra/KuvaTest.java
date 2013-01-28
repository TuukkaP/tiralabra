/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class KuvaTest {

    private static Kuva kuva;
    private static int[][] pikselit;

    public KuvaTest() {
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
        pikselit = kuva.getPikselit();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPikselit method, of class Kuva.
     */
    @Test
    public void testGetPikselit() {
        int[][] pikselit2 = lueKuva("testiKuva.png");
        assertArrayEquals(pikselit2, pikselit);
    }

    /**
     * Test of tulostaTulokset method, of class Kuva.
     */
    @Test
    public void testTulostaTulokset() {
        pikselit[14][14] = -1;
        kuva.tulostaTulokset(pikselit, "testiTulos.png");
        int[][] pikselit2 = lueKuva("testiTulos.png");
        assertArrayEquals(pikselit2, pikselit);
    }

    /**
     * Test of getLahtoX method, of class Kuva.
     */
    @Test
    public void testGetLahtoX() {
        assertEquals(5, kuva.getLahtoX());
    }

    /**
     * Test of getLahtoY method, of class Kuva.
     */
    @Test
    public void testGetLahtoY() {
        assertEquals(4, kuva.getLahtoY());
    }

    /**
     * Test of getMaaliX method, of class Kuva.
     */
    @Test
    public void testGetMaaliX() {
        assertEquals(24, kuva.getMaaliX());
    }

    /**
     * Test of getMaaliY method, of class Kuva.
     */
    @Test
    public void testGetMaaliY() {
        assertEquals(25, kuva.getMaaliY());
    }

    private int[][] lueKuva(String tiedosto) {
        BufferedImage kuva1 = null;
        try {
            kuva1 = ImageIO.read(new File(tiedosto));
        } catch (IOException ex) {
            System.exit(0);
        }
        int korkeus = kuva1.getHeight();
        int leveys = kuva1.getWidth();
        int[][] pikselit2 = new int[korkeus][leveys];
        for (int j = 0; j < korkeus; j++) {
            for (int i = 0; i < leveys; i++) {
                int pikseli = kuva1.getRGB(i, j);
                pikselit2[j][i] = pikseli;
            }
        }
        return pikselit2;
    }
}
