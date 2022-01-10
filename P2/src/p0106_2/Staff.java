package p0106_2;

public class Staff extends Empl {
	@Override
	int getPay() {
		return 30000;
	}
	Staff(String id,String name){
		super(id,name);
	}
}
