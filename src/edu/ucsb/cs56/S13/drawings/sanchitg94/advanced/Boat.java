package edu.ucsb.cs56.S13.drawings.sanchitg94.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Boat that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sanchit Gupta 
   @version for CS56, S13, UCSB
   
*/
public class Boat  extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of boat
       @param y y coord of lower left corner of boat
       @param width width of the boat
       @param height height of the boat
     */
    public Boat(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
       
        
	 Rectangle2D.Double pole = new Rectangle2D.Double(x, y - height, width/20, 2*height/3);

        Line2D.Double bottomBoat = 
            new Line2D.Double (x + 2* width/3, y, x, y);
                               
        Line2D.Double leftSide =
            new Line2D.Double (x, y, x - 1* width/3, y - height/3);

	Line2D.Double rightSide =
            new Line2D.Double (x + width, y - height/3,x + 2* width/3, y);

	Line2D.Double topSide = 
	    new Line2D.Double (x + width, y-height/3, x - 1*width/3, y - height/3);


        // put the whole boat together
       
        GeneralPath wholeBoat = this.get();
        wholeBoat.append(bottomBoat, false);
        wholeBoat.append(leftSide, false);
        wholeBoat.append(rightSide, false);
	wholeBoat.append(topSide, false);
	wholeBoat.append(pole, false);
	
        
    }

}
