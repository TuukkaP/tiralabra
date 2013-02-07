package tiralabra;

/**
 * Tiralabran main
 *
 * @author Tuukka Peuraniemi
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
     * @param args Komentorivisyötteet
     */
    public static void main(String[] args) {
        String kuvanNimi = "kartta3.png";
        kuva = new Kuva(kuvanNimi);
        djikstra();
        kuva = new Kuva(kuvanNimi);
        astar();
        kuva = new Kuva(kuvanNimi);
        bellmanFord();

    }

    /**
     * Djikstran algoritmi
     */
    private static void djikstra() {
        long startTime = System.currentTimeMillis();
        alusta();
        Node solmu = null;
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
                if (solmu.isMaali()) {
                    long endTime = System.currentTimeMillis();
                    System.out.println("Djikstralla kesti: " + ((endTime - startTime)) + " ms");
                    break;
                }
                laskuri++;
                solmu.setKayty(true);
                getNaapurit(keko, solmu, 0, pikselit, maali, kaydyt);
            }
        }
        if (keko.isEmpty()) {
            System.out.println("Ei ratkaisua");
        }
        kuva.tulostaTulokset(pikselit, "TulosDjikstra.png");
        int matka = piirraTieMaaliin(solmu, -1237980, pikselit);
        System.out.println("Djikstra, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + maali.getMatka());
        kuva.tulostaTulokset(pikselit, "TulosDjikstra.png");
        laskuri = 0;
    }

    /**
     * A* -algoritmi
     */
    private static void astar() {
        long startTime = System.currentTimeMillis();
        alusta();
        Node solmu = null;
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
                if (solmu.isMaali()) {
                    long endTime = System.currentTimeMillis();
                    System.out.println("Astarilla kesti: " + ((endTime - startTime)) + " ms");
                    int matka = piirraTieMaaliin(solmu, -1237980, pikselit);
                    System.out.println("Astar, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + maali.getMatka());
                    kuva.tulostaTulokset(pikselit, "TulosAstar.png");
                    laskuri = 0;
                    return;
                }
                laskuri++;
                solmu.setKayty(true);
                getNaapurit(keko, solmu, 1, pikselit, maali, kaydyt);
            }
        }
        System.out.println("Ei ratkaisua");
        kuva.tulostaTulokset(pikselit, "TulosAstar.png");
    }

    /**
     * Bellman-Fordin algoritmi
     */
    public static void bellmanFord() {
        long startTime = System.currentTimeMillis();
        alusta();
        for (int i = 0; i < pikselit.length; i++) {
            for (int j = 0; j < pikselit[0].length; j++) {
                if (pikselit[i][j] != -16777216) {
                    kaydyt[i][j] = new NodeD(j, i, null);
                }
            }
        }
        Node solmu = null;
        while (!keko.isEmpty()) {
            solmu = keko.poll();
            if (!solmu.isKayty()) {
                solmu.setKayty(true);
                laskuri++;
                getNaapurit(keko, solmu, 2, pikselit, null, kaydyt);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Bellman-Fordilla kesti: " + ((endTime - startTime)) + " ms");
        Node prev = kaydyt[kuva.getMaaliY()][kuva.getMaaliX()];
        int matka = 0;
        while (true) {
            pikselit[prev.getY()][prev.getX()] = -1237980;
            matka++;
            prev = prev.getEdellinen();
            if ((prev.getX() == kuva.getLahtoX() && prev.getY() == kuva.getLahtoY())) {
                break;
            }
        }
        System.out.println("BF, matkaa tuli " + matka + " tutkittuja solmuja " + laskuri + ", maalisolmun painotettu matka " + kaydyt[kuva.getMaaliY()][kuva.getMaaliX()].getMatka());
        kuva.tulostaTulokset(pikselit, "TulosBF.png");
    }

    /**
     * Solmun naapureiden getteri.
     *
     * @param keko Keko mihin naapurit lisätään
     * @param solmu Solmu, jonka naapurit haetaan.
     * @param tyyppi Metodi, josta getNaapurit-metodia kutsutaan
     * @param pikselit Pikselimatriisi
     * @param maali Maalisolmu
     * @param kaydyt Matriisi, jossa solmut ovat.
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
                    } else if (tyyppi == 0 && kaydyt[y + i][x + j] == null) {
                        naapuri = new NodeD(x + j, y + i, maali);
                        kaydyt[y + i][x + j] = naapuri;
                    } else {
                        naapuri = kaydyt[y + i][x + j];
                    }
                    if ((i == 0 && j == 0) || (i == 0 && j == 2) || (i == 2 && j == 0) || (i == 2 && j == 2)) {
                        // Kulmittain on helpompi kulkea
                        naapuri.setPaino(3);
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
     * @param prev Solmu, josta lähdetään liikkeelle
     * @param vari Reitin väri
     * @param pikselit Pikselimatriisi
     */
    public static int piirraTieMaaliin(Node prev, int vari, int[][] pikselit) {
        int matka = 0;
        while (prev.getEdellinen() != null) {
            pikselit[prev.getY()][prev.getX()] = vari;
            prev = prev.getEdellinen();
            matka++;
        }
        return matka;
    }

    /**
     * Kekojen ja solmujen alustukset.
     */
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
