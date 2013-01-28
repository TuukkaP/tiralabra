/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.util.PriorityQueue;

/**
 * Melkonen työmaa
 *
 * @author tuukka
 */
public class Tiralabra {

    private static Kuva kuva;
    private static int laskuri = 0;
    private static int[][] pikselit;
    private static Node[] taulu;
    private static Node[][] kaydyt;
    private static MinKeko keko;
    private static Node maali;
    private static Node lahto;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String kuvanNimi = "kartta2.png";
        kuva = new Kuva(kuvanNimi);
        djikstra();
        kuva = new Kuva(kuvanNimi);
        astar();
    }

    /**
     * Djikstran algoritmi
     */
    private static void djikstra() {
        alusta();
        Node solmu = null;
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
//                System.out.println("Solmuun " + solmu + " tultiin solmusta " + solmu.getEdellinen());
            if (solmu.isMaali()) {
                piirraTieMaaliin(solmu, -1237980, pikselit);
                System.out.println("Djikstra MAALI, matkaa tuli " + solmu.getMatka() + " tutkittuja solmuja " + laskuri);
                kuva.tulostaTulokset(pikselit, "TulosDjikstra.png");
                laskuri = 0;
                return;
            }
            solmu.setKayty(true);
            getNaapurit(keko, solmu, 0, pikselit, maali, kaydyt);
            }
        }
        System.out.println("Ei ratkaisua");
        kuva.tulostaTulokset(pikselit, "TulosDjikstra.png");
    }

    /**
     * A* -algoritmi
     */
    private static void astar() {
        alusta();
        Node solmu = null;
        while (!keko.isEmpty()) {
            solmu = keko.poll();
//            if (!solmu.isKayty()) {
                
//                System.out.println("Solmuun " + solmu + " tultiin solmusta " + solmu.getEdellinen());
                if (solmu.isMaali()) {
                    piirraTieMaaliin(solmu, -1237980, pikselit);
                    System.out.println("Astar, matkaa tuli " + solmu.getMatka() + " tutkittuja solmuja " + laskuri);
                    kuva.tulostaTulokset(pikselit, "TulosAstar.png");
                    laskuri = 0;
                    return;
                }
                solmu.setKayty(true);
                getNaapurit(keko, solmu, 1, pikselit, maali, kaydyt);
//            }
        }
        System.out.println("Ei ratkaisua");
        kuva.tulostaTulokset(pikselit, "TulosAstar.png");
    }

    public static void bellmanFord() {
        
    }

    /**
     * Solmun naapureiden getteri.
     *
     * @param keko Keko mihin naapurit lisätään
     * @param solmu Solmu, jonka naapurit haetaan.
     */
    public static <T extends Node> void getNaapurit(MinKeko keko, T solmu, int tyyppi, int[][] pikselit, T maali, Node[][] kaydyt) {
        int x = solmu.getX() - 1;
        int y = solmu.getY() - 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pikselit[y + i][x + j] != -16777216) {
                    Node naapuri;
                    if (tyyppi == 1 && kaydyt[y + i][x + j] == null) {
                        naapuri = new Node(x + j, y + i, maali);
                        kaydyt[y + i][x + j] = naapuri;
                        laskuri++;
                    } else if (tyyppi == 0 && kaydyt[y + i][x + j] == null) {
                        naapuri = new NodeD(x + j, y + i, maali);
                        kaydyt[y + i][x + j] = naapuri;
                        laskuri++;
                    } else {
                        naapuri = kaydyt[y + i][x + j];
                    }
                    pikselit[y + i][x + j] = -3584;
                    if ((solmu.getMatka() + naapuri.getPaino()) < naapuri.getMatka()) {
                        naapuri.setMatka(solmu.getMatka() + naapuri.getPaino());
                        naapuri.setEdellinen(solmu);
                        keko.add(naapuri);
                    }
                }
            }
        }
    }

    /**
     * Määrittää reitin värin ja muokkaa ne verkosta.
     *
     * @param vari Reitin väri
     */
    public static void piirraTieMaaliin(Node prev, int vari, int[][] pikselit) {
        int matka = 0;
        while (prev.getEdellinen() != null) {
            pikselit[prev.getY()][prev.getX()] = vari;
            prev = prev.getEdellinen();
            matka++;
        }
        System.out.println(matka);
    }

    private static void alusta() {
        pikselit = kuva.getPikselit();
        taulu = new Node[pikselit.length * pikselit[0].length];
        kaydyt = new Node[pikselit.length][pikselit[0].length];
        keko = new MinKeko(taulu);
        maali = new Node(kuva.getMaaliX(), kuva.getMaaliY(), null);
        maali.setMaaliSolmu(maali);
        lahto = new Node(kuva.getLahtoX(), kuva.getLahtoY(), maali);
        kaydyt[kuva.getMaaliY()][kuva.getMaaliX()] = maali;
        kaydyt[kuva.getLahtoY()][kuva.getLahtoX()] = lahto;
        lahto.setMatka(0);
        maali.setMaali(true);
        keko.add(lahto);
    }
}