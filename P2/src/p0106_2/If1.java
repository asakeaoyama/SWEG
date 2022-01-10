package p0106_2;

public interface If1 {	
	void m1(); //public 
	int a=3;
}
class B implements If1{	
	public void m1() {     //public (default降低visibility)
		System.out.println("using m1");
	};
}