/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * Minimikeko-luokka.
 * 
 */
public class MinKeko<T extends Node> {

    private static int aloitusKoko = 8;
    public T[] keko;
    private int keonKoko;

    /**
     * Keon konstruktori
     *
     * @param t Taulukko, josta tehdään keko.
     */
    public MinKeko(T[] t) {
        keko = t;
        keonKoko = 0;
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

    /**
     * Vaihda solmujen A ja B paikkaa keossa.
     * @param a Solmu A
     * @param b Solmu B
     */
    private void swap(int a, int b) {
        T temp = keko[a];
        keko[a] = keko[b];
        keko[b] = temp;
    }

    /**
     * Kun keosta poistetaan solmu, haetaan sen paikalle oikea solmu.
     * Laskemalla solmua keossa alaspäin eli vaihtamalla pienemmän lapsen kanssa.
     * 
     * @param paikka
     */
    private void keossaAlas(int paikka) {
        int pienempi = paikka;
        while (true) {
            int vasen = vasen(paikka);
            int oikea = oikea(paikka);
            if (vasen >= keonKoko && oikea >= keonKoko) {
                return;
            }
            pienempi = maaritaPienempi(vasen, oikea, pienempi);
            swap(paikka, pienempi);
            paikka = pienempi;
        }
    }

    /**
     * Solmun lisääminen kekoon. Solmun paikka haetaan etsimällä solmua pienempi vanhempi.
     *
     * @param solmu
     */
    public void add(T solmu) {
        if (solmu == null) {
            return;
        }
        keonKoko++;
        keko[keonKoko] = solmu;
        int i = keonKoko;
        while (i > 1 && keko[vanhempi(i)].compareTo(keko[i]) >= 0) {
            swap(vanhempi(i), i);
            i = vanhempi(i);
        }
    }

    /**
     * Pienimmän solmun palautttaminen
     *
     * @return Keon pienin solmu eli minimikeon ensimmäinen solmu.
     */
    public T poll() {
        if  (keonKoko == 0) {
            return null;
        }
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
     * @return Keon kirjoitusasu
     */
    @Override
    public String toString() {
        String tuloste = "";
        for (int i = 1; i <= keonKoko; i++) {
            tuloste += (keko[i].toString() + ", \n");
        }
        tuloste += keonKoko;
        return tuloste;
    }

    /**
     * Palauttaa keon koon.
     *
     * @return Keonkoko
     */
    public int getKeonKoko() {
        return keonKoko;
    }

    /**
     * Maaritellaan kumpi lapsista on pienempi oikea vai vasen.
     * @param vasen Vasenlapsi
     * @param oikea Oikealapsi
     * @param pienempi Palautetaan pienempi
     * @return Palautetaan pienempi.
     */
    private int maaritaPienempi(int vasen, int oikea, int pienempi) {
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
        return pienempi;
    }
}
