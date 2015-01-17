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
public class Coordinates {
    
    private final double x,y;
    private final boolean isTunnel, isBridge;
        
    /**
     * Constructor
     * @param coordX
     * @param coordY
     * @param isTunnelFlag
     * @param isBridgeFlag 
     */
    public Coordinates(double coordX,double coordY,boolean isTunnelFlag, boolean isBridgeFlag) {
        x = coordX;
        y = coordY;
        isTunnel = isTunnelFlag;
        isBridge = isBridgeFlag;
    }
    
    /**
     * @return x coordinate
     */
    public double getCoordX (){
        return x;
    }
     
    /**
     * @return y coordinate
     */
    public double getCoordY(){
        return y;
    }
    
    /**
     * is the location on a bridge?
     * @return isBridge flag
     */
    public boolean isBridge(){
        return isBridge;
    }
    
    /**
     * is the location on a tunnel?
     * @return isTunnel flag
     */
    public Boolean isTunnel(){
        return isTunnel;
    }
    
    /**
     * @param o
     * @return whether two Coordinate objects are equal
     */
    @Override   
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates)){
            return false;
        }
        Coordinates otherNode = (Coordinates) o;
        if (otherNode.getCoordX()==x && otherNode.getCoordY()==y 
                && otherNode.isBridge()==isBridge && otherNode.isTunnel()==isTunnel){
        } else {
            return false;
        }
        return true;
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }


}
