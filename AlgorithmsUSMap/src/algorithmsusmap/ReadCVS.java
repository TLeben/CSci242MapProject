/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsusmap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Tieto
 */
public class ReadCVS {
  
 

 
  public static void main(String[] args) {
 
	
 
  }
 
  public void run() {
 
	String csvFile = "USData.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        int count = 0; 
        
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
                
                //reads file line by line 
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
                        // edge[i] = each comma seperated token
			String[] edge = line.split(cvsSplitBy);
                        count++;
                        
			//System.out.println("u: " + edge[0] 
                          //      + " v: " + edge[1] + " weight: " + edge[2]);
                        
                        Edge n = new Edge(edge[0], edge[1], Integer.parseInt(edge[2]) );
                       
                        SexyCities.addEdge(n);
                       
                        
 
		}
                
	} catch (FileNotFoundException e) { //incase file is not found
	} catch (IOException e) {
	} finally {
		if (br != null) { // close the bufferreader when file is done
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
        //message that lets the user know the file has been completely read
	System.out.printf("Done - Processed %d lines - %d cities",count, SexyCities.chrisCounter);
  }
 
}
    

