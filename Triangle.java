import java.awt.Color;
//TODO 
// write to sting and object function?
public class Triangle {
    private double xPos = 0;//QUESTION good var names?
    private double yPos = 0;
    private double width = 0;
    private double height = 0;
    private Color color = Color.RED;
    public Triangle(){}
    public Triangle(double x, double y, double w,double h){
        xPos = x; 
        yPos = y;
        width = w;
        height = h;
    }

    // public Object Constructor(double x, double y, double w,double h){
    //     Triangle result = new Triangle();
    //     xPos = x; 
    //     yPos = y;
    //     width = w;
    //     height = h;
    //     return result;
    // }
    public double calculatePerimeter(){

        return width + 2 * Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2) / 4); 
    } 
    public double calculateArea(){
        return .5 * width * height;
    }
    public void setColor(Color c){
        color=c;
    }
    public void setPos(double x, double y){
        xPos = x; 
        yPos = y;
    }
    public void setHeight(double h){
        height = h;
    }
    public void setWidth(double w){
        width = w;
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
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }

    public static void main(String[] args) {
        Triangle test = new Triangle(0, 0, 3, 4);
        // test.Constructor(0, 0, 3, 4);
        System.out.print(test.calculatePerimeter());
    }
}
