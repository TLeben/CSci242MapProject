/*
 *
 */
package algorithmsusmap;
import java.util.*;


/**
 *
 * @author Tieto
 */
public class AlgorithmsUSMap {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner keyboard = new Scanner(System.in);

       
        SexyCities.initCities();
        String[] vacation = {"Grand Forks", "Seattle","Los Angeles","Kansas City",
            "Orlando", "New York City", "Madison", "Grand Forks"}; // stores cites for vacation
        
        ReadCVS readEdges = new ReadCVS();
	readEdges.run();
        //SexyCities.sexyString();
       MST mst = new MST();
       //mst.goOnTrip(vacation);
       System.out.printf("\nLeaving Grand Forks for the open road");
        mst.shortestPath(SexyCities.cities, "Seattle", "Grand Forks");
        System.out.printf("\nReady to go on your next trip? Press Enter");
        keyboard.nextLine();
        mst.shortestPath(SexyCities.cities, "Los Angeles", "Seattle");
        System.out.printf("\nReady to go on your next trip? Press Enter");
        keyboard.nextLine();
        mst.shortestPath(SexyCities.cities, "Kansas City", "Los Angeles");
        System.out.printf("\nReady to go on your next trip? Press Enter");
        keyboard.nextLine();
        mst.shortestPath(SexyCities.cities, "Orlando", "Kansas City");
        System.out.printf("\nReady to go on your next trip? Press Enter");
        keyboard.nextLine();
        mst.shortestPath(SexyCities.cities, "New York City", "Orlando");
        System.out.printf("\nReady to go on your next trip? Press Enter");
        keyboard.nextLine();
        mst.shortestPath(SexyCities.cities, "Madison", "New York City");
        System.out.printf("\nReady to go on your next trip? Press Enter");
        keyboard.nextLine();
        mst.shortestPath(SexyCities.cities, "Grand Forks", "Madison");
       
        System.out.printf( "\n--Your road trip took %d miles--", MST.roadTrip );

       
    }
}
