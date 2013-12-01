/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsusmap;

import java.util.PriorityQueue;

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
        SexyCities.sexyString();
    }
}
