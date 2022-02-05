// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.List;
import java.util.Scanner; //for user input 

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area
    private Color[] colorArray = {Color.green, Color.red, Color.blue}; //array to cycle thru colors 
    public FractalDrawer() {}  // contructor

    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas drawing = new Canvas(800,800);
        if (type.equals("1")){ //draw fractal selected 
            drawRectangleFractal(200, 200, 300, 200, colorArray[1], drawing, 3);
            Rectangle calcRectangle = new Rectangle(200, 200, 200, 200);
            this.totalArea = this.totalArea + calcRectangle.calculateArea();
        }
        if (type.equals("2")){
            drawTriangleFractal(200,200,300,450, colorArray[1],drawing, 3);
            Triangle calcTriangle = new Triangle(300, 450, 200, 200);
            this.totalArea = this.totalArea + calcTriangle.calculateArea();
        }
        if (type.equals("3")){
            drawCircleFractal(100, 400, 400, colorArray[1], drawing, 3);
            Circle calcCircle = new Circle(400, 400, 100);
            this.totalArea = this.totalArea + calcCircle.calculateArea();
        }
        return totalArea;
    }
    
    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if (level == 0){ //base case 
            return;
        }
        else{
            Triangle myTriangle = new Triangle(x, y, width, height);
            myTriangle.setColor(c);

            can.drawShape(myTriangle);
            FractalDrawer nextLevel = new FractalDrawer();
            Color nextColor=colorArray[level % 3];
            nextLevel.drawTriangleFractal(width/2, height/2, x-width/2, y, nextColor, can, level-1);//puts smaller (1/2 size of origional triangle) at bottom left
            nextLevel.drawTriangleFractal(width/2, height/2, x+(width/4), y-height, nextColor, can, level-1);//puts smaller (1/2 size of origional triangle) at top center of orig triangle  
            nextLevel.drawTriangleFractal(width/2, height/2, x+width, y, nextColor, can, level-1);//puts smaller (1/2 size of origional triangle) at bottom right of orig triangle 
            this.totalArea = totalArea + myTriangle.calculateArea();
        }
    }
    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level == 0){//base case 
            return;
        }
        else{
            Circle myCircle = new Circle(x, y, radius);
            myCircle.setColor(c);
            totalArea = totalArea + myCircle.calculateArea();
            can.drawShape(myCircle);
            FractalDrawer nextLevel = new FractalDrawer();
            Color nextColor = colorArray[level % 3];
            this.totalArea = this.totalArea + myCircle.calculateArea();   
            nextLevel.drawCircleFractal(radius / 2, x + 1.5 * radius, y, nextColor, can, level-1);
            nextLevel.drawCircleFractal(radius / 2, x, y + 1.5 * radius, nextColor, can, level-1);     
            nextLevel.drawCircleFractal(radius / 2, x - 1.5 * radius, y, nextColor, can, level-1);
            nextLevel.drawCircleFractal(radius / 2, x, y - 1.5 * radius, nextColor, can, level-1);      
        }
    }


/**
 * 
 * @param width
 * @param height
 * @param x
 * @param y
 * @param c
 * @param can
 * @param level
 */
    //TODO: 
 
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level == 0){//base case 
            return;
        }
        else{
            Rectangle myRectangle = new Rectangle(x, y, width, height);
            myRectangle.setColor(c);
            totalArea = totalArea + myRectangle.calculateArea();
            can.drawShape(myRectangle);
            FractalDrawer nextLevel = new FractalDrawer();
            Color nextColor=colorArray[level % 3];
            double divis = 2; // determin how much the size is reduced in the fractal 
            double newWidth = width / divis;
            double newHeight = height / divis;
            nextLevel.drawRectangleFractal(newWidth, newHeight, x + width, y + height, nextColor, can, level-1);
            nextLevel.drawRectangleFractal(newWidth, newHeight, x - (1 / divis) * width, y - (1 / divis) * height, nextColor, can, level-1);
            nextLevel.drawRectangleFractal(newWidth, newHeight, x + width, y - (1 / divis) * height, nextColor, can, level-1);
            nextLevel.drawRectangleFractal(newWidth, newHeight, x - (1 / divis) * width, y + height, nextColor, can, level-1);
            totalArea = totalArea + myRectangle.calculateArea();              
        }
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter 1 for rectangles 2 for triangles 3 for circles \n");
        String userChoice = input.nextLine();
        FractalDrawer test = new FractalDrawer();
        System.out.println(test.drawFractal(userChoice));
    }
}
