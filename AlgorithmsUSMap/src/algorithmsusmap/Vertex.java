/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmsusmap;

/**
 *
 * @author Tyler
 */

public class Vertex {
    public static final int INFINITY = 9999999;
    public String _name;
    boolean visited = false;
    boolean added = false;
    public Vertex ancestor = null;
    public Integer _w =INFINITY;
    
    public Vertex(String x){
       _name = x;
    }

}


