import java.awt.Color;
//TODO 
// write to sting and object function?
//Written by Thomas R. Simon simo1159
public class Circle {
    private double xPos = 0;  
    private double yPos = 0;  
    private double radius = 0;//QUESTION when to set stuff public and private?
    private Color color = Color.BLACK;
    public Circle(){}
    public Circle(double x, double y, double r){
        xPos = x;
        yPos = y;
        radius = r;
    }
    public Object Constructor(double x, double y, double r){// QUESTION does the order of our inputs mater could i swap them around to match the order it is in the fractal functions better for consistency 
        Circle result = new Circle();
        xPos = x;
        yPos = y;
        radius = r;// QUESTION is all this necesary? cant i just have public Object Constructor(double xPos, double yPos, double radius){}
        return result;
    }
    //Q do we have to have default constructor?
    public double calculatePerimeter(){
        return 2 * radius * Math.PI; // for how to use pi https://codegym.cc/groups/posts/575-mathpi-in-java
    }
    public double calculateArea(){
        return Math.pow(radius, 2) * Math.PI;

    }
    public void setColor(Color c){
        color=c;
    }
    public void setPos(double x, double y){
        xPos = x;
        yPos = y;
    }
    public void setRadius(double r){
        radius = r;
        
    }
    public Color getColor(){
        return color;
    }   
    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public double getRadius(){
        return radius;
    }
}
