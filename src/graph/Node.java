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

/**
 *
 * @author Ignacio Arnaldo
 */
public class Node {
    
    private final double x,y;
    private long nodeID;
    ArrayList<Edge> listEdges;
    
    
    /**
     * Constructor
     * @param aX
     * @param aY
     * @param anID 
     */
    public Node(double aX, double aY, long anID){
        x = aX;
        y = aY;
        nodeID = anID;
        listEdges = new ArrayList<>();
    }
     
    /**
     * Set node ID
     * @param anID 
     */
    public void setNodeID(long anID){
        nodeID = anID;
    }
    
    /**
     * get Node ID
     * @return 
     */
    public long getNodeID(){
        return nodeID;
    }
    
    /**
     * get coordinate X
     * @return x coordinate
     */
    public double getCoordX (){
        return x;
    }
     
    /**
     * get coordinate Y
     * @return y coordinate
     */
    public double getCoordY(){
        return y;
    }
    
    /**
     * list of edges connecting the node
     * @return listEdges
     */
    public ArrayList<Edge> getEdges(){
        return listEdges;
    }

}