/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsusmap;
import java.util.LinkedList;
        

/**
 *
 * @author Tieto
 */
public class SexyCities {
    public static final int CITIES = 115;
     
    public static LinkedList[] cities= new LinkedList[CITIES]; 
    public static int chrisCounter = 0;
    
    
    public static void initCities(){
        int i;
        for (i=0; i < cities.length; i++){
            cities[i] = new LinkedList<>();
        }
        
    }
    
    public static void addEdge(Edge e){
        int isFound = search(e.getU() );
        
        //if city is in array then we will append it to the list
        if(isFound >= 0 ){
            cities[isFound].add(e);
            
        } else {
            for (int i=0; i < cities.length; i++){
                if(cities[i].isEmpty() ){
                    chrisCounter++;
                    cities[i].add(e);
                    break;
                }
            }       
        }   
    }
    
    public static int search(String u) {
        int pos = -1;
        //System.out.println(u);
        for(int i = 0; i < cities.length; i++){
            //System.out.println(cities[i].get(0));
            if (cities[i].isEmpty()){
                break;
            }else {
                Edge temp = (Edge) cities[i].get(0);
                if (temp.getU().equals(u)) {
                    pos = i;
                    break;
                }
            }
        }
        //System.out.printf("%d", pos);
        return pos;// returns -1 if not found...
    }
    
    public static void sexyString(){
        MST A = new MST(); // used for testing queue
        
        for (int i = 0; i < cities.length; i++) {
            for (int j =0; j< cities[i].size(); j++) {
               // Edge temp = (Edge) cities[i].get(j);
                A.addEdge( (Edge) cities[i].get(j));
               
                //System.out.printf("\n(%s, %s) %d",
                                    //temp.getU(), temp.getV(), temp.getWeight());
                
            }
        }
        
        while(A.loosies.peek() != null){
        Edge temp = A.getEdge();
                 System.out.printf("\n(%s, %s) %d",
                                    temp.getU(), temp.getV(), temp.getWeight());
        }
        }
    
}
