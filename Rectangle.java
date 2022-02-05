import java.awt.Color;
//TODO 
// write to sting and object function?
/** 
 *
 */
public class Rectangle {
    private double xPos = 0;//QUESTION good var names?
    private double yPos = 0;
    private double width = 0;
    private double height = 0;
    private Color color = Color.BLACK;
    public Rectangle(){}

    public Rectangle(double x, double y, double w,double h){
        xPos = x; 
        yPos = y;
        width = w;
        height = h; 
    }
    /**
     * @param x x val
     * @param y y val
     * @param w width
     * @param h height 
     * @return Rectangle object
     */
    public Object Constructor(double x, double y, double w,double h){ // ? what is the point of this class do i not need it?
        Rectangle result = new Rectangle();
        xPos = x; 
        yPos = y;
        width = w;
        height = h;
        return result;
    }
    
    public double calculatePerimeter(){
        return 2 * width + 2 * height; 
    } 
    public double calculateArea(){
        return width * height;
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
        return xPos; //returns x position of the upper left corner  
    }

    public double getYPos(){
        return yPos; //returns y position of the upper left corner   
    }


    public double getHeight(){
        return height;
    }

   
    public double getWidth(){
        return width;
    }
    
    
}
