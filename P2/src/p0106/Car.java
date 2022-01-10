package p0106;

public class Car {
	Engine engine ; //aggregation
	Car(){	//Car從記憶體移走 engine也移走
		engine= new Engine(); //composition 生命週期和Car一樣
	}
}
