package Human1118_Person1118;
public class Person1118 {
	public static void main(String[] args) {
		Human1118 person1= new Human1118("john");
		person1.weight= 78;
		person1.height=178;
		person1.phone="8989898";
		System.out.println(person1.name+","+person1.phone);
		
		Human1118 person2= new Human1118("jenny",160,48);
		person2.phone= "90909999";
		System.out.println(person2.name+","+person2.phone);
		
		Human1118 person3= new Human1118("kenny",190,88,"0988787878");
		System.out.println(person3.name+","+person3.phone);
	}
}
