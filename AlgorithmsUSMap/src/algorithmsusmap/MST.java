/*
 *This class builds a min spanning tree 
 */
package algorithmsusmap;


import java.util.PriorityQueue;
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
    
    //This builds a MST.
    public void primms(){
        
    }
    
}
