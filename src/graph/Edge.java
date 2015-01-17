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

/**
 *
 * @author Ignacio Arnaldo
 */
public class Edge {
    
    private final Coordinates fromCoords;
    private final Coordinates toCoords;
    private final String roadClass, type, name;//secondary, tertiary, etc..
    private final boolean directed, isTunnel, isBridge;
    private long nodeIDTo;
    
    
    /**
     * Constructor
     * @param aCoordsFrom
     * @param aCoordsTo
     * @param aRoadClass
     * @param aType
     * @param isDirectedFlag
     * @param isTunnelFlag
     * @param isBridgeFlag
     * @param aName 
     */
    public Edge(Coordinates aCoordsFrom, Coordinates aCoordsTo, String aRoadClass,String aType,
            boolean isDirectedFlag, boolean isTunnelFlag, boolean isBridgeFlag, String aName){
        fromCoords = aCoordsFrom;
        toCoords = aCoordsTo;
        roadClass = aRoadClass;
        type = aType;
        directed = isDirectedFlag;
        isTunnel = isTunnelFlag;
        isBridge = isBridgeFlag;
        name = aName;
        nodeIDTo = -1;
    }
    
    /**
     * @return nodeId
     */
    public long getNodeIDto(){
        return nodeIDTo;
    }
    
    /**
     * set destiny node ID
     * @param anID 
     */
    public void setNodeIDto(long anID){
        nodeIDTo = anID;
    }
    
    /**
     * is the edge directed/one-way?
     * @return directed flag
     */
    public boolean isDirected(){
        return directed;
    }
    
    /**
     * is the edge a tunnel?
     * @return isTunnel flag
     */
    public boolean isTunnel(){
        return isTunnel;
    }
    
    /**
     * is the edge a Bridge?
     * @return isBridge flag
     */
    public boolean isBridge(){
        return isBridge;
    }
    
    /**
     * @return edge type (railway or roadway)
     */
    public String getType(){
        return type;
    }
    
    /**
     * @return edge class (highway, driveway etc..)
     */
    public String getRoadClass(){
        return roadClass;
    }
    
    /**
     * @return road name
     */
    public String getEdgename(){
        return name;
    }
    
    /**
     * @return origin coordinates
     */
    public Coordinates getCoordsFrom(){
        return fromCoords;
    }
    
    /**
     * Destiny coordinates
     * @return 
     */
    public Coordinates getCoordsTo(){
        return toCoords;
    }
}
