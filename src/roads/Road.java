/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ignacio Arnaldo
 */
public class Road {
    
    String roadClass, type, name;
    boolean isOneway, isTunnel, isBridge;
    
    ArrayList<Segment> segments;
    
    /**
     * Constructor
     * @param line
     * @throws ParseException 
     */
    public Road(String line) throws ParseException{
        if(line.endsWith(",")){
            line =line.substring(0, line.lastIndexOf(','));
        }
        segments = new ArrayList<>();
        // read the json file
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(line);
        
        JSONObject jsonProperties =  (JSONObject)jsonObject.get("properties");
        isOneway = false;
        isTunnel = false;
        isBridge = false;
        type = (String)jsonProperties.get("type");
        name = (String)jsonProperties.get("name");
        roadClass = (String) jsonProperties.get("class");
        
        long oneWayAux = (Long)jsonProperties.get("oneway");
        if (oneWayAux == 1) {
            isOneway = true;
        }
        long tunnelAux = (Long)jsonProperties.get("tunnel");
        if (tunnelAux == 1) {
            isTunnel = true;
        }
        long bridgeAux = (Long)jsonProperties.get("bridge");
        if (bridgeAux == 1) {
            isBridge = true;
        }
        JSONObject jsonGeometry =  (JSONObject)jsonObject.get("geometry");
        
        JSONArray jsonCoordinates  =  (JSONArray) jsonGeometry.get("coordinates");
        for(int i=0;i<jsonCoordinates.size()-1;i++){
            String coordinatesOrigin = jsonCoordinates.get(i).toString();
            String coordinatesDest = jsonCoordinates.get(i+1).toString();
            coordinatesOrigin = coordinatesOrigin.substring(1, coordinatesOrigin.length()-1);
            coordinatesDest = coordinatesDest.substring(1, coordinatesDest.length()-1);
            saveText("madrid-map.csv",coordinatesOrigin + "," +  coordinatesDest + "\n",true);
            String startXString = coordinatesOrigin.split(",")[0];
            String startYString = coordinatesOrigin.split(",")[1];
            String endXString = coordinatesDest.split(",")[0];
            String endYString = coordinatesDest.split(",")[1];
            
            double startX = Double.parseDouble(startXString);
            double startY = Double.parseDouble(startYString);
            double endX = Double.parseDouble(endXString);
            double endY = Double.parseDouble(endYString);
            
            Segment segmentAux = new Segment(startX, startY, endX, endY);
            segments.add(segmentAux);
        }
    }
    
    /**
     * Returns road type
     * @return type
     */
    public String getType(){
        return type;
    }
    
    /**
     * is it a one-way road?
     * @return isOneWay
     */
    public boolean isOneway(){
        return isOneway;
    }
    
    /**
     * is the road a tunnel?
     * @return isTunnel
     */
    public boolean isTunnel(){
        return isTunnel;
    }
    
    /**
     * is the road a bridge
     * @return isBridge
     */
    public boolean isBridge(){
        return isBridge;
    }
    
    /**
     * Returns road name
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the road class
     * @return roadClass
     */
    public String getRoadClass(){
        return roadClass;
    }
    
    /**
     * Returns the segments composing the road
     * @return segments
     */
    public ArrayList<Segment> getSegments(){
        return segments;
    }
    
    /**
     * Save text to a filepath
     * @param filepath
     * @param text
     */
    static void saveText(String filepath, String text, Boolean append) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath,append));
            try (PrintWriter printWriter = new PrintWriter(bw)) {
                printWriter.write(text);
                printWriter.flush();
            }
        } catch (IOException e) {
            System.err.println("Error in saveText in Road.java");
        }
    }
}
