package p1216;

public class Human1216 {
	int height;	//object level member variable(stack memory)
	static int weight;	//class level
	public Human1216() {}
	void eat() {
		int money;	//local variable(heap memory)
		//System.out.println(money); //為甚麼money這樣不行 因為沒有初始
	}
}

//local v的數量遠遠大於member v，生命週期短暫數量多
//local v初始化(從餐盤回收區拿餐盤,需清洗再用)
//member v 會自動當你洗

