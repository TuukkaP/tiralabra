
package tiralabra;

/**
 *
 * Bellman-Fordin solmuluokka
 */
public class NodeBF extends Node {

    /**
     * Solmun konstruktori
     * @param x x-koordinaati
     * @param y y-koordinaatti
     * @param maaliSolmu Maalisolmu
     */
    public NodeBF(int x, int y, Node maaliSolmu) {
        super(x, y, maaliSolmu);
    }

    /**
     * Vertailua ei tehdä, siirretään vain uusi solmu keon pohjalle.
     * @param o Vertailtava solmu
     * @return Palauttaa aina 1.
     */
    @Override
    public int compareTo(Node o) {
        return 1;
    }
    
}
