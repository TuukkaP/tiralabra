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
        String kuvanNimi = args[0];
        Djikstra djikstra = new Djikstra(kuvanNimi);
        long startTime = System.currentTimeMillis();
        djikstra.suorita();
        long endTime = System.currentTimeMillis();
        System.out.println("Djikstrassa kesti " + (endTime-startTime) + " ms");
        Astar astar = new Astar(kuvanNimi);
        startTime = System.currentTimeMillis();
        astar.suorita();
        endTime = System.currentTimeMillis();
        System.out.println("Astar kesti " + (endTime-startTime) + " ms");
        BellmanFord bf = new BellmanFord(kuvanNimi);
        startTime = System.currentTimeMillis();
        bf.suorita();
        endTime = System.currentTimeMillis();
        System.out.println("Bellman-Ford kesti " + (endTime-startTime) + " ms");
    }
}
