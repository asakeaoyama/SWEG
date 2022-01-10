package p1223_2;

public class Sub1223 extends Super1223 {
	int v1=2;
	//override
	public void m() {	//不可降低權限
		System.out.println("Using m of Sub Class");
	}
}
