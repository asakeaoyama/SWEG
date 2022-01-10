import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StepsTest {
	@Test
	public void TestCase() {	//正常輸入
		Steps Case1= new Steps();
		long output0= Case1.stepoutput(0);
		long output1= Case1.stepoutput(5);
		long output2= Case1.stepoutput(538874965);
		assertEquals(output0,0);
		System.out.println(output0);
		assertEquals(output1,4);
		System.out.println(output1);
		assertEquals(output2,46427);
		System.out.println(output2);
		System.out.println("Normal case finished.");
	}
	@Test
	public void Test1() {	//非正常輸入 應該要return -1
		Steps Case2= new Steps();
		long output1= Case2.stepoutput(-1);
		assertEquals(output1,-1);
		System.out.println(output1);
		System.out.println("Unnormal case finished.");
	}
}
