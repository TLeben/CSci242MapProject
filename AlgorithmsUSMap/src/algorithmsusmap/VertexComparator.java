/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmsusmap;
import java.util.*;
/**
 *
 * @author Tyler
 */
public class VertexComparator implements Comparator<Vertex>{
        @Override
    public int compare (Vertex o1, Vertex o2) {
        return o1._w.compareTo(o2._w );
    }


    
}
