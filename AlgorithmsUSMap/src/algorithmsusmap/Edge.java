/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsusmap;


/**
 *
 * @author Tieto
 */
public class Edge {
    public final int INFINITY = 9999999;
    Vertex U;
    Vertex V;
    String _u;
    String _v;
    Integer _w;
    
    public Edge(){
        _u = null;
        _v = null;
        _w = -1; 
    }
    public Edge(String u, String v, Integer w) {
        _u = u;
        U = new Vertex(u);
        V = new Vertex(v);
        _v = v;
        _w = w;
    }
    
    public String getU() {
        return _u;
    }
    public String getV() {
        return _v;
    }
    public Integer getWeight() {
        
        return _w;
    }
    
    
}
