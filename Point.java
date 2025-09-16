import java.util.*;
public class Point{
    private int x;
    private int y;
    //default constructor
    public Point(int x, int y){
        set(x, y);
    }
    //alternate constructor
     public Point(){
        this(0,0);
    }
    //get X method
    public int getX(){
        return x;
    }
    //get Y method
    public int getY(){
        return y;
    }
    //"print" method to print each point object as (x,y)
    public void printPoint(){
        System.out.print("(" + x + "," + y + ")");
    }
    //method to set coordinates to the parameters passed 
    public void set(int x, int y){
        if (x >= 0){
            this.x = x;
        } else{
            this.x =0;
        }

        if (y >= 0){
            this.y = y;
        } else{
            this.y = 0;
        }
    }
    //toString
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    //equals method to compare 2 point objects for equality
    public boolean equals(Point otherPoint){
        return (this.x == otherPoint.x && this.y == otherPoint.y);
    }

    //copy (take parameter and make current object a copy)
    public void copy(Point otherPoint){
        this.x = otherPoint.x;
        this.y = otherPoint.y;
    }
    //get copy that returns an object
    public Point getCopy(){
        return new Point(x,y);
    }
    //distanceFromOrigin, calculates distance from point and (0,0)
    public double distanceFromOrigin(){
        return Math.sqrt(x*x + y*y);
    }
    //distance method to calclulate distance from point to a given 
    public double distance (Point otherPoint){
        int dx = otherPoint.x - this.x;
        int dy = otherPoint.y - this.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    //translate method (shifts location of point by given amount)
    public void translate(int a, int b){
        this.x += a;
        this.y += b;

        if(this.x < 0){
            System.out.println("ERROR: Should be psotive.");
            this.x=0;
        }
        if(this.y < 0){
            System.out.println("ERROR: Should be positive.");
            this.y = 0;
        }
    }
    //horizantal method that returns true if point lines up horzantly with given point
    public boolean isHorizontal(Point otherPoint){
        if(this.y == otherPoint.y){
            return true;
        }
        else{
            return false;
        }
    }
    //is Vertical method that returns true if given point 
    public boolean isVertical(Point otherPoint){
        if(this.x == otherPoint.x){
            return true;
        }
        else{
            return false;
        }
    }
    //slope method that returns slope of line between objects
    public static void main(String [] args){
        Point p1 = new Point(0,0);
        Point p2 = new Point(7,13);
        Point p3 = new Point(7,15);
        System.out.print("First point: ");
        p1.printPoint();
        System.out.println();
        System.out.print("Second point: ");
        p2.printPoint();
        System.out.println();
        System.out.print("Third point: ");
        p3.printPoint();
        System.out.println();
        if(p2.isHorizontal(p3)){
            System.out.print("Second point: ");
            p2.printPoint();
            System.out.print(" lines up horizontally with third point ");
            p3.printPoint();
        }
        else{
            System.out.print("Second point: ");
            p2.printPoint();
            System.out.print(" does NOT line up horizontally with third point ");
            p3.printPoint();
        }
        System.out.println();
        if(p2.isVertical(p3)){
            System.out.print("Second point: ");
            p2.printPoint();
            System.out.print(" lines up vertically with the third point ");
            p3.printPoint();
        }
        else{
            System.out.print("Second point: ");
            p2.printPoint();
            System.out.print(" does NOT line up vertically with the third point ");
            p3.printPoint();
        }
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the x-coordinate for the first point: ");
        int x = getValidInt(scan);
        System.out.println();
        System.out.print("Enter the y-coordinate for the first point: ");
        int y = getValidInt(scan);
        System.out.println();
        p1.set(x,y);
        System.out.println("The point is now ");
        p1.printPoint();
        System.out.println();
        System.out.print("Distance from origin for first point: ");
        System.out.print(p1.distanceFromOrigin());
        System.out.println();
        System.out.print("Distance from origin for second point: ");
        System.out.print(p2.distanceFromOrigin());
        System.out.println();
        System.out.print("Distance from first point to second point: ");
        System.out.print(p1.distance(p2));
        System.out.println();
        System.out.println("How much do you want to shift the first points x coordinate");
        int xShift = getValidInt(scan);
        System.out.println("How much do you want to shift the first points y coordinate");
        int yShift = getValidInt(scan);
        p1.translate(xShift, yShift);
        System.out.println("First point is now: ");
        p1.printPoint();
        System.out.println();
        System.out.println("How much do you want to shift the second points x coordinate");
        xShift = getValidInt(scan);
        System.out.println();
        System.out.println("How much do you want to shift the second points y coordinate");
        yShift = getValidInt(scan);
        p2.translate(xShift, yShift);
        System.out.println();
        System.out.print("Second point is now: ");
        p2.printPoint();
        System.out.println();
        if(p1.equals(p2)){
            System.out.println("Point 1 and Point 2 are equal");
        }
        else{
            System.out.println("Point 1 and Point 2 are not equal");
        }
        System.out.println("Copying first point.....");
        Point p1Copy = p1.getCopy();
        Point p2Copy = p2.getCopy();


        System.out.println("---Calls to copy and print---");
        System.out.println("First point (after call to copy) is " + p1Copy);
        System.out.println("Second point (after call to copy) is " + p2Copy);


        p2Copy.copy(p1Copy);

        System.out.println("---Call to equals after call to copy: " ); 
        if(p1Copy.equals(p2Copy)){
            System.out.println("The points are equal");
        }
        else{
            System.out.println("The points are not equal");
        }
    }
    private static int getValidInt(Scanner scan) {
    int val;
    while (true) {
        if(scan.hasNextInt()) {
            val = scan.nextInt();
            if(val >= 0) break;
            else System.out.println("ERROR! Should be positive.");
        } else {
            System.out.println("Not an integer! Try again!");
            scan.next(); // discard invalid input
        }
    }
    return val;
}
}