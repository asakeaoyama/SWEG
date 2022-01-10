package p0106_2;

public class HourWorker extends Empl{
	@Override	//子代強制改寫
	int getPay() {
		return 0;
	}
	HourWorker(String id,String name){
		super(id,name);
	}
}
