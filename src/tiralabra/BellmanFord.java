/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * Bellman-Ford -algoritmin luokka.
 */
public class BellmanFord extends Verkko {

    public Kuva kuva;

    /**
     * Bellman-Ford algoritmin muuttujien alustus.
     *
     * @param kuvaTiedosto Kuvatiedoston nimi, josta reittiä lasketaan.
     */
    public BellmanFord(String kuvaTiedosto) {
        kuva = new Kuva(kuvaTiedosto);
        pikselit = kuva.getPikselit();
        kaydyt = new NodeD[pikselit.length][pikselit[0].length];
        keko = new MinKeko(new NodeD[pikselit.length * pikselit[0].length]);
        maali = new NodeD(kuva.getMaaliX(), kuva.getMaaliY(), null);
        lahto = new NodeD(kuva.getLahtoX(), kuva.getLahtoY(), maali);
        maali.setMaali(true);
        kaydyt[kuva.getLahtoY()][kuva.getLahtoX()] = lahto;
        kaydyt[kuva.getMaaliY()][kuva.getMaaliX()] = maali;
    }

    /**
     * Bellman-Fordissa ei lopeteta maalisolmun löytämiseen.
     *
     * @param solmu Maalisolmu
     * @return false
     */
    @Override
    boolean maalisolmuLoydetty(Node solmu) {
        return false;
    }

    /**
     * Bellman-Fordissa relaksoidaan solmut |solmujen määrä| - 1 kertaa
     */
    @Override
    public void suorita() {
        keko.add(lahto);
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
                solmunLapikaynti(solmu);
                solmu.setKayty(true);
            }
        }
        suoritusLoppui();
    }

    /**
     * Bellman-Fordin suorituksen lopetus.
     */
    @Override
    public void suoritusLoppui() {
        if (maali.getMatka() != Integer.MAX_VALUE) {
            int matka = piirraTieMaaliin(null, -1237980);
            System.out.println("BF, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + kaydyt[kuva.getMaaliY()][kuva.getMaaliX()].getMatka());
            kuva.tulostaTulokset(pikselit, "TulosBF.png");
        } else {
            System.out.println("Reittiä ei löytynyt.");
        }
    }

    /**
     * Naapureiden relaksointi eli päivitetään uusi matka jos lyhyempi kuin
     * vanha matka. BF lisäyksessä jokainen naapuri lisätään kekoon.
     *
     * @param y Alkuperäisen solmun läpikäyntiä varten määritetty y-koordinaatti
     * @param i For-loopin y-osa
     * @param x Alkuperäisen solmun läpikäyntiä varten määritetty x-koordinaatti
     * @param j For-loopin x-osa
     * @param solmu Käytävä solmu
     */
    @Override
    public <T extends Node> void relaxNaapurit(int y, int i, int x, int j, T solmu) {
        pikselit[y + i][x + j] = -3584;
        if ((solmu.getMatka() + naapuri.getPaino()) < naapuri.getMatka()) {
            naapuri.setMatka(solmu.getMatka() + naapuri.getPaino());
            naapuri.setEdellinen(solmu);
        }
        keko.add(naapuri);
    }

    /**
     * Ketkä ovat solmun naapureita. Tutkitaan onko naapurit jo luotu (eli ovat
     * kaydyt matriisissa) ja jos ei niin luodaan uusi solmu.
     *
     * @param y Suhteellinen Y-koordinaatti
     * @param i For-loopin y-osa
     * @param x Suhteellinen X-koordinaaatti
     * @param j For-loopin x-osa
     */
    @Override
    public <T extends Node> Node maaritaNaapuri(int y, int i, int x, int j) {
        if (kaydyt[y + i][x + j] == null) {
            naapuri = new NodeD(x + j, y + i, maali);
            kaydyt[y + i][x + j] = naapuri;
        } else {
            naapuri = kaydyt[y + i][x + j];
        }
        return naapuri;
    }

    /**
     * Jos solmussa ei ole käyty, suoritetaan solmun läpikäynti, jossa
     * tarkastetaan onko solmu maali solmu ja jos ei niin käydään naapurit läpi.
     *
     * @return true Jos solmu on maali, muutoin false
     */
    @Override
    public boolean solmunLapikaynti(Node solmu) {
        laskuri++;
        getNaapurit(solmu);
        return false;
    }
}
