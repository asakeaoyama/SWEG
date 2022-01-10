package p1230_1;

class D extends C{
	void m1() {	//overriding m1 of C'
		System.out.println("Using m1 od D");
	}
	void m2() {	 //沒有Override (沒有繼承就沒有複寫)
		System.out.println("Using m2 of D");
	}
}
