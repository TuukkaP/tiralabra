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
public class MinKeko<T extends Node> {

    private static int aloitusKoko = 8;
    private T[] keko;
    private int keonKoko;

    /**
     * Keon konstruktori
     *
     * @param verkko
     */
    public MinKeko(T[] t) {
        keko = t;
        keonKoko = 0;
    }

    /**
     * Keon sisältävän taulukon kasvattaminen
     */
//    private void kasvata(T[] taulu) {
//        T[] tmp;
//        tmp = new T[taulukko.length*taulukko.length];
//        System.arraycopy(taulukko, 0, tmp, 0, taulukko.length);
//        taulukko = tmp;
//    }
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
     * Onko keko tyhjä.
     *
     * @return True jos tyhjä, False jos ei
     */
    public boolean isEmpty() {
        if (keonKoko == 0) {
            return true;
        }
        return false;
    }

    private void swap(int a, int b) {
        T temp = keko[a];
        keko[a] = keko[b];
        keko[b] = temp;
    }

    /**
     * HeapUp
     *
     * @param paikka
     */
//    private void keossaYlos(int paikka) {
//
//        while (paikka > 1 && keko[paikka].compareTo(keko[vanhempi(paikka)]) < 0) {
//            swap(paikka, vanhempi(paikka));
//            paikka = vanhempi(paikka);
//        }
//
//    }
    /**
     * HeapDown
     *
     * @param paikka
     */
    private void keossaAlas(int paikka) {
        int pienempi = paikka;
        if (keonKoko == 0) {
            return;
        }
        while (true) {
            int vasen = vasen(paikka);
            int oikea = oikea(paikka);
            if (vasen >= keonKoko && oikea >= keonKoko) {
                return;
            }
            if (keko[vasen] != null && keko[oikea] != null) {
                if (keko[vasen].compareTo(keko[oikea]) <= 0) {
                    pienempi = vasen;
                } else {
                    pienempi = oikea;
                }
            } else if (keko[vasen] != null && keko[oikea] == null) {
                pienempi = vasen;
            } else if (keko[vasen] == null && keko[oikea] != null) {
                pienempi = oikea;
            }
            swap(paikka, pienempi);
            paikka = pienempi;
        }

    }

    /**
     * Solmun lisääminen kekoon
     *
     * @param solmu
     */
    public void add(T solmu) {
        keonKoko++;
        keko[keonKoko] = solmu;
        int i = keonKoko;
        while (i > 1 && keko[vanhempi(i)].compareTo(keko[i]) >= 0) {
            swap(vanhempi(i), i);
            i = vanhempi(i);
        }
//        if (keonKoko == 20) {
//            for (int x = 1; x <= keonKoko; x++) {
//                System.out.println(x +" : " +keko[x].toString() + ", ");
//            }
//            System.exit(0);
//        }
    }

    /**
     * Pienimmän solmun palautttaminen
     *
     * @return
     */
    public T poll() {
        T pop = keko[1];
        keko[1] = keko[keonKoko];
        keko[keonKoko] = null;
        keonKoko--;
        keossaAlas(1);
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
            System.out.println(keko[i].toString() + ", ");
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
