/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * @author tuukka
 */
public class Tiralabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     *  Djikstran algoritmi
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
    }
    
    /**
     * A*-heuristiikka numero 1
     * Euklidinen etäisyys
     */
    
    private static void heur1() {
        
    }
    
        /**
     * A*-heuristiikka numero 2
     * Oma heuristiikka
     */
    
    private static void heur2() {
        
    }
}
