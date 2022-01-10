package p0106;

public class Client {
	public static void main(String[] args) {
		//宣告父代 產生子代
		A obj=new B();	//建構子給B用
	}
}
/*如果父代子代都有建構子 會先跑父代的建構子*/