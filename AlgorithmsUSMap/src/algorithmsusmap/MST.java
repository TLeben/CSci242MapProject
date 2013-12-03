/*
 *This class builds a min spanning tree 
 */
package algorithmsusmap;


import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 *
 * @author Tieto
 */
public class MST {
    public static final int INITIALCAP = 11; // initial capicity for priority Q 
    EdgeComparator edgeCompare; // compares weight of two Edges
    PriorityQueue<Edge> loosies; // holds Edges not in the MST 
   
    public MST(){  
    edgeCompare = new EdgeComparator(); 
    loosies = new PriorityQueue<>(INITIALCAP, edgeCompare);
        
    }
    
    
    public void addEdge(Edge e) {
        loosies.offer(e);
    }
    
    public Edge getEdge(){
        return loosies.poll();
    }

    //This builds a MST.
    public void DJP(String startU, LinkedList[] cities/*adjency list*/){
        boolean isNewV = false; 
        List<String> V = new ArrayList<>(); //list of added vertices
         List<Edge> A = new ArrayList<>(); //MST of edges
        
        //start at arbitrary v(Grand Forks) and add all edges to Queue (Grand Forks, u)
        do {
            System.out.println("print do");
            V.add(startU);
            int i = SexyCities.search(startU);
            for (int j =0; j< cities[i].size(); j++) {
               System.out.println("adding ");
                loosies.offer( (Edge) cities[i].get(j)); //adds edges to Priority Q
            
            while (!isNewV){
                System.out.println("while not isNewV");
                //pop edge with smallest weight
                Edge temp = loosies.poll();
                if(temp == null){break;}
                   // System.out.println("break");
                
                 // error checking 
                //check if v is in queue
                if (this.checkMst(temp, V) ){
                    startU = temp.getV();
                    A.add(temp);
                    isNewV = true;
                    System.out.println("setting true");
                }
            }
            }
        } while ( !loosies.isEmpty() );
        printMST(A);
        
    }
    //helper function for DJP to check if edge is in MST
    private boolean checkMst(Edge e, List<String> arr){
        boolean isInMST = false;
        for (int i = 0; i < arr.size(); i++){
            if( arr.get(i).equals(e.getV()) ){
                isInMST = true;
            }
        }
        
        return isInMST;
    }
    
    public void printMST(List<Edge> a){
        System.out.println("printMST");
        for (int i= 0; i < a.size(); i++ ) {
            Edge e = a.get(i);
            System.out.printf("(%s, %s) %d\n",e.getU(), e.getV(), e.getWeight() );
        }
    }
    
}
