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
    public static int roadTrip = 0;
    
    VertexComparator vertCompare;
    EdgeComparator edgeCompare; // compares weight of two Edges
    PriorityQueue<Edge> loosies; // holds Edges not in the MST
    public Vertex source;
    public int cityCount = 0;
    public int edgeCount = 0;
    public int totalWeight = 0;
 
     
    public MST(){ 
    
      
    edgeCompare = new EdgeComparator(); 
    loosies = new PriorityQueue<>(INITIALCAP, edgeCompare);
    vertCompare = new VertexComparator();
    
        
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
                      
                        //System.out.println("adding "+ temp.getU()+" " +temp.getV());
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
//        int i =0;
//        while (!a.isEmpty()){
//            Edge  e = a.remove(0);
                Edge e = a.get(i);
                if (i%2 == 0){
                    s1 = String.format("-(%s, %s) %3d\t",e.getU(), e.getV(), e.getWeight() );
                } else{
                    s2 = String.format("-(%s, %s) %3d\t",e.getU(), e.getV(), e.getWeight() );
                    System.out.printf("%35s  %-35s\n",s1,s2);   
            }
        } System.out.printf("%35s",s1);
    }
    
    public void shortestPath(LinkedList[] cities, String ss, String s){
        List<Vertex> verts = new ArrayList<Vertex>();
        verts.clear();
        PriorityQueue<Vertex> unvisited;
        
        unvisited = new PriorityQueue<>(INITIALCAP,vertCompare);
        unvisited.clear();
        String newU;
        int u;
        int v;
        
        //this fills an array of verticies
        for (int j = 0; j < 114; j++){
            Vertex t;
            t = new Vertex( ((Edge)cities[j].get(0)).getU()); 
          
            if(t._name.equals(s) ){
                t._w = 0;
                t.added = true; // this is the source
                unvisited.add(t); 
                
                
            }  verts.add(t);
        }
        int fml = 0;
        while(!unvisited.isEmpty()){
            
                Vertex n = unvisited.poll();
                n.visited = true;
                
                newU = n._name;
                
               
            
            //System.out.println(++fml + newU);
             
             int i = SexyCities.search(newU);
             for (int j =0; j< cities[i].size(); j++){
             
                 Edge temp = (Edge) cities[i].get(j);
                 //System.out.println(temp.getU());
                 u =vertSearch2(verts, temp.getU() );
                 v =vertSearch2(verts, temp.getV() );
                 
                //relax
                 if (verts.get(v)._w > verts.get(u)._w + temp.getWeight()){
                    verts.get(v)._w = verts.get(u)._w + temp.getWeight();
                    verts.get(v).ancestor = verts.get(u); 
                    if (!verts.get(v).visited){
                        unvisited.add(verts.get(v));
                        if (verts.get(v)._name.equals(ss)) break;
                    }
                    temp = null;
                }

             }

      
        }
        
            List<Vertex> trip = new ArrayList<Vertex>();
            trip.clear();
            int gg = vertSearch2(verts, ss);
            Vertex tango;
            tango = verts.get(gg);
            while (tango.ancestor != null){
                trip.add(0,tango);
               
                gg =vertSearch2(verts, tango.ancestor._name);
                tango = verts.get(gg);
            }
            
            for (int h = 0; h < trip.size(); h++){
               if (h== trip.size() - 1){
                   roadTriptrip.get(h)._w;
               }
                System.out.printf("\n  %s %d ", trip.get(h)._name, trip.get(h)._w);
            }
//           for ( int p = 0; p < verts.size(); p++){
//            System.out.printf("\n%d- **%d  %s %d",p+1, vertSearch2(verts, verts.get(p)._name), verts.get(p)._name, verts.get(p)._w);
//           }
        
    }
    
 
       public int vertSearch2(List<Vertex> v, String n){
           int i = -1;
           for (int b = 0; b< v.size(); b++ ){
               if (v.get(b)._name.equals(n)) {
                   i = b;
                   break;
               }
            }
           return i;
       }
       public void goOnTrip(String[] s){
           
          int k = 0;
          shortestPath(SexyCities.cities, s[k+1],s[k] );
          k++;
           shortestPath(SexyCities.cities, s[k+1],s[k] );
          
           
           }
}
