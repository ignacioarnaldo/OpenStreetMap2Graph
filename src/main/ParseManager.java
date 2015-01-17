/**
 * Copyright (c) 2011-2013 Evolutionary Design and Optimization Group
 * 
 * Licensed under the MIT License.
 * 
 * See the "LICENSE" file for a copy of the license.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.  
 *
 */

package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import parsejsonmaps.ParseJsonMaps;

/**
 *
 * @author Ignacio Arnaldo
 */
public class ParseManager {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        // TODO code application logic here
        
        // MADRID
        /*String path_to_map = "test/madrid_spain-roads.geojson";
        //String roadClass = "highway";// or railway
        String roadClass = "railway";// or railway
        //X range [−3.536570133,−3.914573235]
        //X range [3.662571167,3.788572201]
        double minX = -3.7509727478027344;
        double maxX = -3.65518569946289;
        // Y range [40.29201553,40.537983518]
        // Y range in [40.390402726,40.439596324]
        //-3.7509727478027344,40.398529177904926,-3.65518569946289,40.43936977302504
        double minY = 40.378529177904926;
        double maxY = 40.45936977302504;
        ParseJsonMaps pjm = new ParseJsonMaps(path_to_map,minX,maxX,minY,maxY);
        pjm.readJSONMap();
        pjm.generateGraph(roadClass);
        pjm.printGraph(roadClass);*/
        
        
        // BOSTON!!
        //-71.16497039794922,42.33050426119193,-71.03347778320312,42.40976960320691
        /*String path_to_map = "test/boston_massachusetts-roads.geojson";
        String roadClass = "highway";// or railway
        double minX = -71.16497039794922;
        double maxX = -71.03347778320312;
        double minY = 42.33050426119193;
        double maxY = 42.40976960320691;
        ParseJsonMaps pjm = new ParseJsonMaps(path_to_map,minX,maxX,minY,maxY);
        pjm.readJSONMap();
        pjm.generateGraph(roadClass);
        pjm.printGraph(roadClass);*/
        
        // NEW YORK!!
        //-74.0969467163086,40.70016219564594,-73.8339614868164,40.85147526676901
        //String path_to_map = "test/new-york_new-york-roads.geojson";
        //String roadClass = "highway";// or railway
        //String roadClass = "railway";// or railway
        //double minX = -74.0969467163086;
        //double maxX = -73.8339614868164;
        //double minY = 40.70016219564594;
        //double maxY = 40.85147526676901;
        
        if(args.length==6){
            String path_to_map = args[0];
            String roadClass = args[1];
            double minX = Double.parseDouble(args[2]);
            double maxX = Double.parseDouble(args[3]);
            double minY = Double.parseDouble(args[4]);
            double maxY = Double.parseDouble(args[5]);
            ParseJsonMaps pjm = new ParseJsonMaps(path_to_map,minX,maxX,minY,maxY);
            pjm.readJSONMap();
            pjm.generateGraph(roadClass);
            pjm.printGraph(roadClass);
        }else{
            System.err.println("ERROR: Wrong number of arguments");
            System.err.println();
            System.err.println("USAGE:");
            System.err.println();
            System.err.println("java -jar graphFromGeoJson.jar path_to_map road_class minX maxX minY maxY");
            System.err.println();
        }
    }
}
