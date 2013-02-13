package tiralabra;

/**
 *
 * A* -solmuluokka.
 */
public class Node implements Comparable<Node> {

    private boolean kayty;
    private boolean nahty;
    private Node edellinen;
    private int paino;
    private int x;
    private int y;
    private boolean lahto;
    private boolean maali;
    private Node maaliSolmu;
    private int matka;

    /**
     * Solmun konstruktori
     *
     * @param x Solmun x-koordinaatit
     * @param y Solmun y-koordinaatit
     * @param maaliSolmu Maalisolmu Astarin heuristiikkaa varten
     */
    public Node(int x, int y, Node maaliSolmu) {
        kayty = false;
        nahty = false;
        edellinen = null;
        this.x = x;
        this.y = y;
        paino = 2;
        matka = Integer.MAX_VALUE;
        this.maaliSolmu = maaliSolmu;
    }

    /**
     * Solmun määrittäminen maalisolmuksi.
     *
     * @param maali Jos true, solmu on maalisolmu ja vice versa.
     */
    public void setMaali(boolean maali) {
        this.maali = maali;
    }

    /**
     * Maalisolmun ilmoittaminen solmulle heuristiikkaa varten.
     *
     * @param maali Maalisolmu
     */
    public void setMaaliSolmu(Node maali) {
        maaliSolmu = maali;
    }

    /**
     * Edellisen solmun ilmoittaminen
     *
     * @return Palauttaa edellisen solmun
     */
    public Node getEdellinen() {
        return edellinen;
    }

    /**
     * Solmun painon palauttaminen
     *
     * @return Solmunpaino
     */
    public int getPaino() {
        return paino;
    }

    /**
     * Solmun x-koordinaatin getteri.
     *
     * @return x-koordinaatti
     */
    public int getX() {
        return x;
    }

    /**
     * Solmun y-koordinaatin getteri.
     *
     * @return y-koordinaatti
     */
    public int getY() {
        return y;
    }

    /**
     * Onko solmussa jo käyty.
     *
     * @return Jos true, solmussa on käyty, ja vice versa
     */
    public boolean isKayty() {
        return kayty;
    }

    /**
     * Edellisen solmun määrittäminen.
     *
     * @param edellinen Edellinen solmu
     */
    public void setEdellinen(Node edellinen) {
        this.edellinen = edellinen;
    }

    /**
     * Asettaa solmun käydyksi.
     *
     * @param kayty Jos true, solmussa on käyty.
     */
    public void setKayty(boolean kayty) {
        this.kayty = kayty;
    }

    /**
     * Solmun painon muuttaminen.
     *
     * @param paino Solmun uusi paino
     */
    public void setPaino(int paino) {
        this.paino = paino;
    }

    /**
     * Solmun x-koordinaatin muuttaminen
     *
     * @param x Uusi x-koordinaatti
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Solmun y-koordinaatin muuttaminen.
     *
     * @param y Uusi y-koordinaatti
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Solmun toStringi.
     *
     * @return Kirjoitusasu
     */
    @Override
    public String toString() {
        return "Solmu X:[" + x + "] Y:[" + y + "]";
    }

    /**
     * Solmun vertailu.
     *
     * @param o Solmu, johon verrataan.
     * @return Jos suurempi kuin 0 solmu on suurempi, jos pienempi kuin 0 solmu
     * on pienempi ja jos 0 solmut ovat samanarvoiset
     */
    @Override
    public int compareTo(Node o) {
        return (int) ((heuristiikka(maaliSolmu)+this.matka) - (o.heuristiikka(maaliSolmu)+o.getMatka()));
    }

    /**
     * Solmun vertailussa käytettävä heuristiikka.
     *
     * @param solmu Verrattava solmu
     * @return Palauttaa solmun etäisyyden verrattavaan solmuun
     */
    public double heuristiikka(Node solmu) {
        int deltaX = getX() - solmu.getX();
        int deltaY = getY() - solmu.getY();
        return Math.hypot(deltaX, deltaY);
    }

    /**
     * Onko Solmu maalisolmu.
     *
     * @return Jos true, solmu on maalisolmu.
     */
    public boolean isMaali() {
        return maali;
    }

    /**
     * Palauttaa solmuun kuljetun matkan.
     *
     * @return Solmuun kuljettu matka.
     */
    public int getMatka() {
        return matka;
    }

    /**
     * Muuta solmuun kuljettua matkaa
     *
     * @param matka Uusi kuljettu matka
     */
    public void setMatka(int matka) {
        this.matka = matka;
    }

    /**
     * Palauttaa maalisolmun.
     *
     * @return Maalisolmu
     */
    public Node getMaaliSolmu() {
        return maaliSolmu;
    }
}
