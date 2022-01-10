package p1230_1;

public class Sub_1 extends Super_1{
	A m() {	//override
		System.out.println("Using m() of Sub");
		return new B();	//第二種
	}
	//B (){return (B) new A();} run time error //第三種 
}
