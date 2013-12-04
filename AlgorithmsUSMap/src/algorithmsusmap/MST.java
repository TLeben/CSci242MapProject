/*
 *This class builds a min spanning tree 
 */
package algorithmsusmap;


import java.util.PriorityQueue;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/*
 *
 * @author Tieto
 */
public class MST {
    public static final int INITIALCAP = 11; // initial capicity for priority Q 
    EdgeComparator edgeCompare; // compares weight of two Edges
    PriorityQueue<Edge> loosies; // holds Edges not in the MST 
    public int cityCount = 0;
    public int edgeCount = 0;
    public int totalWeight = 0;
   
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
            isNewV = false;
            V.add(startU);
            cityCount++;
            int i = SexyCities.search(startU);
            
            for (int j =0; j< cities[i].size(); j++) {
                
                loosies.offer( (Edge) cities[i].get(j)); //adds edges to Priority Q
            
            }
                while (!isNewV){
                    //System.out.println("while not isNewV" );
                    //pop edge with smallest weight
                    Edge temp = loosies.poll();
                    // error checking
                    if(temp== null){break;}
                      
                    //check if v is in queue
                    if (!checkMst(temp, V) ){
                        startU = temp.getV();
                        
                        A.add(temp);
                        edgeCount++;
                        totalWeight += temp.getWeight();
                        isNewV = true;
                    }
                    //else System.out.println("\n did not add "+startU);
                } 
            
        } while ( !loosies.isEmpty() );
        printMST(A, cityCount );
        
        
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
    
    public void printMST(List<Edge> a, int cities){
       String s1 = ""; 
       String s2 = "";
       boolean foo = true;
        System.out.printf("\n\n\t\tMinimum Spanning Tree "
                + "of US Cities from Grand Forks\n"
                + "\n\t\tTotal Weight: %d Edges: %d"
                +" Cities: %d" 
                + "\n----------------------------------------------------"
                + "--------------------------------\n",totalWeight,edgeCount,cityCount);
        for (int i= 0; i < a.size(); i++ ) {
  
                Edge e = a.get(i);
                if (i%2 == 0){
                    s1 = String.format("-(%s, %s) %3d\t",e.getU(), e.getV(), e.getWeight() );
                } else{
                    s2 = String.format("-(%s, %s) %3d\t",e.getU(), e.getV(), e.getWeight() );
                    System.out.printf("%35s  %-35s\n",s1,s2);   
            }
        }
    }    
}
