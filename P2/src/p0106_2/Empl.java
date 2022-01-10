package p0106_2;

abstract public class Empl {
	String id;
	String name;
	abstract int getPay() ;
	public Empl(String id,String name) {
		super();
		this.id=id;
		this.name=name;
	}
}
