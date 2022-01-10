package p0106;

abstract public class A {
	abstract void m1() ;
	void m2() {
		//body
		System.out.println("using m2 of A");
	}
	A(){
		System.out.println("constructor of a");
	}
}
