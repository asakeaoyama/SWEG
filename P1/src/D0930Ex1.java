import java.util.ArrayList;
import java.util.List;
public class D0930Ex1 {
	public static void main(String[] args) {
		List<Integer>list=new ArrayList<Integer>();
		list.add(1);
		list.add(6);
		list.add(7);
		for(Integer n: list) { //for...each
			System.out.println(n.getClass());
			System.out.println("value= "+n);
		}
	}
}

