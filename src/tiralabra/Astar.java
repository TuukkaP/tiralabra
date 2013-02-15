/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * A*-algoritmin luokka
 */
public class Astar extends Verkko {

    public Kuva kuva;

    public Astar(String kuvaTiedosto) {
        kuva = new Kuva(kuvaTiedosto);
        pikselit = kuva.getPikselit();
        kaydyt = new Node[pikselit.length][pikselit[0].length];
        keko = new MinKeko(new Node[pikselit.length * pikselit[0].length]);
        maali = new Node(kuva.getMaaliX(), kuva.getMaaliY(), null);
        lahto = new Node(kuva.getLahtoX(), kuva.getLahtoY(), maali);
        maali.setMaaliSolmu(maali);
        kaydyt[kuva.getLahtoY()][kuva.getLahtoX()] = lahto;
        kaydyt[kuva.getMaaliY()][kuva.getMaaliX()] = maali;
        maali.setMaali(true);
    }

    /**
     * Kun maalisolmu löydetään tulostetaan reitin pituus ja piirretään reittikuva.
     * @param solmu Maalisolmu
     * @return Palauta true, kun tehty.
     */
    @Override
    public boolean maalisolmuLoydetty(Node solmu) {
        int matka = piirraTieMaaliin(solmu, -1237980);
        System.out.println("Astar, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + maali.getMatka());
        kuva.tulostaTulokset(pikselit, "TulosAstar.png");
        return true;
    }
    
        /**
     * Ketkä ovat solmun naapureita. Tutkitaan onko naapurit jo luotu (eli ovat
     * kaydyt matriisissa) ja jos ei niin luodaan uusi solmu.
     * Astarissa luodaan Node-solmuja. Siksi override.
     *
     * @param y Suhteellinen Y-koordinaatti
     * @param i For-loopin y-osa
     * @param x Suhteellinen X-koordinaaatti
     * @param j For-loopin x-osa
     */
    @Override
    public <T extends Node> Node maaritaNaapuri(int y, int i, int x, int j) {
        if (kaydyt[y + i][x + j] == null) {
            naapuri = new Node(x + j, y + i, maali);
            kaydyt[y + i][x + j] = naapuri;
        } else {
            naapuri = kaydyt[y + i][x + j];
        }
        return naapuri;
    }
}
