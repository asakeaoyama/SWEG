package p1230_2_polymorphic;

public class Client {
	public static void main(String[] args) {
		Animal [] animals = new Animal[3];
		animals[0]= new Dog();
		animals[1]= new Fish();
		animals[2]= new Bird();
		for(int i=0;i<animals.length;i++) {	//自動選擇正確的方法
			animals[i].eat();
			//((Bird)(animals[i])).fly() 強制轉型出現run-time錯誤 
			//以下確保轉型成功
			if(animals[i] instanceof Bird)	//先判斷不是這個class 是的話在轉型
				((Bird)(animals[i])).fly();
			if(animals[i] instanceof Dog)
				((Dog)(animals[i])).bark();
			if(animals[i] instanceof Fish)
				((Fish)(animals[i])).swim();
		}
	}
}
/*
多形 容易擴充 
如果現在新增一個動物pig
不會衝擊到原來的架構
*/
