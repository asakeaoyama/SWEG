package p0106_2;

public interface If4 {
	void m1();
	void m2();	//public abstract
	void m3();
	void m4();
	void m5();
	void m6();
	void m7();
	void m8();
}
/*假設只會用到其中一個方法
>>Adpater : 接頭把沒用到的disable掉 
>>Ex mouseAdpater
*/

class E implements If4 {	//abstract 不要讓我們new這個東西
	@Override
	public void m1() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m7() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m8() {
		// TODO Auto-generated method stub
	}
}

abstract class Adpater implements If4 {
	@Override
	public void m1() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m6() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m7() {
		// TODO Auto-generated method stub
	}

	@Override
	public void m8() {
		// TODO Auto-generated method stub
	}
}
class F extends Adpater{
		public void m1() {
			System.out.println("hello");
			
		}
}