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

    public int korkeus;
    public int leveys;

    /**
     * Kuvan piirtäminen annetusta verkosta.
     *
     * @param verkko
     */
    public Kuva(Verkko verkko) {
        BufferedImage tulos = new BufferedImage(verkko.getLeveys(), verkko.getKorkeus(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < verkko.getKorkeus(); i++) {
            for (int j = 0; j < verkko.getLeveys(); j++) {
                tulos.setRGB(j, i, verkko.getSolmu(i, j).getVari());
            }
        }
        try {
            ImageIO.write(tulos, "png", new File("tulos.png"));
        } catch (IOException ex) {
            Logger.getLogger(Kuva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
