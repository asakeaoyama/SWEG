import static org.junit.Assert.*;


import org.junit.Test;

public class StepsTest1 {

	@Test
	public void Test1() {
		Steps Case1= new Steps();
		long output0= Case1.returndiffer(0,0);
		assertEquals(output0,0);
		System.out.println(output0);
		long output1= Case1.returndiffer(1,4);
		assertEquals(output1,3);
		System.out.println(output1);
		long output2= Case1.returndiffer(416726966,955601931);
		assertEquals(output2,538874965);
		System.out.println(output2);
		System.out.println("returndiffer test");
	}
	@Test
	public void Test2() {	//非正常輸入 應該要return -1
		Steps Case2= new Steps();
		long output1= Case2.returndiffer(8989,5);
		assertEquals(output1,-1);
		System.out.println(output1);
		System.out.println("Unnormal case finished.");
	}

}
