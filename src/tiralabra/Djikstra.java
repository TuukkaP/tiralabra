/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * Djikstra algoritmin luokka
 */
public class Djikstra extends Verkko {

    public Kuva kuva;

    public Djikstra(String kuvaTiedosto) {
        kuva = new Kuva(kuvaTiedosto);
        pikselit = kuva.getPikselit();
        kaydyt = new NodeD[pikselit.length][pikselit[0].length];
        keko = new MinKeko(new NodeD[pikselit.length * pikselit[0].length]);
        maali = new NodeD(kuva.getMaaliX(), kuva.getMaaliY(), null);
        lahto = new NodeD(kuva.getLahtoX(), kuva.getLahtoY(), maali);
        kaydyt[kuva.getLahtoY()][kuva.getLahtoX()] = lahto;
        kaydyt[kuva.getMaaliY()][kuva.getMaaliX()] = maali;
        maali.setMaali(true);
    }

    /**
     * Kun maalisolmu löydetään keosta. Djikstrassa algoritmin läpikäyminen voidaan lopettaa, koska jos 
     *
     * @param solmu Maalisolmu
     * @return Palauttaa true jos tulostukset on tehty.
     */
    @Override
    public boolean maalisolmuLoydetty(Node solmu) {
        int matka = piirraTieMaaliin(solmu, -1237980);
        System.out.println("Djikstra, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + maali.getMatka());
        kuva.tulostaTulokset(pikselit, "TulosDjikstra.png");
        return true;
    }
}
