/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * Tämä luokka ei ole vielä käytössä vaan se on vasta luonnosteluvaiheessa.
 * Seuraa ensi viikolla.
 */
public class MinKeko {

    private static int aloitusKoko = 8;
    private static Node[] taulukko;
    private int keonKoko;
    private Verkko verkko;

    /**
     * Keon konstruktori
     *
     * @param verkko
     */
    public MinKeko(Verkko verkko) {
        taulukko = new Node[aloitusKoko];
        keonKoko = 0;
        this.verkko = verkko;
    }

    /**
     * Keon sisältävän taulukon kasvattaminen
     */
    private static void kasvata() {
        Node[] tmp = new Node[taulukko.length * 2];
        System.arraycopy(taulukko, 0, tmp, 0, taulukko.length);
        taulukko = tmp;
    }

    /**
     * Solmun vasemman lapsen paikan määrittäminen
     *
     * @param parent Vanhempi
     * @return Vasemman lapsen paikan taulukossa.
     */
    private int vasen(int parent) {
        return 2 * parent;
    }

    /**
     * Solmun oikean lapsen paikan määrittäminen
     *
     * @param parent Vanhempi
     * @return Oikean lapsen palauttaminen
     */
    private int oikea(int parent) {
        return 2 * parent + 1;
    }

    /**
     * Solmun vanhemman paikan määrittäminen
     *
     * @param solmu Lapsisolmu
     * @return Palauttaa parentsolmun.
     */
    private int vanhempi(int solmu) {
        return (int) Math.floor(solmu / 2);
    }

    /**
     * HeapUp
     *
     * @param paikka
     */
    private void keossaYlos(int paikka) {
        if (paikka <= 1) {
            return;
        }
        while (paikka > 1 && taulukko[paikka].compareTo(taulukko[vanhempi(paikka)]) <= 0) {
            Node temp = taulukko[vanhempi(paikka)];
            taulukko[vanhempi(paikka)] = taulukko[paikka];
            taulukko[paikka] = temp;
            paikka = vanhempi(paikka);
        }
    }

    /**
     * HeapDown
     *
     * @param paikka
     */
    private void keossaAlas(int paikka) {
        int pienempi;
        while (oikea(paikka) < keonKoko) {
            int vasen = vasen(paikka);
            int oikea = oikea(paikka);
            if (taulukko[vasen] != null && taulukko[oikea] != null) {
                if (taulukko[vasen].compareTo(taulukko[oikea]) < 0) {
                    pienempi = vasen;
                } else {
                    pienempi = oikea;
                }
            } else if (taulukko[vasen] != null && taulukko[oikea] == null) {
                pienempi = vasen;
            } else if (taulukko[vasen] == null && taulukko[oikea] != null) {
                pienempi = oikea;
            } else {
                return;
            }
            Node temp = taulukko[paikka];
            taulukko[paikka] = taulukko[pienempi];
            taulukko[pienempi] = temp;
            paikka = pienempi;
        }
    }

    /**
     * Vaiko heapify?
     *
     * @param paikka
     */
    private void heapify(int paikka) {
        int pienin;
        int vasen = vasen(paikka);
        int oikea = oikea(paikka);

        if (vasen < keonKoko && taulukko[vasen].compareTo(taulukko[paikka]) <= 0) {
            pienin = vasen;
        } else {
            pienin = paikka;
        }

        if (oikea < keonKoko && taulukko[oikea].compareTo(taulukko[pienin]) <= 0) {
            pienin = oikea;
        }
        if (pienin != paikka) {
            Node temp = taulukko[paikka];
            taulukko[paikka] = taulukko[pienin];
            taulukko[pienin] = temp;
            heapify(pienin);
        }
    }

    /**
     * Solmun lisääminen kekoon
     *
     * @param solmu
     */
    public void lisaa(Node solmu) {
        if (solmu.getVari() == -16777216 || solmu.isKayty()) {
            return;
        }
        keonKoko++;
        if (keonKoko >= taulukko.length) {
            kasvata();
        }
        int i = keonKoko;
        solmu.setMaaliSolmu(verkko.getMaali());
        System.out.println(solmu);
        while (i > 1 && taulukko[vanhempi(i)].compareTo(solmu) >= 0) {
            taulukko[i] = taulukko[vanhempi(i)];
            i = vanhempi(i);
        }
        taulukko[i] = solmu;
    }

    /**
     * Pienimmän solmun palautttaminen
     *
     * @return
     */
    public Node pop() {
        if (taulukko[1] == null) {
            return null;
        }
        Node pop = taulukko[1];
        keonKoko--;
        taulukko[1] = taulukko[keonKoko];
        heapify(1);
        return pop;
    }

    /**
     * Keon toStringi
     *
     * @return
     */
    @Override
    public String toString() {
        for (int i = 1; i <= keonKoko; i++) {
            System.out.println(taulukko[i].toString() + ", ");
        }
        return "" + keonKoko;
    }

    /**
     * Palauttaa keon koon.
     *
     * @return
     */
    public int getKeonKoko() {
        return keonKoko;
    }
}
