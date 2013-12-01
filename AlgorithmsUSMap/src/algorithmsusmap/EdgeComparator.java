/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsusmap;
import java.util.*;

/**
 *
 * @author Tieto
 */
public class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare (Edge o1, Edge o2) {
        return o1.getWeight().compareTo(o2.getWeight() );
    }
}
