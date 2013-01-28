/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * Solmuluokka.
 */
public class NodeD extends Node {

    public NodeD(int x, int y, Node maaliSolmu) {
        super(x, y, maaliSolmu);
    }

    @Override
    public int compareTo(Node o) {
        return getMatka() - o.getMatka();
    }
}
