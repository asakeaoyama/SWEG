package p1216;

public class Client1216 {

	public static void main(String[] args) { //static main 合法程式進入點
		Human1216 jenny = new Human1216();	//jenny是物件的reference		//使用Human(使用關係)
		jenny.height=185;
		jenny.weight=55;	//用物件存取 class level 變數 不建議; 應用class存取class-level 
		System.out.println("jenny's weight"+jenny.weight);
		Human1216.weight=90;
		System.out.println(jenny.weight);
		Human1216 kevin= new Human1216();
		kevin.weight=100;
		System.out.println(kevin.weight);
	}
}
