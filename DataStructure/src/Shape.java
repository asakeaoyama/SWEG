public abstract class Shape {
	private String shapeName=""; //the name of the shape
	
	public Shape(String shapeName) {	//constructors
		this.shapeName=shapeName; 
	}

	public String getShapeName() {return shapeName;}	//get the kind of shape
	@Override
	public String toString() {return "Shape is a "+shapeName;}	
	// abtract methods
	public abstract double computeArea();
	public abstract double computePerimeter();
	public abstract void readShapeData();
}
