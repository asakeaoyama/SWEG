import java.io.BufferedReader;
import java.io.IOException;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1028EX7 {
	public static void main(String[] args) throws IOException {		
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line =buf.readLine();
			if(line.equals("0"))
				break;
			String[] tmp =line.split(" ");
			int[] intArr= new int[tmp.length];
			for(int i=0;i<intArr.length;i++)
				intArr[i]=Integer.parseInt(tmp[i]);
		}
	}
}
