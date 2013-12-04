/*
 *
 */
package algorithmsusmap;



/**
 *
 * @author Tieto
 */
public class AlgorithmsUSMap {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    

    
        SexyCities.initCities();
        
        ReadCVS readEdges = new ReadCVS();
	readEdges.run();
        //SexyCities.sexyString();
       MST mst = new MST();
       mst.DJP("Grand Forks", SexyCities.cities);
        
    }
}
