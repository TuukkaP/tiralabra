/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * Kuvan lukeminen verkoksi.
 */
public class Verkko {

    final static int MUSTA = -16777216;
    final static int VALKEA = -1;
    final static int LAHTO = -3584; // -69120
    final static int MAALI = -1237980; // -1238236
    public int verkko[][];
    public Node solmut[][];
    public int korkeus;
    public int leveys;
    public int lahtoX;
    public int lahtoY;
    public int maaliX;
    public int maaliY;

    /**
     * Verkon muodostaminen annetusta tiedostosta.
     *
     * @param tiedosto Kuvatiedosto.
     */
    public Verkko(String tiedosto) {
        BufferedImage kuva = null;
        try {

            kuva = ImageIO.read(new File(tiedosto));

        } catch (IOException ex) {

            System.exit(0);

        }
        korkeus = kuva.getHeight();
        leveys = kuva.getWidth();
        solmut = new Node[korkeus][leveys];
        ArrayList<Integer> varit = new ArrayList<>();
        for (int j = 0; j < korkeus; j++) {
            for (int i = 0; i < leveys; i++) {
                int pikseli = kuva.getRGB(i, j);
                solmut[j][i] = new Node(i, j, pikseli);
                if (!varit.contains(pikseli)) {
                    varit.add(pikseli);
                }
                if (i == 8 && j == 8) {
                    System.out.println(pikseli);
                }
                if (i == 141 && j == 130) {
                    System.out.println(pikseli);
                }
                if (pikseli == VALKEA) {
                    solmut[j][i].setPaino(1);
                } else if (pikseli == MUSTA) {
                    solmut[j][i].setPaino(Integer.MAX_VALUE);
                } else if (pikseli == LAHTO) {
                    lahtoX = i;
                    lahtoY = j;
                    solmut[j][i].setLahto(true);
                    System.out.println("LÄHTÖ LÖYTYI");
                } else if (pikseli == MAALI) {
                    maaliX = i;
                    maaliY = j;
                    solmut[j][i].setMaali(true);
                    System.out.println("MAALI LÖytyis");
                    solmut[j][i].setPaino(0);
                } else {
//                    System.out.println("Väriä ei tunnistettu");
                }
            }

        }
        System.out.println(varit);
    }

    /**
     * Verkon toStringi
     *
     * @return
     */
    @Override
    public String toString() {
        File tiedosto2 = new File("tulos.txt");
        PrintWriter tiedot = null;
        try {
            tiedot = new PrintWriter(tiedosto2);
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedoston luonti epäonnistui loistavasti!");;
        }

        for (int j = 0; j < korkeus; j++) {
            for (int i = 0; i < leveys; i++) {
                tiedot.print(solmut[j][i].getPaino());
            }
            tiedot.println("");
        }
        tiedot.close();
        System.out.println("Verkko:" + korkeus + " x " + leveys);
        return " ";
    }

    /**
     * Verkon korkeuden getteri
     *
     * @return
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     * Verkon leveyden getteri.
     *
     * @return
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Solmun palauttaminen annetuista koordinaateista
     *
     * @param y Y-koordinaatti
     * @param x X-koordinaatti
     * @return Palauttaa koordinaattien mukaisen solmun.
     */
    public Node getSolmu(int y, int x) {
        return solmut[y][x];
    }

    /**
     * Palauttaa aloitussolmun
     *
     * @return
     */
    public Node getAlku() {
        return solmut[lahtoY][lahtoX];
    }

    /**
     * Palauittaa verkon maalisolmun
     *
     * @return
     */
    public Node getMaali() {
        return solmut[maaliY][maaliX];
    }

    /**
     * Piirtää nykyisen verkon.
     */
    public void piirraTulos() {
        Kuva kuva = new Kuva(this);
    }
}
