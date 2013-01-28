
package tiralabra;

/**
 *
 * Djikstran solmuluokka.
 */
public class NodeD extends Node {

    /**
     * Solmun konstruktori
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     * @param maaliSolmu maalisolmu
     */
    public NodeD(int x, int y, Node maaliSolmu) {
        super(x, y, maaliSolmu);
    }

    /**
     * Djikstran pelkkään matkaan perustuva vertailu.
     *
     * @param o Verrattava solmu
     * @return Jos suurempi kuin 0 solmu on suurempi, jos pienempi kuin 0 solmu
     * on pienempi ja jos 0 solmut ovat samanarvoiset
     */
    @Override
    public int compareTo(Node o) {
        return getMatka() - o.getMatka();
    }
}
