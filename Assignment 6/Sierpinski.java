/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Raashi Maheshwari
 *  NetId: rm1622
 *  Email: rm1622@scarletmail.rutgers.edu
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        double height = ( length * Math.sqrt(3.0) ) / 2.0; 
        return height; 
	// WRITE YOUR CODE HERE

    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {

	// WRITE YOUR CODE HERE

   /* double x1 = x; 
    double x2 = x - length/2; 
    double x3 = x + length/2; 

    double y1 = y; 
    double y2 = y + height(length); 
    double y3 = y + height(length); 

    double [] xx = {x1, x2, x3}; 
    double [] yy = {y1, y2, y3}; 

    StdDraw.filledPolygon(xx, yy); */ //for someone else, the below method works 
    
    double height = height(length); 
    double [] xCoordinates = { x, x - (0.5*(length)), x + (0.5*(length)) }; 
    double [] yCoordinates = { y, y + height, y + height };
     //i think you divide the y by 2 because the next time it's called
    //its called for the smaller triangles to fill up 
    StdDraw.filledPolygon(xCoordinates, yCoordinates); 
    

    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {

	// WRITE YOUR CODE HERE

    if(n == 0) {
        return; 
    }
    else {
        filledTriangle(x, y, length); 
        sierpinski(n - 1, x, y + height(length), length / 2); 
        sierpinski(n - 1, x - (length/2.0), y, length / 2);
        sierpinski(n - 1, x + length/2.0, y, length / 2); 
    }


    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

	// WRITE YOUR CODE HERE  
    int n = Integer.parseInt(args[0]);
    double height = height(1); 
    double [] xOutline = {0.0, 0.5, 1.0}; 
    double [] yOutline = {0.0, height, 0}; 
    StdDraw.polygon(xOutline, yOutline); 
    sierpinski(n, 0.5, 0.0, 0.5);
    }
}
