/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package roads;

/**
 *
 * @author Ignacio Arnaldo
 */
public class Segment {
    
    private final double startX, startY, endX, endY;
    
    /**
     * Constructor
     * @param aStartX
     * @param aStartY
     * @param anEndX
     * @param anEndY 
     */
    public Segment(double aStartX, double aStartY, double anEndX, double anEndY){
        startX = aStartX;
        startY = aStartY;
        endX = anEndX;
        endY = anEndY;
    }

    /**
     * Start x coordinate
     * @return startX
     */
    public double getStartX() {
        return startX;
    }

    /**
     * Start y coordinate
     * @return startY
     */
    public double getStartY(){
        return startY;
    }

    /**
     * End x coordinate
     * @return endX
     */
    public double getEndX(){
        return endX;
    }

    /**
     * End y coordinate
     * @return endY
     */    
    public double getEndY(){
        return endY;
    }
    
}
