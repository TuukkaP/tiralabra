package tiralabra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * Tuloskuvan piirtämisestä vastaava luokka
 */
public class Kuva {

    final static int MUSTA = -16777216;
    final static int VALKEA = -1;
    final static int LAHTO = -3584; // -69120
    final static int MAALI = -1237980; // -1238236
    public int korkeus;
    public int leveys;
    public int lahtoX;
    public int lahtoY;
    public int maaliX;
    public int maaliY;
    private int[][] pikselit;

    /**
     * Kuvan piirtäminen annetusta verkosta.
     *
     * @param verkko
     */
    public Kuva(String tiedosto) {        
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(new File(tiedosto));
        } catch (IOException ex) {
            System.exit(0);
        }
        korkeus = kuva.getHeight();
        leveys = kuva.getWidth();
        pikselit = new int[korkeus][leveys];
        for (int j = 0; j < korkeus; j++) {
            for (int i = 0; i < leveys; i++) {
                int pikseli = kuva.getRGB(i, j);
                pikselit[j][i] = pikseli;
                if (pikseli == VALKEA) {
                } else if (pikseli == MUSTA) {
                } else if (pikseli == LAHTO) {
                    lahtoX = i;
                    lahtoY = j;
                } else if (pikseli == MAALI) {
                    maaliX = i;
                    maaliY = j;
                } else {
                    System.out.println("Väriä ei tunnistettu");
                }
            }
        }
    }

    public int[][] getPikselit() {
        return pikselit;
    }

    public void tulostaTulokset(int[][] pikselitB, String tiedosto) {
        BufferedImage tulos = new BufferedImage(pikselitB[0].length, pikselitB.length, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < pikselitB.length; i++) {
            for (int j = 0; j < pikselitB[i].length; j++) {
                tulos.setRGB(j, i, pikselitB[i][j]);
            }
        }
        try {
            ImageIO.write(tulos, "png", new File(tiedosto));
        } catch (IOException ex) {
            Logger.getLogger(Kuva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLahtoX() {
        return lahtoX;
    }

    public int getLahtoY() {
        return lahtoY;
    }

    public int getMaaliX() {
        return maaliX;
    }

    public int getMaaliY() {
        return maaliY;
    }
    
}
