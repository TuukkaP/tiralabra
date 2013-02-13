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
        kaydyt[kuva.getLahtoY()][kuva.getLahtoX()] = lahto;
        kaydyt[kuva.getMaaliY()][kuva.getMaaliX()] = maali;
        lahto.setMatka(0);
        alustaSolmut();
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
     * Bellman-Fordissa luodaan aluksi kaikki solmut, jotka relaksoidaan.
     */
    private void alustaSolmut() {
        for (int i = 0; i < pikselit.length; i++) {
            for (int j = 0; j < pikselit[0].length; j++) {
                if (pikselit[i][j] != -16777216) {
                    kaydyt[i][j] = new NodeD(j, i, null);
                }
            }
        }
    }

    /**
     * Bellman-Fordille sopiva pikselikartan muokkaaja.
     *
     * @param prev Tässä tapauksessa prev on maalisolmu, josta lähdetään
     * kelaamaan kohti maalia.
     * @param vari Väri, jolla reitti piirretään.
     * @return Palautetaan läpikäytyjen solmujen määrä.
     */
    @Override
    public int piirraTieMaaliin(Node prev, int vari) {
        prev = kaydyt[kuva.getMaaliY()][kuva.getMaaliX()];
        int matka = 0;
        while (matka <= (pikselit.length * pikselit[0].length)) {
            pikselit[prev.getY()][prev.getX()] = -1237980;
            prev = prev.getEdellinen();
            matka++;
            if (prev == null || (prev.getX() == kuva.getLahtoX() && prev.getY() == kuva.getLahtoY())) {
                break;
            }
        }
        return matka;
    }

    /**
     * Bellman-Fordin suorituksen lopetus.
     */
    @Override
    public void suoritusLoppui() {
        int matka = piirraTieMaaliin(null, -1237980);
        if (matka > 1 && matka != (pikselit.length * pikselit[0].length)) {
            System.out.println("BF, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + kaydyt[kuva.getMaaliY()][kuva.getMaaliX()].getMatka());
            kuva.tulostaTulokset(pikselit, "TulosBF.png");
        } else {
            System.out.println("Ratkaisua ei löytynyt.");
        }
    }
}
