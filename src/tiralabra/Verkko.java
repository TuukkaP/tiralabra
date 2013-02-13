/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * A*-, Djikstran- sekä Bellman-Fordin -algoritmien perusmetodit.
 */
public abstract class Verkko {

    public int laskuri = 0;
    public int[][] pikselit;
    public Node[][] kaydyt;
    public MinKeko keko;
    public Node maali;
    public Node lahto;
    public Node naapuri;
    public Node solmu;

    /**
     * Djikstran ja Astarin algoritmin suorittaminen.
     */
    public void suorita() {
        keko.add(lahto);
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
                if (solmunLapikaynti(solmu)) {
                    return;
                }
            }
        }
        suoritusLoppui();
    }

    /**
     * Solmun naapureiden getteri. Naapurit määritetään keskussolmun avulla
     * olevasta matriisista.
     *
     * @param solmu Solmu, jonka naapurit haetaan.
     */
    public <T extends Node> void getNaapurit(T solmu) {
        int x = solmu.getX() - 1;
        int y = solmu.getY() - 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pikselit[y + i][x + j] != -16777216 && (i != 1 || j != 1)) {
                    naapuri = maaritaNaapuri(y, i, x, j);
                    kulkusuunnanKustannus(i, j);
                    relaxNaapurit(y, i, x, j, solmu);
                }
            }
        }
    }

    /**
     * Määrittää reitin värin ja muokkaa ne verkosta.
     *
     * @param prev Solmu, josta lähdetään liikkeelle
     * @param vari Reitin väri
     */
    public int piirraTieMaaliin(Node prev, int vari) {
        int matka = 0;
        while (prev.getEdellinen() != null) {
            pikselit[prev.getY()][prev.getX()] = vari;
            prev = prev.getEdellinen();
            matka++;
        }
        return matka;
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
     * Naapureiden relaksointi eli päivitetään uusi matka jos lyhyempi kuin
     * vanha matka.
     *
     * @param y Alkuperäisen solmun läpikäyntiä varten määritetty y-koordinaatti
     * @param i For-loopin y-osa
     * @param x Alkuperäisen solmun läpikäyntiä varten määritetty x-koordinaatti
     * @param j For-loopin x-osa
     * @param solmu Käytävä solmu
     */
    public <T extends Node> void relaxNaapurit(int y, int i, int x, int j, T solmu) {
        pikselit[y + i][x + j] = -3584;
        if ((solmu.getMatka() + naapuri.getPaino()) < naapuri.getMatka()) {
            naapuri.setMatka(solmu.getMatka() + naapuri.getPaino());
            naapuri.setEdellinen(solmu);
            keko.add(naapuri);
        }
    }

    /**
     * Määritetään onko sivuttain vai suoraan kulkeminen edullista
     *
     * @param i Käytävän for-loopin x-osa
     * @param j Käytävän for-loopin y-osa
     */
    public void kulkusuunnanKustannus(int i, int j) {
        if ((i == 0 && j == 0) || (i == 0 && j == 2) || (i == 2 && j == 0) || (i == 2 && j == 2)) {
            naapuri.setPaino(3);
        }
    }

    /**
     * Jos solmussa ei ole käyty, suoritetaan solmun läpikäynti, jossa
     * tarkastetaan onko solmu maali solmu ja jos ei niin käydään naapurit läpi.
     *
     * @return true Jos solmu on maali, muutoin false
     */
    public boolean solmunLapikaynti(Node solmu) {
        if (solmu.isMaali()) {
            return maalisolmuLoydetty(solmu);
        }
        solmu.setKayty(true);
        laskuri++;
        getNaapurit(solmu);
        return false;
    }

    abstract boolean maalisolmuLoydetty(Node solmu);

    /**
     * Suoritusosion jälkimmäinen osa. Bellmanfordissa ei lopeteta maalisolmun
     * löytymiseen, vaan relaksoidaan kaikki solmut.
     */
    public void suoritusLoppui() {
        System.out.println("Ei ratkaisua");
    }
}
