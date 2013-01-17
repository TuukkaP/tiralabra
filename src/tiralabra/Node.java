/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * @author tuukka
 */
public class Node {
    
    /**
     * Solmun perustus
     */
    private boolean kayty;
    private boolean nahty;
    private Node edellinen;
    
    public Node() {
        kayty = false;
        nahty = false;
    }
    
    /**
     * Solmujen vertailu
     * @param alku
     * @param maali
     * @return Jos negatiivinen alku on parempi, jos positiivinen maali on parempi.
     */
    public int compareTo (Node alku, Node maali) {
    
        return 0;
    }
}
