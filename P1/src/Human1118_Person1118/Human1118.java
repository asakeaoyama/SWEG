package Human1118_Person1118;
public class Human1118 {
	int height;
	int weight;
	String name;
	String phone;
	void eat() {}
	void walk() {}
	
	//建構子
	Human1118(){}
	Human1118(String name){
		this.name= name;
	}
	Human1118(String name, int height,int weight){
		this(name);
		this.height= height;
		this.weight= weight;
	}
	Human1118(String name , int height , int weight, String phone){
		this (name, height, weight);
		this.phone=phone;
	}
}
