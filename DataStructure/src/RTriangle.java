import java.util.Scanner;
//import Shape;
public class RTriangle extends Shape{
	private double base;
	private double height;
	public RTriangle() { //constructors
		super("RTriangle");	
	}
	public RTriangle(double base, double height) {	
		super("RTriangle");
		this.base=base;
		this.height=height;
	}
	public double getBase() {
		return base;
	}
	public double getHeight() {
		return height;
	}
	@Override
	public void readShapeData() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the base of the RTriangle");
		base=sc.nextDouble();
		System.out.println("Enter the height of the RTriangle");
		height=sc.nextDouble();
		sc.close();
	}
	@Override
	public double computeArea() {
		return height*base*0.5;
	}
	@Override
	public double computePerimeter() {
		return Math.sqrt(Math.pow(base,2)+Math.pow(height,2))+base+height;
	}
	@Override
	public String toString() {
		return super.toString()+" : base is "+base+", height is "+height+".";
	}
	
	public static void main(String[] args) {
		RTriangle rt =new RTriangle();
		rt.readShapeData();
		System.out.println(rt.toString());
		System.out.println("Area is "+rt.computeArea()+".");
		System.out.println("Perimeter is "+rt.computePerimeter()+".");
	}
}


