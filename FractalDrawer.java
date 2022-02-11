// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.List;
import java.util.Scanner; //for user input 

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area
    private Color[] colorArray = {Color.green, Color.red, Color.blue}; //array to cycle thru colors 
    public FractalDrawer() {}  // contructor
    // private Rectangle myRectangle = new Rectangle(300, 200, 200, 200);
    // private FractalDrawer nextLevel = new FractalDrawer();
    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas drawing = new Canvas(800,800);
        if (type.equals("1")){ //draw fractal selected 
            drawRectangleFractal(200, 200, 300, 200, colorArray[1], drawing, 4);
            // Rectangle calcRectangle = new Rectangle(200, 200, 200, 200);
            // this.totalArea = this.totalArea + calcRectangle.calculateArea();
        }
        else if (type.equals("2")){
            drawTriangleFractal(200,200,300,450, colorArray[1],drawing, 3);
            Triangle calcTriangle = new Triangle(300, 450, 200, 200);
            this.totalArea = this.totalArea + calcTriangle.calculateArea();
        }
        else if (type.equals("3")){
            drawCircleFractal(100, 400, 400, colorArray[1], drawing, 3);
            Circle calcCircle = new Circle(400, 400, 100);
            this.totalArea = this.totalArea + calcCircle.calculateArea();
        }
        else{
            System.out.println("incorrect input close program and try again");
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
            int newLevel = level - 1;
            nextLevel.drawTriangleFractal(width/2, height/2, x-width/2, y, nextColor, can, newLevel);//puts smaller (1/2 size of origional triangle) at bottom left
            nextLevel.drawTriangleFractal(width/2, height/2, x+(width/4), y-height, nextColor, can, newLevel);//puts smaller (1/2 size of origional triangle) at top center of orig triangle  
            nextLevel.drawTriangleFractal(width/2, height/2, x+width, y, nextColor, can, newLevel);//puts smaller (1/2 size of origional triangle) at bottom right of orig triangle 
            this.totalArea = totalArea + myTriangle.calculateArea();
        }
    }

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
            int newLevel = level - 1;
            nextLevel.drawCircleFractal(radius / 2, x + 1.5 * radius, y, nextColor, can, newLevel);
            nextLevel.drawCircleFractal(radius / 2, x, y + 1.5 * radius, nextColor, can, newLevel);     
            nextLevel.drawCircleFractal(radius / 2, x - 1.5 * radius, y, nextColor, can, newLevel);
            nextLevel.drawCircleFractal(radius / 2, x, y - 1.5 * radius, nextColor, can, newLevel);      
        }
    }


/**
 * 
 * @param width of rectangle 
 * @param height of rectangle 
 * @param x position of bottom left corner of rectangle 
 * @param y position of bottom left corner of rectangle 
 * @param c color of rectangle 
 * @param can class for canvas 
 * @param level of iteration/recursion of the fractal 
 */
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level == 0 || width < 1 || height < 1){//base case 
            return;
        }
        else{
            Rectangle myRectangle = new Rectangle(x, y, width, height);

            // myRectangle.setHeight(height);
            // myRectangle.setWidth(width);
            // myRectangle.setPos(x, y);
            myRectangle.setColor(c);
            // totalArea = totalArea + myRectangle.calculateArea();
            can.drawShape(myRectangle);

            Color nextColor=colorArray[level % 3];
            
            // myRectangle.setColor(nextColor);

            // double newWidth = width / 2;
            // double newHeight = height / 2;
            int newLevel = level - 1;
            drawRectangleFractal(width / 2, height / 2, x + width, y + height, nextColor, can, newLevel);
            drawRectangleFractal(width / 2, height / 2, x - (width / 2), y - (height / 2), nextColor, can, newLevel);
            drawRectangleFractal(width / 2, height / 2, x + width, y - (height / 2), nextColor, can, newLevel);
            drawRectangleFractal(width / 2, height / 2, x - (width / 2), y + height, nextColor, can, newLevel); 
            this.totalArea = this.totalArea + myRectangle.calculateArea();
             
        }
    }


    public static void main(String[] args){
        FractalDrawer test = new FractalDrawer();
        Scanner input = new Scanner(System.in);
        System.out.print("enter 1 for rectangles 2 for triangles 3 for circles \n");
        String userChoice = input.nextLine();
        System.out.println(test.drawFractal(userChoice));
        // System.out.println(test.drawFractal("1"));

    }
}
