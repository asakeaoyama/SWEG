package p1223_override;

public class Sub1223_override_1 extends Super1223_override_1{
	void m1() {	//override
		System.out.println("Using m1 for Sub");
	}
	void m1(String str) {	//overload
		System.out.println("Using overload for "+str);
	}
	int v1=2;
}
