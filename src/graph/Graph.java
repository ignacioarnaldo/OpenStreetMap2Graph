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

package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ignacio Arnaldo
 */
public class Graph {
   
    Map<Coordinates,Node> graphMap;
    private long nodeCounter;
    private double minX,maxX,minY,maxY;
    
    /**
     * Constructor
     */
    public Graph(){
        graphMap = new HashMap<>();
        nodeCounter = 0;
    }
    
    /**
     * whether an edge lies within the pre-fix map area
     * @param anEdge
     * @return isWithinRange flag
     */
    public boolean isWithinRange(Edge anEdge){
        boolean inRange = false;
        Coordinates coordsFrom = anEdge.getCoordsFrom();
        Coordinates coordsTo = anEdge.getCoordsTo();
        if(coordsFrom.getCoordX()<=maxX && coordsFrom.getCoordX()>=minX && coordsFrom.getCoordY()<=maxY && coordsFrom.getCoordY()>=minY
            &&  coordsTo.getCoordX()<=maxX && coordsTo.getCoordX()>=minX && coordsTo.getCoordY()<=maxY && coordsTo.getCoordY()>=minY){
            inRange = true;
        }
        return inRange;
    }
    
    /**
     * Add edge and 2 nodes to the graph. We check whether the node alreay
     * exists.
     * @param anEdge 
     */
    public void addNodesAndEdge(Edge anEdge){
        Coordinates coordsFrom = anEdge.getCoordsFrom();
        Coordinates coordsTo = anEdge.getCoordsTo();
        if (graphMap.containsKey(coordsFrom)){
            if (graphMap.containsKey(coordsTo)){
                Node nodeFrom = graphMap.get(coordsFrom);
                ArrayList<Edge> listAux = nodeFrom.getEdges();
                
                Node nodeTo = graphMap.get(coordsTo);
                anEdge.setNodeIDto(nodeTo.getNodeID());
                listAux.add(anEdge);
            }else{
                Node nodeFrom = graphMap.get(coordsFrom);
                ArrayList<Edge> listAux = nodeFrom.getEdges();
                
                Node nodeTo = new Node(coordsTo.getCoordX(),coordsTo.getCoordY(),nodeCounter);
                nodeCounter++;
                graphMap.put(coordsTo, nodeTo);
                
                anEdge.setNodeIDto(nodeTo.getNodeID());
                listAux.add(anEdge);
            }
        }else{
            if (graphMap.containsKey(coordsTo)){
                Node nodeFrom = new Node(coordsFrom.getCoordX(),coordsFrom.getCoordY(),nodeCounter);
                nodeCounter++;
                graphMap.put(coordsFrom, nodeFrom);
                ArrayList<Edge> listAux = nodeFrom.getEdges();
                
                Node nodeTo = graphMap.get(coordsTo);
                
                anEdge.setNodeIDto(nodeTo.getNodeID());
                listAux.add(anEdge);
            }else{
                Node nodeFrom = new Node(coordsFrom.getCoordX(),coordsFrom.getCoordY(),nodeCounter);
                nodeCounter++;
                graphMap.put(coordsFrom, nodeFrom);
                ArrayList<Edge> listAux = nodeFrom.getEdges();
                
                Node nodeTo = new Node(coordsTo.getCoordX(),coordsTo.getCoordY(),nodeCounter);
                nodeCounter++;
                graphMap.put(coordsTo, nodeTo);
                
                anEdge.setNodeIDto(nodeTo.getNodeID());
                listAux.add(anEdge);
            }
        }
    }
    
    /**
     * Returns the roads graph as a Map object
     * @return graphMap
     */
    public Map<Coordinates,Node> getMap(){
        return graphMap;
    }
    
    /**
     * set maximum X coordinate
     * @param aMaxX 
     */
    public void setMaxX(double aMaxX){
        maxX = aMaxX;
    }
    
    /**
     * Set minimum X coordinate
     * @param aMinX 
     */
    public void setMinX(double aMinX){
        minX = aMinX;
    }
    
    /**
     * set maximum X coordinate
     * @param aMaxY 
     */
    public void setMaxY(double aMaxY){
        maxY = aMaxY;
    }
    
    /**
     * set minimum Y coordinate
     * @param aMinY 
     */
    public void setMinY(double aMinY){
        minY = aMinY;
    }
    
}
