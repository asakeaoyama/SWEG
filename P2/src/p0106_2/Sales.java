package p0106_2;

public class Sales extends Empl{
	@Override
	int getPay() {
		return 50000;
	}
	Sales(String id,String name){
		super(id,name);
	}
}
