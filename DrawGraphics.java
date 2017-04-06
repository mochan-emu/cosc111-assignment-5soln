import java.awt.Color;
import java.awt.Graphics;

import java.util.*;

public class DrawGraphics {
    BouncingBox[] box = new BouncingBox[3];
    
    // Array of points that we will use to draw graphs
    int[] x;
    int[] y;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
    	Random rand = new Random();
    	for (int i=0; i<box.length; i++)
    	{
    		box[i] = new BouncingBox(rand.nextInt(300), rand.nextInt(300), Color.RED);
    		box[i].setMovementVector(rand.nextInt(2)-1, rand.nextInt(2)-1);
    	}
        
    	// Allocate the array of points that we are going to use to draw the graph
        x = new int[NUM_POINTS];
        y = new int[NUM_POINTS];
    }
    
    // We are drawing points from 0 to 360 degrees.
    static final int NUM_POINTS = 720;
    
    // Number of points that we will draw
    int pts_to_draw = 1;
    
    public void drawGraph(Graphics surface)
    {
    	// Get the width and the height of the window we are drawing
    	double width = surface.getClipBounds().getWidth();
    	double height = surface.getClipBounds().getHeight();
        
        // Write the array of points that we would like to draw
        for (int i=0; i<NUM_POINTS; i++)
        {
        	double radians = Math.toRadians(i);
            x[i] = (int)(width/2*Math.sin(3*radians + Math.PI/2) + width/2);
            y[i] = (int)(height/2*Math.sin(2*radians) + height/2);
        }
        
        // Draw the graph
        surface.setColor(Color.RED);
        surface.drawPolyline(x, y, pts_to_draw);
        
        // Increment the number of points that we will draw
        pts_to_draw = (pts_to_draw + 20) % NUM_POINTS;
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        drawGraph(surface);
        for (int i=0; i<box.length; i++)
        	box[i].draw(surface);
    }
} 