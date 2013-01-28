/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * Solmuluokka.
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
    public Node maaliSolmu;
    private int matka;

    /**
     * Solmun konstruktori
     *
     * @param x Solmun x-koordinaatit
     * @param y Solmun y-koordinaatit
     * @param vari Solmunvari
     */
    public Node(int x, int y, Node maaliSolmu) {
        kayty = false;
        nahty = false;
        edellinen = null;
        this.x = x;
        this.y = y;
        paino = 1;
        matka = Integer.MAX_VALUE;
        this.maaliSolmu = maaliSolmu;
    }

    /**
     * Solmun määrittäminen maalisolmuksi.
     *
     * @param maali
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
     * Solmun määrittäminen lähtösolmuksi.
     *
     * @param lahto
     */
    public void setLahto(boolean lahto) {
        this.lahto = lahto;
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
     * @return
     */
    public int getPaino() {
        return paino;
    }

    /**
     * Solmun x-koordinaatin getteri.
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Solmun y-koordinaatin getteri.
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Onko solmussa jo käyty.
     *
     * @return
     */
    public boolean isKayty() {
        return kayty;
    }

    /**
     * Onko solmu jo nähty (EI OO TARVITTU MISSÄÄ)
     *
     * @return
     */
    public boolean isNahty() {
        return nahty;
    }

    /**
     * Edellisen solmun määrittäminen.
     *
     * @param edellinen
     */
    public void setEdellinen(Node edellinen) {
        this.edellinen = edellinen;
    }

    /**
     * Asettaa solmun käydyksi.
     *
     * @param kayty
     */
    public void setKayty(boolean kayty) {
        this.kayty = kayty;
    }

    /**
     * Solmun painon muuttaminen.
     *
     * @param paino
     */
    public void setPaino(int paino) {
        this.paino = paino;
    }

    /**
     * Solmun x-koordinaatin muuttaminen
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Solmun y-koordinaatin muuttaminen.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Solmun toStringi.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Solmu X:[" + x + "] Y:[" + y + "] etäisyys maalisolmuun " + (int) ((heuristiikka(maaliSolmu) + getMatka()));
    }

    /**
     * Solmun vertailu.
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return (int) ((heuristiikka(maaliSolmu) + getMatka()) - (o.heuristiikka(maaliSolmu) + o.getMatka()));
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
     * @return
     */
    public boolean isMaali() {
        return maali;
    }

    public int getMatka() {
        return matka;
    }

    public void setMatka(int matka) {
        this.matka = matka;
    }
}
