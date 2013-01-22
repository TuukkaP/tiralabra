/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Melkonen työmaa
 * @author tuukka
 */
public class Tiralabra {

    private static Verkko verkko;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String kuva = "kartta2.png";
        verkko = new Verkko(kuva);
        verkko.toString();
        System.out.println("Solmu: [Y:" + verkko.getSolmu(138, 134).getY() + "][x:" + verkko.getSolmu(138, 134).getX() + "]");
        System.out.println(verkko.getAlku());
        System.out.println(verkko.getMaali());
        System.out.println(verkko.getSolmu(133, 138).heuristiikka(verkko.getMaali()));
        System.out.println(verkko.getAlku().heuristiikka(verkko.getMaali()));
        System.out.println(verkko.getMaali().heuristiikka(verkko.getMaali()));
        System.out.println("Alkusolmu etäisyys miinus melkein maali " + (verkko.getSolmu(133, 138).heuristiikka(verkko.getMaali()) - verkko.getAlku().heuristiikka(verkko.getMaali())));
        verkko.getSolmu(133, 138).setMaaliSolmu(verkko.getMaali());
        verkko.getSolmu(132, 138).setMaaliSolmu(verkko.getMaali());
        verkko.getSolmu(132, 138).setPaino(1);
        verkko.getSolmu(133, 138).setPaino(10);
        verkko.getAlku().setMaaliSolmu(verkko.getMaali());
        verkko.getMaali().setMaaliSolmu(verkko.getMaali());
        System.out.println(verkko.getMaali().getPaino());
        System.out.println(verkko.getAlku().compareTo(verkko.getSolmu(133, 138)));
        System.out.println(verkko.getSolmu(133, 138).compareTo(verkko.getAlku()));
        System.out.println(verkko.getSolmu(132, 138).compareTo(verkko.getSolmu(133, 138)));
        System.out.println(verkko.getSolmu(133, 138).compareTo(verkko.getSolmu(132, 138)));
        if (verkko.getSolmu(133, 138).compareTo(verkko.getSolmu(132, 138)) <= 0) {
            System.out.println("Solmut ovat yhtä kaukana tai solmu " + verkko.getSolmu(133, 138) + " on lähempänä maalia");
        } else {
            System.out.println("Solmu " + verkko.getSolmu(132, 138) + " on lähempänä maalia");
        }
        System.out.println("Maalisolmu: [Y:" + verkko.getMaali().getY() + "][x:" + verkko.getMaali().getX() + "]");
        verkko.getSolmu(133, 138).setEdellinen(verkko.getSolmu(132, 138));
        System.out.println(verkko.getSolmu(133, 138).getEdellinen());
        PriorityQueue<Node> keko = new PriorityQueue<>();
        keko.add(verkko.getSolmu(133, 138));
        keko.add(verkko.getSolmu(132, 138));
        keko.add(verkko.getAlku());
        keko.add(verkko.getMaali());
        System.out.println(keko);
        astar();
//        System.out.println(verkko.getAlku());
//        System.out.println(verkko.getMaali());
        verkko.piirraTulos();
//        Node maali = new Node (10,10,10);
//        maali.setMaaliSolmu(maali);
//        Node yks = new Node(1, 1, 1);
//        yks.setPaino(1);
//        yks.setMaaliSolmu(maali);
//        Node kaks = new Node(2, 2, 2);
//        kaks.setPaino(2);
//        kaks.setMaaliSolmu(maali);
//        Node kolme = new Node(3, 3, 3);
//        kolme.setPaino(3);
//        kolme.setMaaliSolmu(maali);
//        MinKeko keko = new MinKeko();
//        Node nelja = new Node(4,4, 4);
//        nelja.setPaino(4);
//        nelja.setMaaliSolmu(maali);
//        Node viisi = new Node(5, 5, 5);
//        viisi.setPaino(5);
//        viisi.setMaaliSolmu(maali);
//        keko.lisaa(yks);
//        keko.lisaa(kolme);    
//        keko.lisaa(viisi);    
//        keko.lisaa(kaks);
//        keko.lisaa(nelja);
//        keko.lisaa(maali);
//        System.out.println(keko);
//        System.out.println(keko.pop());
//        System.out.println("");
//        System.out.println(keko);

    }

    /**
     * Djikstran algoritmi
     */
    private static void djikstra() {
//        Dijkstra(G,w,s)
//1 Initialise-Single-Source(G,s)
//2 S = ; 3 while ( kaikki solmut eivät vielä ole joukossa S )
//4 valitse solmu u 2 V \ S, jonka etäisyysarvio lähtösolmuun s on lyhin
//5 S = S [ {u}
//6 for jokaiselle solmulle v 2 vierus[u] // kaikille u:n vierussolmuille v
//7 Relax(u,v,w)
    }

    /**
     * A* -algoritmi
     */
    private static void astar() {
//        LÄHDEMATERIAALIA ASTARIIIN
//        Solmulista = [Alkusolmu]
//Käsitellyt = [ ]
//while Solmulista not empty
//Solmu = EKA(Solmulista)
//Solmulista = LOPUT(Solmulista)
//if Solmu not in Käsitellyt
//Käsitellyt = Käsitellyt + [Solmu]
//if MAALI(Solmu) return(“ratkaisu”, Solmu)
//Solmulista = LISÄÄ(NAAPURIT(Solmu),Solmulista)
//end if
//end while
//return(“ei ratkaisua”)
//PARAS-ENSIN -HAKU:
//A*
//A*-HAKU: f(N) = g(N) + h(N)
//LISÄÄ(Solmulista1, Solmulista2)
//return(JÄRJESTÄ(Solmulista1, Solmulista2))
//# [(a,5),(b,3),(c,1)], [(a,2),(c,3),(f,5)] => [(c,1),(a,2),(b,3),(f,5)]

        PriorityQueue<Node> keko = new PriorityQueue<>();
//        MinKeko keko = new MinKeko(verkko);
        keko.add(verkko.getAlku());
        Node prev = null;
        Node solmu = null;
        int matka = 0;
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
                solmu.setEdellinen(prev);
                solmu.setPaino(matka); 
                System.out.println("Solmuun " + solmu + " tultiin solmusta " + solmu.getEdellinen());
                if (solmu.isMaali()) {
                    System.out.println(solmu.getEdellinen());
                    System.out.println("Maalisolmu " + solmu);
                    int vari = -1237980;
                    piirraTieMaaliin(vari);
                    System.out.println("MAALI, matkaa tuli " + matka);
                    return;
                }
                solmu.setKayty(true);
                prev = solmu;
                getNaapurit(keko, solmu);
                if (solmu.getEdellinen() != null) {
                    matka = solmu.getEdellinen().getPaino();
                    matka++;
                }
            }
        }
        System.out.println("Ei ratkaisua");

    }

    /**
     * Solmun naapureiden getteri.
     * @param keko Keko mihin naapurit lisätään
     * @param solmu Solmu, jonka naapurit haetaan.
     */
    public static void getNaapurit(PriorityQueue<Node> keko, Node solmu) {

//        verkko.getSolmu(solmu.getY() - 1, solmu.getX() - 1).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY() - 1, solmu.getX()).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY() - 1, solmu.getX() + 1).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY(), solmu.getX() - 1).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY(), solmu.getX() + 1).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY() + 1, solmu.getX() - 1).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY() + 1, solmu.getX()).setMaaliSolmu(verkko.getMaali());
//        verkko.getSolmu(solmu.getY() + 1, solmu.getX() + 1).setMaaliSolmu(verkko.getMaali());
//
//
//        keko.lisaa(verkko.getSolmu(solmu.getY() - 1, solmu.getX() - 1));
//        keko.lisaa(verkko.getSolmu(solmu.getY() - 1, solmu.getX()));
//        keko.lisaa(verkko.getSolmu(solmu.getY() - 1, solmu.getX() + 1));
//        keko.lisaa(verkko.getSolmu(solmu.getY(), solmu.getX() - 1));
//        keko.lisaa(verkko.getSolmu(solmu.getY(), solmu.getX() + 1));
//        keko.lisaa(verkko.getSolmu(solmu.getY() + 1, solmu.getX() - 1));
//        keko.lisaa(verkko.getSolmu(solmu.getY() + 1, solmu.getX()));
//        keko.lisaa(verkko.getSolmu(solmu.getY() + 1, solmu.getX() + 1));

        int x = solmu.getX() - 1;
        int y = solmu.getY() - 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x + j < verkko.getLeveys()-1 && y + i < verkko.getKorkeus()-1) {
                    if (verkko.getSolmu(y + i, x + j).getVari() != -16777216) {
                        verkko.getSolmu(y + i, x + j).setMaaliSolmu(verkko.getMaali());
                        keko.add(verkko.getSolmu(y + i, x + j));
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
    public static void piirraTieMaaliin(int vari) {
        Node prev = verkko.getMaali().getEdellinen();
        int matka = 0;
        while (prev.getEdellinen() != null) {
            prev.setVari(vari);
            prev = prev.getEdellinen();
            matka++;
        }
        System.out.println(matka);
    }
}
