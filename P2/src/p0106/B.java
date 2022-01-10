package p0106;

public class B extends A{
	//子代必須要實作abstract方法>>>Override
	@Override
	void m1() {
		System.out.println("using m1 of B");
	}
	B(){
		//隱含 super();
		System.out.println("using the constructor of B");
	}
	B(String str){
		System.out.println("using the constructor of B "+str);
	}
}
